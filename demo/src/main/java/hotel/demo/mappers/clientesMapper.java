package hotel.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hotel.demo.domain.clientes;

@Mapper
public interface clientesMapper {
    @Select("SELECT id,nombres,apellidos,nombre_usuario,contrasena FROM clientes ")
    public List<clientes> listar();

    @Insert("insert into clientes (nombres,apellidos,nombre_usuario,contrasena) values (#{nombres},#{apellidos},#{nombre_usuario},#{contrasena})")
    public void insertarCliente(@Param("nombres") String nombres,
    @Param("apellidos") String apellidos, 
    @Param("nombre_usuario") String nombre_usuario, 
    @Param("contrasena") String contrasena) ;

    @Delete("delete from clientes where id=(#{id})")
    public Integer borrarCliente(@Param("id") Integer id);

    @Update("update clientes set nombres=#{nombres},apellidos=#{apellidos},nombre_usuario=#{nombre_usuario},contrasena=#{contrasena} where id=#{id}")
    public Integer editarCliente( 
    @Param("id") Integer id,
    @Param("nombre") String nombres,
    @Param("apellidos") String apellidos, 
    @Param("nombre_usuario") String nombre_usuario, 
    @Param("contrasena") String contrasena);    

}
