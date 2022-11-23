package com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.json;

import com.faculdadeImpacta.politicainfobackend.apiCamaraDeputados.dominio.Deputado;
import com.google.gson.*;

import java.lang.reflect.Type;

public class DeputadoDeserializer implements JsonDeserializer<Deputado>{

    private final Gson gson = new Gson();

    @Override
    public Deputado deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = (JsonObject) json;
        JsonElement ultimoStatusElement = jsonObject.get("ultimoStatus");
        if (ultimoStatusElement != null) {
            json = ultimoStatusElement;
        }
        return gson.fromJson(json, Deputado.class);
    }
}
