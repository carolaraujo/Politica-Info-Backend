package com.faculdadeImpacta.politicainfobackend.json;

import com.faculdadeImpacta.politicainfobackend.dominio.Deputado;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
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
