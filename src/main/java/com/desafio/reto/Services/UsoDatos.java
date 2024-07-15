package com.desafio.reto.Services;

import com.desafio.reto.model.DatosLibro;
import com.desafio.reto.model.LibroClase;

import java.util.ArrayList;
import java.util.List;

public class UsoDatos {
    private TransformarDatos convertidor = new TransformarDatos();
    private ConsumirApi consumir = new ConsumirApi();
    final String urlApi = "https://gutendex.com/";
    List<DatosLibro> resultado = new ArrayList<DatosLibro>();


    public DatosLibro obtenerLibros(String url) {
        String json = consumir.obtenerDatos(urlApi + url);
        DatosLibro datos = convertidor.consumirApi(json, DatosLibro.class);

        return datos;
    }

    public List<LibroClase> mostarTodosLosLibros(int numeroPagina) {
        resultado.add(obtenerLibros("books/"));
        int i = 2;
        while (!resultado.get(i - 2).siguiente().equalsIgnoreCase("null") & i < numeroPagina+1) {
            resultado.add(obtenerLibros("books/?page=" + i));
            i++;
        }

        List<LibroClase> datosPersona = resultado.stream()
                .flatMap(t -> t.libros().stream().map(LibroClase::new))
                .toList();

        return datosPersona;
    }

    public List<LibroClase> mostarTop10Libros() {
        resultado.add(obtenerLibros("books/?download_count=ascending"));

              List<LibroClase> datosPersona = resultado.stream()
                .flatMap(t -> t.libros().stream().map(LibroClase::new))
                .limit(10)
                .toList();

        return datosPersona;
    }
    public List<LibroClase> buscarLibro(String titulo) {

        String imput =titulo.replace(" ","%20");
        resultado.add(obtenerLibros("books/?search="+imput));

        List<LibroClase> datosPersona = resultado.stream()
                .flatMap(t -> t.libros().stream().map(LibroClase::new))
                .toList();

        return datosPersona;
    }

}
