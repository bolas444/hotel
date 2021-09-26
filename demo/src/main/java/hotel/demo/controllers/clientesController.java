package hotel.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hotel.demo.domain.clientes;
import hotel.demo.mappers.clientesMapper;

@RestController
@RequestMapping("/clientes")
public class clientesController {
    @Autowired 
    private clientesMapper clientesMapper;
    
    @GetMapping("/todos")
    public List<clientes> listarTodos(){
            return clientesMapper.listar();
    }
    
    @PostMapping("/nuevo")
    public List<clientes> insertarCliente(
        @RequestParam(required = true) String nombres,
        @RequestParam(required = true) String apellidos,
        @RequestParam(required = true) String nombre_usuario,
        @RequestParam(required = true) String contrasena){
        clientesMapper.insertarCliente(nombres,apellidos,nombre_usuario,contrasena);
        return listarTodos();
    }

    @GetMapping("/borrar")
    public List<clientes> borrarCliente(
        @RequestParam(required = true) Integer id) {
        clientesMapper.borrarCliente(id);
        return listarTodos();
    }

    @GetMapping("/editar")
    public List<clientes> editarCliente(
    @RequestParam(required = false) Integer id,
    @RequestParam(required = true) String nombre,
    @RequestParam(required = true) String apellidos,
    @RequestParam(required = true) String nombre_usuario,
    @RequestParam(required = true) String contrasena){
        clientesMapper.editarCliente(id,nombre,apellidos,nombre_usuario,contrasena);
        return listarTodos();
    }
}
