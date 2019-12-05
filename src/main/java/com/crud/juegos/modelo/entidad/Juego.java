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

    /**
     *
     * @return obtiene el Id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id set la variable Id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return obtiene el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre set la variable nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return obtiene la variable descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion set la variable descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return el año de lanzamiento
     */
    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    /**
     *
     * @param anioLanzamiento set de la variable año de lanzamiento
     */
    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }

    /**
     *
     * @return obtiene categoria
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     *
     * @param categoria cambia la variable caterogia
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     *
     * @return obtiene los datos de descargas
     */
    public int getDescargas() {
        return descargas;
    }

    /**
     *
     * @param descargas Cambia los datos de descargas
     */
    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }
}
