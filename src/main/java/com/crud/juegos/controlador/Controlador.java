package com.crud.juegos.controlador;

import com.crud.juegos.modelo.entidad.Juego;
import com.crud.juegos.modelo.servicio.JuegoServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class Controlador {

    @Autowired
    private JuegoServicioImpl juegoServicio;
    private List<String> categorias;

    /**
     * Elementos de la lista de categorias
     */
    public Controlador() {
        categorias = Arrays.asList("Terror","Accion","Aventura","Carrera","Indie","Deportes","Estrategia");
    }

    /**
     *
     * @param model permite colocar datos a la vista
     * @return la vista al index si se realiza la accion o formulario si no
     */
    @GetMapping("/")
    public String all(Model model){
        List<Juego> juegos = juegoServicio.juegos();
        model.addAttribute("juegos",juegos);
        return ("index");
    }

    /**
     *
     * @param model permite colocar datos a la vista
     * @return la vista al index si se realiza la accion o formulario si no
     */
    @GetMapping("/crear")
    public String create(Model model){
        Juego juego = new Juego();
        model.addAttribute("titulo","Crear Juego");
        model.addAttribute("juego",juego);
        model.addAttribute("categorias",categorias);
        return "formulario";
    }

    /**
     *
     * @param juego elemento a guardar en la base de datos
     * @param bindingResult
     * @param model permite colocar datos a la vista
     * @return la vista al index si se realiza la accion o formulario si no
     */
    @PostMapping(value = "/guardar")
    public String save(@Valid @ModelAttribute Juego juego, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()){
            model.addAttribute("juego",juego);
            model.addAttribute("categorias",categorias);
            return "/formulario";
        }
        juegoServicio.guardar(juego);
        return "redirect:/";
    }

    /**
     *
     * @param model permite colocar datos a la vista
     * @param id id del elemento a modificar
     * @return la vista al index si se realiza la accion o formulario si no
     */
    @GetMapping("/editar/{id}")
    public String edit(Model model, @PathVariable("id") int id){
        Optional<Juego> juegoOp = Optional.ofNullable(juegoServicio.buscar(id));
        if(juegoOp.isPresent()){
            model.addAttribute("titulo","Editar Juego");
            Juego juego = juegoServicio.buscar(id);
            model.addAttribute("juego",juego);
            model.addAttribute("categorias",categorias);
            return "formulario";
        }
        return "redirect:/";
    }

    /**
     *
     * @param id id del elementos a eliminar
     * @return la vista al index si se realiza la accion o formulario si no
     */
    @GetMapping("/eliminar/{id}")
    public String delete(@PathVariable("id") int id){
        Optional<Juego> juego = Optional.ofNullable(juegoServicio.buscar(id));
        if (juego.isPresent()){
            juegoServicio.eliminar(id);
            return "redirect:/";
        }
        return "redirect:/";
    }
}
