package com.desafio.reto.Services;

public interface IConvertidor {
   <T> T consumirApi(String json, Class <T> clase);

}
