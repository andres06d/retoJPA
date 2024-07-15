package com.desafio.reto.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "persona")
public class PersonaClase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String nombre;
    private Integer anoDeNacimiento;
   private  Integer anoDeFallecimiento;


    public PersonaClase(DatosPersona persona) {
        this.nombre = persona.nombre();
        this.anoDeNacimiento = persona.anoDeNacimiento();
        this.anoDeFallecimiento = persona.anoDeFallecimiento();
    }

    public PersonaClase() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnoDeNacimiento() {
        return anoDeNacimiento;
    }

    public void setAnoDeNacimiento(Integer anoDeNacimiento) {
        this.anoDeNacimiento = anoDeNacimiento;
    }

    public Integer getAnoDeFallecimiento() {
        return anoDeFallecimiento;
    }

    public void setAnoDeFallecimiento(Integer anoDeFallecimiento) {
        this.anoDeFallecimiento = anoDeFallecimiento;
    }

    @Override
    public String toString() {
        return """
            ___________
            |Autor
            |nombre='%s',
            |anoDeNacimiento=%d,
            |anoDeFallecimiento=%d
            |__________________ 
        """.formatted(nombre, anoDeNacimiento, anoDeFallecimiento);
    }
}
