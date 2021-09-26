package hotel.demo.mappers;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hotel.demo.domain.ventas;

@Mapper
public interface ventasMapper {
    @Select("SELECT id,id_cliente,id_habitacion,tipo_habitacion,fecha_entrada,fecha_salida,precio,num_personas FROM ventas")
    public List<ventas> listar();

    @Insert("insert into ventas(id_cliente,id_habitacion,tipo_habitacion,fecha_entrada,fecha_salida,precio,num_personas) values (#{id_cliente},#{id_habitacion},#{tipo_habitacion},#{fecha_entrada},#{fecha_salida},#{precio,num_personas})")
    public void insertarVentas(@Param("id_cliente") Integer id_cliente,
    @Param("id_habitacion") Integer id_habitacion, 
    @Param("tipo_habitacion") Integer tipo_habitacion,
    @Param("fecha_entrada") Date fecha_entrada, 
    @Param("fecha_salida")  Date fecha_salida,
    @Param("precio") Float precio, 
    @Param("stock") Float num_personas) ;

    @Delete("delete from ventas where id=(#{id})")
    public Integer borrarVentas(@Param("id") Integer id);

    @Update("update ventas set id_cliente=#{id_cliente},id_habitacion=#{id_habitacion},tipo_habitacion=#{tipo_habitacion},fecha_entrada=#{fecha_entrada},fecha_salida=#{fecha_salida},precio=#{precio},num_personas=#{num_personas}  where id=#{id}")
    public Integer editarVentas(        
    @Param("id") Integer id,
    @Param("id_cliente") Integer id_cliente,
    @Param("id_habitacion") Integer id_habitacion, 
    @Param("tipo_habitacion") Integer tipo_habitacion,
    @Param("fecha_entrada") Date fecha_entrada, 
    @Param("fecha_salida")  Date fecha_salida,
    @Param("precio") Float precio, 
    @Param("stock") Float num_personas); 
}
