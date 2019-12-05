package com.crud.juegos.modelo.servicio;

import com.crud.juegos.modelo.entidad.Juego;
import com.crud.juegos.modelo.repositorio.juegoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Clase para realizar el CRUD en la base de datos
 */
@Service
public class JuegoServicioImpl implements juegoServicio {

    @Autowired
    private juegoRepositorio repositorio;

    /**
     * En lista los objetos
     * @return los objetos de la base de datos
     */
    @Override
    public List<Juego> juegos() {
        return (List<Juego>) repositorio.findAll();
    }

    /**
     * Realiza el guardado en la base de datos
     * @param juego
     */
    @Override
    public void guardar(Juego juego) {
        repositorio.save(juego);
    }

    /**
     * Busca un elemento especifico en la base de datos
     * @param id el id del elemento a buscar
     * @return objecto encontrado
     */
    @Override
    public Juego buscar(int id) {
        return repositorio.findById(id).orElse(null);
    }

    /**
     * Elimina un objecto especifico
     * @param id id del elemento a eliminar
     */
    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }
}
