package com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.despesas;

import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.dominio.Despesa;
import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.exception.CamaraClientStatusException;
import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.http.CamaraClient;
import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.http.ConstantesApiCamara;
import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.http.Pagina;

import java.io.IOException;

public class DespesasClient extends CamaraClient {

    public Pagina<Despesa> consultar(ConsultaDespesas consulta) throws IOException, InterruptedException, CamaraClientStatusException {
        String[] segmentosPath = new String[]{String.valueOf(consulta.getIdDeputado()), "despesas"};
        return consultarComPaginacao(consulta, ConstantesApiCamara.DEPUTADO_API_URL, Despesa.class, segmentosPath);
    }

    private Pagina<Despesa> consultarComPaginacao(ConsultaDespesas consulta, String deputadoApiUrl, Class<Despesa> despesaClass, String[] segmentosPath) {
        return null;
    }
}
