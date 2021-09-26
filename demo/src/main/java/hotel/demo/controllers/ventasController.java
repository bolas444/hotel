package hotel.demo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hotel.demo.domain.ventas;
import hotel.demo.mappers.ventasMapper;

@RestController
@RequestMapping("/ventas")
public class ventasController {
    @Autowired 
    private ventasMapper ventasMapper;
    
    @GetMapping("/todos")
    public List<ventas> listarTodos(){
            return ventasMapper.listar();
    }
    
    @PostMapping("/nuevo")
    public List<ventas> insertarVentas(
        @RequestParam(required = true) Integer id_cliente,
        @RequestParam(required = true) Integer id_habitacion,
        @RequestParam(required = true) Integer tipo_habitacion,
        @RequestParam(required = true) Date fecha_entrada,
        @RequestParam(required = true) Date fecha_salida,
        @RequestParam(required = true) Float precio,
        @RequestParam(required = true) Float num_personas){
        ventasMapper.insertarVentas(id_cliente,id_habitacion,tipo_habitacion,fecha_entrada,fecha_salida,precio,num_personas);
        return listarTodos();
    }

    @GetMapping("/borrar")
    public List<ventas> borrarVentas(
        @RequestParam(required = true) Integer id) {
        ventasMapper.borrarVentas(id);
        return listarTodos();
    }

    @GetMapping("/editar")
    public List<ventas> editarVentas(
    @RequestParam(required = false) Integer id,
    @RequestParam(required = true) Integer id_cliente,
    @RequestParam(required = true) Integer id_habitacion,
    @RequestParam(required = true) Integer tipo_habitacion,
    @RequestParam(required = true) Date fecha_entrada,
    @RequestParam(required = true) Date fecha_salida,
    @RequestParam(required = true) Float precio,
    @RequestParam(required = true) Float num_personas){
        ventasMapper.editarVentas(id,id_cliente,id_habitacion,tipo_habitacion,fecha_entrada,fecha_salida,precio,num_personas);
        return listarTodos();
    }
}
