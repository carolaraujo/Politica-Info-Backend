package com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.exception;

public class CamaraClientStatusException extends Throwable {

    private final int statusCode;

    private final String corpoResposta;

    public CamaraClientStatusException(int statusCode, String corpoResposta) {
        this.statusCode = statusCode;
        this.corpoResposta = corpoResposta;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getCorpoResposta() {
        return corpoResposta;
    }

    @Override
    public String toString() {
        return "CamaraClientStatusException{" +
                "statusCode=" + statusCode +
                ", resposta='" + corpoResposta + '\'' +
                '}';
    }
}
