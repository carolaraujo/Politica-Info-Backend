package com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.json;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class LocalDateDeserializer implements JsonDeserializer<LocalDate> {

    private static final String SEPARADOR_DATA = "-";

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String dataString = json.getAsString();
        String[] split = dataString.split(SEPARADOR_DATA);
        int ano = Integer.parseInt(split[0]);
        int mes = Integer.parseInt(split[1]);
        int dia = Integer.parseInt(split[2]);
        return LocalDate.of(ano, mes, dia);
    }
}
