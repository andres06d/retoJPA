package com.desafio.reto.repository;

import com.desafio.reto.model.PersonaClase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository  extends JpaRepository<PersonaClase, Long> {

}
