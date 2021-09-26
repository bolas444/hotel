package hotel.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hotel.demo.domain.express;
import hotel.demo.mappers.expressMapper;

@RestController
@RequestMapping("/express")
public class expressContoller{
    @Autowired 
    private expressMapper expressMapper;
    
    @GetMapping("/todos")
    public List<express> listarTodos(){
            return expressMapper.listar();
    }
    
    @PostMapping("/nuevo")
    public List<express> insertarExpress(
        @RequestParam(required = true) Integer numero,
        @RequestParam(required = true) String descripcion,
        @RequestParam(required = true) Integer num_cama,
        @RequestParam(required = true) Integer num_toallas,
        @RequestParam(required = true) Integer num_controles,
        @RequestParam(required = true) Integer codigo_condones,
        @RequestParam(required = true) Boolean tipo){
        expressMapper.insertarExpress(numero,descripcion,num_cama,num_toallas,num_controles,codigo_condones,tipo);
        return listarTodos();
    }

    @GetMapping("/borrar")
    public List<express> borrarExpress(
        @RequestParam(required = true) Integer id) {
        expressMapper.borrarExpress(id);
        return listarTodos();
    }

    @GetMapping("/editar")
    public List<express> editarExpress(
    @RequestParam(required = false) Integer id,
    @RequestParam(required = true) Integer numero,
    @RequestParam(required = true) String descripcion,
    @RequestParam(required = true) Integer num_cama,
    @RequestParam(required = true) Integer num_toallas,
    @RequestParam(required = true) Integer num_controles,
    @RequestParam(required = true) Integer codigo_condones,
    @RequestParam(required = true) Boolean tipo){
    expressMapper.editarExpress(id,numero,descripcion,num_cama,num_toallas,num_controles,codigo_condones,tipo);
        return listarTodos();
    }
}
