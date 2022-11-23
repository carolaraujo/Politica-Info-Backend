package com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.http;

public class ConstantesApiCamara {

    private ConstantesApiCamara() throws IllegalAccessException{
        throw new IllegalAccessException("Essa classe não deve ser instanciada");
    }

    public static final String CABECALHO_TOTAL_ITENS = "x-total-count";

    public static final String BASE_URL = "https://dadosabertos.camara.leg.br/api/v2";

    //Busca de Bloco por ID ão está funcionando
    public static final String BLOCOS_API_URL = BASE_URL + "/blocos";

    public static final String DEPUTADO_API_URL = BASE_URL + "/deputados";

    public static final String PARTIDOS_API_URL = BASE_URL + "/partidos";

    //Busca de Referencias não está funcionando
    public static final String REFERENCIAS_API_URL = BASE_URL + "/referencias";

    public static final String VOTAÇÕES_API_URL = BASE_URL + "/votacoes";

    public static final String ORGAOS_API_URL = BASE_URL + "/orgaos";

    //Validar com o grupo se iremos mesmo usar todos esses endpoints
}
