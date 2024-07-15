package com.desafio.reto.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosPersona(
        @JsonAlias("name")      String nombre,
        @JsonAlias("birth_year")  Integer anoDeNacimiento,
        @JsonAlias("death_year")  Integer anoDeFallecimiento
) {
}
