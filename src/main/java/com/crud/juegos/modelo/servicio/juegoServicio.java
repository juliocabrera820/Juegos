package com.crud.juegos.modelo.servicio;

import com.crud.juegos.modelo.entidad.Juego;
import java.util.List;

/**
 * Metodos para realizar el CRUD
 */
public interface juegoServicio {
    public List<Juego> juegos();
    public void guardar(Juego juego);
    public Juego buscar(int id);
    public void eliminar(int id);
}
