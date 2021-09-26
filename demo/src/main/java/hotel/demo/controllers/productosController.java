package hotel.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hotel.demo.domain.productos;
import hotel.demo.mappers.productoMapper;

@RestController
@RequestMapping("/productos")
public class productosController {
    @Autowired 
    private productoMapper productoMapper;
    
    @GetMapping("/todos")
    public List<productos> listarTodos(){
            return productoMapper.listar();
    }
    
    @PostMapping("/nuevo")
    public List<productos> insertarProducto(
        @RequestParam(required = true) String nombre,
        @RequestParam(required = true) Float precio,
        @RequestParam(required = true) Integer stock){
        productoMapper.insertarProducto(nombre,precio,stock);
        return listarTodos();
    }

    @GetMapping("/borrar")
    public List<productos> borrarProducto(
        @RequestParam(required = true) Integer id) {
        productoMapper.borrarProducto(id);
        return listarTodos();
    }

    @GetMapping("/editar")
    public List<productos> editarProducto(
    @RequestParam(required = false) Integer id,
    @RequestParam(required = true) String nombre,
    @RequestParam(required = true) Float precio,
    @RequestParam(required = true) Integer stock){
    productoMapper.editarProducto(id,nombre,precio,stock);
        return listarTodos();
    }  
}
