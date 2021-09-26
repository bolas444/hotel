package hotel.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hotel.demo.domain.fijas;
import hotel.demo.mappers.fijasMapper;

@RestController
@RequestMapping("/fijas")
public class fijasController {
    @Autowired 
    private fijasMapper fijasMapper;
    
    @GetMapping("/todos")
    public List<fijas> listarTodos(){
            return fijasMapper.listar();
    }
    
    @PostMapping("/nuevo")
    public List<fijas> insertarfijas(
        @RequestParam(required = true) Integer numero,
        @RequestParam(required = true) String descripcion,
        @RequestParam(required = true) Integer num_cama,
        @RequestParam(required = true) Integer num_controles,
        @RequestParam(required = true) Integer num_toallas,
        @RequestParam(required = true) Boolean tipo){
        fijasMapper.insertarFijas(numero,descripcion,num_cama,num_controles,num_toallas,tipo);
        return listarTodos();
    }

    @GetMapping("/borrar")
    public List<fijas> borrarfijas(
        @RequestParam(required = true) Integer id) {
        fijasMapper.borrarFijas(id);
        return listarTodos();
    }

    @GetMapping("/editar")
    public List<fijas> editarfijas(
    @RequestParam(required = false) Integer id,
    @RequestParam(required = true) Integer numero,
    @RequestParam(required = true) String descripcion,
    @RequestParam(required = true) Integer num_cama,
    @RequestParam(required = true) Integer num_controles,
    @RequestParam(required = true) Integer num_toallas,
    @RequestParam(required = true) Boolean tipo){
    fijasMapper.editarFijas(id,numero,descripcion,num_cama,num_controles,num_toallas,tipo);
        return listarTodos();
    }   
}
