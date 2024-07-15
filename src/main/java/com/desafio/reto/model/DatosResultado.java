package com.desafio.reto.model;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosResultado(
        @JsonAlias("id")        Integer numeroLibro,
        @JsonAlias("title")        String titulo,
        @JsonAlias("authors")        ArrayList<DatosPersona> autores,
        @JsonAlias("languages")        ArrayList<String> leguajes,
        @JsonAlias("media_type")         String tipo,
        @JsonAlias("download_count")         Integer cantidadDeDescargas

) {
}
