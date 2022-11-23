package com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.json;

import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.dominio.Deputado;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GsonSingleton {

    private static Gson instancia;

    public static Gson getInstancia() {
        if (instancia == null) {
            GsonBuilder builder = new GsonBuilder();
            builder.registerTypeAdapter(LocalDate.class, new LocalDateDeserializer());
            builder.registerTypeAdapter(Deputado.class, new DeputadoDeserializer());
            builder.registerTypeAdapter(LocalDateTime.class, new LocalDateDeserializer());
            instancia = builder.create();
        }
        return instancia;
    }
}
