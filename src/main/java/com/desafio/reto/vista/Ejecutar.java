package com.desafio.reto.vista;


import com.desafio.reto.Services.UsoDatos;
import com.desafio.reto.model.LibroClase;
import com.desafio.reto.model.PersonaClase;
import com.desafio.reto.repository.LibroRepository;
import com.desafio.reto.repository.PersonaRepository;

import java.util.*;
import java.util.stream.Collectors;

public class Ejecutar {
    private LibroRepository respositorio;
    private PersonaRepository respositorioPersona;

    private Scanner teclado = new Scanner(System.in);

    public Ejecutar(LibroRepository respositorio, PersonaRepository persona) {
        this.respositorio = respositorio;
        this.respositorioPersona = persona;
    }

    public void ejecutar() {
        UsoDatos u = new UsoDatos();
        int resultado = 0;
        List<LibroClase> datosAMostrar = new ArrayList<LibroClase>();
        try {
            while (true) {
                System.out.println("""
                        Digite el numero correspondiente a la opcion  que desee
                                               
                        1- buscar libro por titulo
                        2- listar libros registrados
                        3- listar autores registrados
                        4- listar autores vivos en determinado año
                        5- listar libros por idioma
                        6- llenar libros automaticos
                        0- salir
                                                
                                                
                        """);
                resultado = Integer.parseInt(teclado.next());
                if (resultado == 0) {
                    break;
                }
                switch (resultado) {


                    case 1:
                        System.out.println("Por favor digite el titulo del libro que desea buscar");
                        String busqueda = teclado.next();


                        datosAMostrar = u.buscarLibro(busqueda);

                        if (!datosAMostrar.isEmpty()) {
                            Optional<LibroClase> libroBuscado = datosAMostrar.stream()
                                    .filter(l -> l.getTitulo().toUpperCase().contains(busqueda.toUpperCase()))
                                    .findFirst();

                            if (libroBuscado.isPresent()) {
                                //    System.out.println(libroBuscado.get().toString());
                                respositorio.save(libroBuscado.get());

                            } else {
                                System.out.println("No se encontraron resultados.\n");
                            }
                        } else {
                            System.out.println("No se encontraron resultados.\n");
                        }
                        break;
                    case 2:
                        System.out.println("Lista de libros registrados");
                        List<LibroClase> datos = respositorio.findAll();
                        if (!datos.isEmpty()) {
                            datos.forEach(l -> System.out.println(l.toString()));
                        }
                        break;
                    case 3:
                        System.out.println("Lista de autores");
                        List<PersonaClase> datos2 = respositorioPersona.findAll();
                        if (!datos2.isEmpty()) {
                            datos2.forEach(l -> System.out.println(l.toString()));
                        }
                        break;
                    case 4:
                        System.out.println("Lista de autores");
                        System.out.println("Digite la fecha para ver que autores estaban vivos, unicamente el año");
                        int fecha = teclado.nextInt();
                        System.out.println("fecha: " + fecha);
                        List<PersonaClase> datos3 = respositorioPersona.findAll();
                        if (!datos3.isEmpty()) {

                            List<PersonaClase> datos4 = datos3.stream()
                                    .filter(j -> j.getAnoDeFallecimiento() != null)
                                    .filter(e -> (e.getAnoDeFallecimiento() - fecha) < 0)
                                    .toList();
                            if (!datos4.isEmpty()
                            ) {
                                datos4.forEach(l -> System.out.println(l.toString()));
                            } else {
                                System.out.println("No se encontraron autores vivivo en " + fecha + "\n");
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Lista de libros registrados ordenados por idioma");
                        List<LibroClase> datos5 = respositorio.findAll().stream()
                                .sorted(Comparator.comparing(LibroClase::getIdiomas))
                                .toList();
                        System.out.println("Tamaño: " + datos5.size());

                        if (!datos5.isEmpty()) {
                            String idiomaActual = datos5.get(0).getIdiomas();
                            System.out.println("El idioma de los libros es: " + idiomaActual);

                            for (LibroClase libro : datos5) {
                                if (!libro.getIdiomas().equalsIgnoreCase(idiomaActual)) {
                                    idiomaActual = libro.getIdiomas();
                                    System.out.println("El idioma de los libros es: " + idiomaActual);
                                }
                                System.out.println(libro.toString());
                            }
                        }

                        break;

                    case 6:
                        System.out.println("Por favor digite numero de paginas");
                        int paginas = teclado.nextInt();

                        datosAMostrar = u.mostarTodosLosLibros(paginas);

                        for (LibroClase libro : datosAMostrar) {
                            respositorio.save(libro);

                        }

                        break;
                }

            }
        } catch (NumberFormatException e) {
            System.out.println("Unicamente se puede digitar datos de tipo numerico");
        }


    }
}
