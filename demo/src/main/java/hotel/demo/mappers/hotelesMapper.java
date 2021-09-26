package hotel.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hotel.demo.domain.hoteles;

@Mapper
public interface hotelesMapper {
    @Select("SELECT id,nombre,descripcion,ubicacion,telefono FROM hoteles")
    public List<hoteles> listar();

    @Insert("insert into hoteles (nombre,descripcion,ubicacion,telefono) values (#{nombre},#{descripcion},#{ubicacion},#{telefono})")
    public void insertarHoteles(@Param("nombre") String nombre,
    @Param("descripcion") String descripcion, 
    @Param("ubicacion") String ubicacion, 
    @Param("telefono") String telefono) ;

    @Delete("delete from hoteles where id=(#{id})")
    public Integer borrarHoteles(@Param("id") Integer id);

    @Update("update hoteles set nombre=#{nombre},descripcion=#{descripcion},ubicacion=#{ubicacion},telefono=#{telefono} where id=#{id}")
    public Integer editarHoteles( 
    @Param("id") Integer id,
    @Param("nombre") String nombre,
    @Param("descripcion") String descripcion, 
    @Param("ubicacion") String ubicacion, 
    @Param("telefono") String telefono);    
}
