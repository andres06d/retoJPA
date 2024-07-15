package com.desafio.reto.model;

import com.desafio.reto.Services.AttributeExtractor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libro")
public class LibroClase {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private int identificadorApi;
    @Column(unique = true)
    private String Titulo;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<PersonaClase> autor;
    private String idiomas;
    private String formatoLibro;
    private int cantidadDeDescargas;

    public LibroClase(DatosResultado resultado) {
        identificadorApi = resultado.numeroLibro();
        Titulo = resultado.titulo();
        this.autor = resultado.autores().stream()
                .map(PersonaClase::new)
                .toList();
        this.idiomas = String.join(",", resultado.leguajes());
        this.formatoLibro = resultado.tipo();
        this.cantidadDeDescargas = resultado.cantidadDeDescargas();
    }

    public LibroClase() {

    }

    public static <T> String obtenerElementos(ArrayList<T> datos, AttributeExtractor<T> extractor) {
        StringBuilder resultado = new StringBuilder();
        for (T dato : datos) {
            resultado.append(extractor.extract(dato));
        }
        return resultado.toString();
    }

    @Override
    public String toString() {
        return String.format("""
                -----------------------
                |Datos del libro - %s
                |Numero del libro: %d
                |Autores: %s
                |Idioma: %s
                |Formato del libro: %s
                |Numero de descargas: %d
                -------------------------
                """, Titulo, identificadorApi, autor.get(0).getNombre(), idiomas,
                formatoLibro, cantidadDeDescargas
        );

    }

    public int getIdentificadorApi() {
        return identificadorApi;
    }

    public void setIdentificadorApi(int identificadorApi) {
        this.identificadorApi = identificadorApi;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public List<PersonaClase> getAutor() {
        return autor;
    }

    public void setAutor(List<PersonaClase> autor) {
        this.autor = autor;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getFormatoLibro() {
        return formatoLibro;
    }

    public void setFormatoLibro(String formatoLibro) {
        this.formatoLibro = formatoLibro;
    }

    public int getCantidadDeDescargas() {
        return cantidadDeDescargas;
    }

    public void setCantidadDeDescargas(int cantidadDeDescargas) {
        this.cantidadDeDescargas = cantidadDeDescargas;
    }
}
