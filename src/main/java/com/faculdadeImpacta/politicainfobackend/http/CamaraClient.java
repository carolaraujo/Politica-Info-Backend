package com.faculdadeImpacta.politicainfobackend.http;


import com.faculdadeImpacta.politicainfobackend.despesas.ConsultaDespesas;
import com.faculdadeImpacta.politicainfobackend.exception.CamaraClientStatusException;
import com.faculdadeImpacta.politicainfobackend.exception.RecursoNaoExisteException;
import com.faculdadeImpacta.politicainfobackend.exception.RespostaInesperadaException;
import com.faculdadeImpacta.politicainfobackend.json.GsonSingleton;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CamaraClient<T> {

    protected final HttpClient client;

    public CamaraClient(HttpClient client) {
        this.client = client;
    }

    public CamaraClient() {
        this.client = HttpClient
                .newBuilder()
                .build();
    }

    protected <T> RespostaCamara<T> executarChamada(HttpRequest requisicao, Type tipoResposta) throws IOException, InterruptedException, CamaraClientStatusException {
        HttpResponse<String> resposta = client.send(requisicao, HttpResponse.BodyHandlers.ofString());
        if (resposta.statusCode() == 404) {
            RespostaCamara<T> resultadoVazio = new RespostaCamara<>(null);
            resultadoVazio.setCabecalhos(resposta.headers().map());
            resultadoVazio.setStatusCode(resposta.statusCode());
            return resultadoVazio;
        }
        if (resposta.statusCode() != 200) {
            throw new CamaraClientStatusException(resposta.statusCode(),
                    resposta.body() != null ? resposta.body() : null);
        }
        String body = resposta.body();
        if (body == null) {
            String mensagem = String.format("A resposta é null e o tipo esperado é %s.", tipoResposta.getTypeName());
            throw new RespostaInesperadaException(mensagem);
        }
        Type tipoEmbrulhado = TypeToken.getParameterized(RespostaCamara.class, tipoResposta).getType();
        RespostaCamara<T> resultado = GsonSingleton.getInstancia().fromJson(body, tipoEmbrulhado);
        resultado.setCabecalhos(resposta.headers().map());
        resultado.setStatusCode(resposta.statusCode());
        return resultado;
    }

    protected int extrairCabecalhoTotalItens(RespostaCamara resposta) {
        if (resposta.getCabecalhos() == null) {
            throw new RespostaInesperadaException("O objeto de resposta da câmara não tem cabeçalhos.");
        }
        Optional<String> valorCabecalhoOpt = resposta.getPrimeiroValorCabecalho(ConstantesApiCamara.CABECALHO_TOTAL_ITENS);
        if (valorCabecalhoOpt.isEmpty() || valorCabecalhoOpt.get().isBlank()) {
            throw new RespostaInesperadaException("Uma consulta páginada esperava o cabeçalho x-total-count do número total de itens, mas ele está vazio.");
        }
        return Integer.parseInt(valorCabecalhoOpt.get());
    }

    protected <T> RespostaCamara<T> consultarPorId(String id, String urlBase, Type tipoEsperado) throws IOException, InterruptedException, CamaraClientStatusException {
        return executarChamada(new RequisicaoBuilder(urlBase).segmentosPath(id).build(), tipoEsperado);
    }

    protected <T> List<T> consultarSemPaginacao(Consulta consulta, String urlBase, Type tipoEsperado, String... segmentosPath) throws IOException, InterruptedException, CamaraClientStatusException {
        RespostaCamara<List<T>> resposta = executarConsulta(consulta, urlBase, tipoEsperado, segmentosPath);
        return resposta.getDados();
    }
//
//    protected <T> Pagina<T> consultarComPaginacao(ConsultaDespesas consulta, String urlBase, Type tipoEsperado, String... segmentosPath) throws IOException, InterruptedException, CamaraClientStatusException {
//        RespostaCamara<List<T>> resposta = executarConsulta(consulta, urlBase, tipoEsperado, segmentosPath);
//        return new Pagina<>(resposta.getDados(),
//                extrairCabecalhoTotalItens(resposta),
//                extrairPaginaDaConsulta(consulta));
//    }

    private <T> RespostaCamara<List<T>> executarConsulta(Consulta consulta, String urlBase, Type tipoEsperado, String... segmentosPath) throws IOException, InterruptedException, CamaraClientStatusException {
        HttpRequest requisicao = prepararConsulta(consulta, urlBase, segmentosPath);
        RespostaCamara<List<T>> resposta = executarChamada(requisicao, TypeToken.getParameterized(List.class, tipoEsperado).getType());
        if (resposta.getStatusCode() == 404) {
            throw new RecursoNaoExisteException("O recurso solicitado não existe: " + requisicao.uri().toString());
        }
        return resposta;
    }

    private HttpRequest prepararConsulta(Consulta consulta, String urlBase, String... segmentosPath) {
        Objects.requireNonNull(consulta, "O objeto de consulta não pode ser null. Favor utilizar um objeto vazio se desejar uma consulta sem parâmetros.");
        return new RequisicaoBuilder(urlBase)
                .consulta(consulta)
                .segmentosPath(segmentosPath)
                .build();
    }

    private int extrairPaginaDaConsulta(Consulta consulta) {
        String paginaString = consulta.getParametros().get("pagina");
        if (paginaString == null || paginaString.isBlank()) {
            paginaString = "1";
        }
        return Integer.parseInt(paginaString);
    }

}
