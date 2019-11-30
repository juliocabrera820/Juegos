package com.crud.juegos.modelo.servicio;

import com.crud.juegos.modelo.entidad.Juego;
import com.crud.juegos.modelo.repositorio.juegoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JuegoServicioImpl implements juegoServicio {
    @Autowired
    private juegoRepositorio repositorio;
    @Override
    public List<Juego> juegos() {
        return (List<Juego>) repositorio.findAll();
    }

    @Override
    public void guardar(Juego juego) {
        repositorio.save(juego);
    }

    @Override
    public Juego buscar(int id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }
}
