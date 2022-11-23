package com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.http;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RespostaCamara<T> {

    private Map<String, List<String>> cabecalhos = new HashMap<>();

    private final T dados;

    private int statusCode;

    public RespostaCamara(T dados){
        this.dados = dados;
    }

    public T getDados(){
        return dados;
    }

    public void setCabecalhos(Map<String, List<String>> cabecalhos){
        this.cabecalhos = cabecalhos;
    }

    public Map<String, List<String>> getCabecalhos(){
        return cabecalhos;
    }

    public Optional<String> getPrimeiroValorCabecalho(String nomeCabecalho){
        List<String> valores = cabecalhos.get(nomeCabecalho);
        if (valores != null){
            return Optional.ofNullable(valores.get(0));
        }
        return Optional.empty();
    }

    public int getStatusCode(){
        return statusCode;
    }

    public void setStatusCode(int statusCode){
        this.statusCode = statusCode;
    }
}
