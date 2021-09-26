package hotel.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hotel.demo.domain.productos;

@Mapper
public interface productoMapper {
    @Select("SELECT id,nombre,precio,stock FROM productos")
    public List<productos> listar();

    @Insert("insert into productos (nombre,precio,stock) values (#{nombre},#{precio},#{stock})")
    public void insertarProducto(@Param("nombre") String nombre,
    @Param("precio") Float precio, 
    @Param("stock") Integer stock) ;

    @Delete("delete from productos where id=(#{id})")
    public Integer borrarProducto(@Param("id") Integer id);

    @Update("update productos set nombre=#{nombre},apellidos=#{apellidos},nombre_usuario=#{nombre_usuario},contrasena=#{contrasena} where id=#{id}")
    public Integer editarProducto(    
    @Param("id") Integer id,
    @Param("nombre") String nombre,
    @Param("precio") Float precio, 
    @Param("stock") Integer stock);    

}
