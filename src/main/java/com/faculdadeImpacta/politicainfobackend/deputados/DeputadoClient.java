package com.faculdadeImpacta.politicainfobackend.deputados;

import com.faculdadeImpacta.politicainfobackend.dominio.Deputado;
import com.faculdadeImpacta.politicainfobackend.exception.CamaraClientStatusException;
import com.faculdadeImpacta.politicainfobackend.http.CamaraClient;
import com.faculdadeImpacta.politicainfobackend.http.ConstantesApiCamara;
import com.faculdadeImpacta.politicainfobackend.http.Pagina;
import com.faculdadeImpacta.politicainfobackend.http.RespostaCamara;

import java.io.IOException;
import java.util.Optional;

public class DeputadoClient extends CamaraClient {

    public Optional<Deputado> consultarDeputadoPorId(int id) throws IOException, InterruptedException, CamaraClientStatusException {
        RespostaCamara<Deputado> resposta = consultarPorId(String.valueOf(id), ConstantesApiCamara.DEPUTADO_API_URL, Deputado.class);
        return Optional.ofNullable(resposta.getDados());
    }

    public Pagina<Deputado> consultar(ConsultaDeputado consulta) throws IOException, InterruptedException, CamaraClientStatusException {
        return consultarComPaginacao(consulta, ConstantesApiCamara.DEPUTADO_API_URL, Deputado.class);
    }

    private Pagina<Deputado> consultarComPaginacao(ConsultaDeputado consulta, String deputadoApiUrl, Class<Deputado> deputadoClass) {
        return null;
    }
}
