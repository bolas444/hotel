package hotel.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hotel.demo.domain.administradores;

/**
 * administradoresMapper
 */

@Mapper
public interface administradoresMapper {
    @Select("SELECT id,nombres,apellidos,nombre_usuario,contrasena FROM administradores")
    public List<administradores> listar();

    @Insert("insert into administradores (nombre,precio,stock) values (#{nombre},#{precio},#{stock})")
    public void insertarAdministradores(@Param("nombres") String nombres,
    @Param("apellidos") String apellidos, 
    @Param("nombre_usuario") String nombre_usuario, 
    @Param("contrasena") String contrasena);

    @Delete("delete from administradores where id=(#{id})")
    public Integer borrarAdministradores(@Param("id") Integer id);

    @Update("update administradores set nombres=#{nombres},apellidos=#{apellidos},nombre_usuario=#{nombre_usuario},contrasena=#{contrasena} where id=#{id}")
    public Integer editarAdministradores(@Param("id") Integer id,
    @Param("nombres") String nombres,
    @Param("apellidos") String apellidos, 
    @Param("nombre_usuario") String nombre_usuario, 
    @Param("contrasena") String contrasena);    
    
}