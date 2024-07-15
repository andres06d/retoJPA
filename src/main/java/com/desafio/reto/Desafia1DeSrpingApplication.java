package com.desafio.reto;

import com.desafio.reto.repository.LibroRepository;
import com.desafio.reto.repository.PersonaRepository;
import com.desafio.reto.vista.Ejecutar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Desafia1DeSrpingApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository repository;
	@Autowired
	private PersonaRepository personaRepository;
	public static void main(String[] args) {
		SpringApplication.run(Desafia1DeSrpingApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		Ejecutar eje = new Ejecutar(repository,personaRepository);

		eje.ejecutar();
	}
}
