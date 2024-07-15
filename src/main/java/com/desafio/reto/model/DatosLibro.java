package com.desafio.reto.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)

public record DatosLibro(
        @JsonAlias("count")         Integer totalDeLibros,
        @JsonAlias("next") String siguiente,
        @JsonAlias("results") ArrayList<DatosResultado> libros

) {
}
