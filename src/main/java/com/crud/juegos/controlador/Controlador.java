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

    public Controlador() {
        categorias = Arrays.asList("Terror","Accion","Aventura","Carrera","Indie","Deportes","Estrategia");
    }

    @GetMapping("/")
    public String all(Model model){
        List<Juego> juegos = juegoServicio.juegos();
        model.addAttribute("juegos",juegos);
        return ("index");
    }

    @GetMapping("/crear")
    public String create(Model model){
        Juego juego = new Juego();
        model.addAttribute("titulo","Crear Juego");
        model.addAttribute("juego",juego);
        model.addAttribute("categorias",categorias);
        return "formulario";
    }

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
