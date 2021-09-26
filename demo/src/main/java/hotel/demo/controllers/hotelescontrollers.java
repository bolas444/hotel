package hotel.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hotel.demo.domain.hoteles;
import hotel.demo.mappers.hotelesMapper;

@RestController
@RequestMapping("/hoteles")
public class hotelescontrollers {
    @Autowired 
    private hotelesMapper hotelesMapper;
    
    @GetMapping("/todos")
    public List<hoteles> listarTodos(){
            return hotelesMapper.listar();
    }
    
    @PostMapping("/nuevo")
    public List<hoteles> insertarHoteles(
        @RequestParam(required = true) String nombre,
        @RequestParam(required = true) String descripcion,
        @RequestParam(required = true) String ubicacion,
        @RequestParam(required = true) String telefono){
        hotelesMapper.insertarHoteles(nombre,descripcion,ubicacion,telefono);
        return listarTodos();
    }

    @GetMapping("/borrar")
    public List<hoteles> borrarHoteles(
        @RequestParam(required = true) Integer id) {
        hotelesMapper.borrarHoteles(id);
        return listarTodos();
    }

    @GetMapping("/editar")
    public List<hoteles> editarHoteles(
    @RequestParam(required = false) Integer id,
    @RequestParam(required = true) String nombre,
    @RequestParam(required = true) String descripcion,
    @RequestParam(required = true) String ubicacion,
    @RequestParam(required = true) String telefono){
    hotelesMapper.editarHoteles(id,nombre,descripcion,ubicacion,telefono);
        return listarTodos();
    }   
}
