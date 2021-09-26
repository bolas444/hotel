package hotel.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hotel.demo.domain.fijas;

@Mapper
public interface fijasMapper {
    @Select("SELECT id,numero,descripcion,num_camas,num_toallas,num_controles,tipo FROM fijas")
    public List<fijas> listar();

    @Insert("insert into fijas (numero,descripcion,num_cama,num_controles,num_toallas,tipo) values (#{numero},#{descripcion},#{num_cama},#{num_controles},#{num_toallas},#{tipo})")
    public void insertarFijas(@Param("numero") Integer numero,
    @Param("descripcion") String descripcion, 
    @Param("num_cama") Integer num_cama,
    @Param("num_controles")  Integer num_controles,
    @Param("num_toallas") Integer num_toallas, 
    @Param("tipo")  Boolean tipo) ;

    @Delete("delete from fijas where id=(#{id})")
    public Integer borrarFijas(@Param("id") Integer id);

    @Update("update fijas set numero=#{numero},descripcion=#{descripcion},num_cama=#{num_cama},num_controles=#{num_controles},num_toallas=#{num_toallas},tipo=#{tipo} where id=#{id}")
    public Integer editarFijas(
    @Param("id") Integer id,
    @Param("numero") Integer numero,
    @Param("descripcion") String descripcion, 
    @Param("num_cama") Integer num_cama,
    @Param("num_controles")  Integer num_controles,
    @Param("num_toallas") Integer num_toallas, 
    @Param("tipo")  Boolean tipo);    

}
