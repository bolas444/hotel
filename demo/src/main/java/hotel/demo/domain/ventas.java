package hotel.demo.domain;

import java.util.Date;

public class ventas {
    private Integer id;
    private Integer id_cliente;   
    private Integer id_habitacion;
    private Integer tipo_habitacion;
    private Date fecha_entrada;
    private Date fecha_salida;
    private Float precio;
    private Float num_personas;
   
    public Integer getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId_habitacion() {
        return id_habitacion;
    }
    public void setId_habitacion(Integer id_habitacion) {
        this.id_habitacion = id_habitacion;
    }
    public Integer getTipo_habitacion() {
        return tipo_habitacion;
    }
    public void setTipo_habitacion(Integer tipo_habitacion) {
        this.tipo_habitacion = tipo_habitacion;
    }
    public Date getFecha_entrada() {
        return fecha_entrada;
    }
    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }
    public Date getFecha_salida() {
        return fecha_salida;
    }
    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }
    public Float getPrecio() {
        return precio;
    }
    public void setPrecio(Float precio) {
        this.precio = precio;
    }
    public Float getNum_personas() {
        return num_personas;
    }
    public void setNum_personas(Float num_personas) {
        this.num_personas = num_personas;
    }

    
}
