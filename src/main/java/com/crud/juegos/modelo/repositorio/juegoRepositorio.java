package com.crud.juegos.modelo.repositorio;

import com.crud.juegos.modelo.entidad.Juego;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Implementa los metodos para realizar el CRUD en la base de datos
 */
@Repository
public interface juegoRepositorio extends CrudRepository<Juego,Integer> {
}
