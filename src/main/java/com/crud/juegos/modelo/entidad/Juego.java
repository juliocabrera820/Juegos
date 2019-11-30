package com.crud.juegos.modelo.entidad;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Juego {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    @NotBlank(message = "Debes ingresar un nombre")
    private String nombre;
    @Column
    @NotBlank(message = "Debes ingresar una descripcion")
    private String descripcion;
    @Column(name = "anio")
    @NotNull(message = "Debes ingresar un año de lanzamiento")
    private int anioLanzamiento;
    @Column
    private String categoria;
    @Column
    @NotNull(message = "Debes ingresar un precio")
    @PositiveOrZero(message = "Ingresar un precio mayor o igual 0 pesos")
    private int descargas;

    public Juego() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }
}
