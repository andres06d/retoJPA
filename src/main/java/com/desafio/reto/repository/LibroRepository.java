package com.desafio.reto.repository;

import com.desafio.reto.model.LibroClase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<LibroClase,Long> {


}
