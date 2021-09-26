package hotel.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hotel.demo.domain.administradores;
import hotel.demo.mappers.administradoresMapper;


@RestController
@RequestMapping("/administradores")
public class administradoresController {       
    @Autowired 
    private administradoresMapper administradoresMapper;
    
    @GetMapping("/todos")
    public List<administradores> listarTodos(){
            return administradoresMapper.listar();
    }
    
    @PostMapping("/nuevo")
    public List<administradores> insertarAdministradores(
        @RequestParam(required = true) String nombres,
        @RequestParam(required = true) String apellidos,
        @RequestParam(required = true) String nombre_usuario,
        @RequestParam(required = true) String contrasena){
        administradoresMapper.insertarAdministradores(nombres,apellidos,nombre_usuario,contrasena);
        return listarTodos();
    }

    @GetMapping("/borrar")
    public List<administradores> borrarAdministradores(
        @RequestParam(required = true) Integer id) {
        administradoresMapper.borrarAdministradores(id);
        return listarTodos();
    }

    @GetMapping("/editar")
    public List<administradores> editaraAdministradores(
    @RequestParam(required = false) Integer id,
    @RequestParam(required = true) String nombre,
    @RequestParam(required = true) String apellidos,
    @RequestParam(required = true) String nombre_usuario,
    @RequestParam(required = true) String contrasena){
        administradoresMapper.editarAdministradores(id,nombre,apellidos,nombre_usuario,contrasena);
        return listarTodos();
    }
}
