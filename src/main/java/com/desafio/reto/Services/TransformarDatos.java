package com.desafio.reto.Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TransformarDatos implements IConvertidor {

    private ObjectMapper mapeador=new ObjectMapper();

    @Override
    public <T> T consumirApi(String json, Class<T> clase) {

        try {
            return mapeador.readValue(json, clase);
        } catch (JsonProcessingException e){
            return null;

        }

    }
}
