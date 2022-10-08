package com.faculdadeImpacta.politicainfobackend.despesas;

import com.faculdadeImpacta.politicainfobackend.dominio.Despesa;
import com.faculdadeImpacta.politicainfobackend.exception.CamaraClientStatusException;
import com.faculdadeImpacta.politicainfobackend.http.CamaraClient;
import com.faculdadeImpacta.politicainfobackend.http.ConstantesApiCamara;
import com.faculdadeImpacta.politicainfobackend.http.Pagina;

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
