package hotel.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import hotel.demo.domain.express;

@Mapper
public interface expressMapper {
    @Select("SELECT id,numero,descripcion,num_cama,num_controles,num_toallas,codigo_condones,tipo FROM express")
    public List<express> listar();

    @Insert("insert into express (numero,descripcion,num_cama,num_controles,num_toallas,codigo_condones,tipo) values (#{numero},#{descripcion},#{num_cama},#{num_controles},#{num_toallas},#{codigo_condones},#{tipo})")
    public void insertarExpress(@Param("numero") Integer numero,
    @Param("descripcion") String descripcion, 
    @Param("num_cama") Integer num_cama,
    @Param("num_controles")  Integer num_controles,
    @Param("num_toallas") Integer num_toallas, 
    @Param("codigo_condones")  Integer codigo_condones,
    @Param("tipo")  Boolean tipo) ;

    @Delete("delete from express where id=(#{id})")
    public Integer borrarExpress(@Param("id") Integer id);

    @Update("update express set numero=#{numero},descripcion=#{descripcion},num_cama=#{num_cama},num_controles=#{num_controles},num_toallas=#{num_toallas},codigo_condones=#{codigo_condones},tipo=#{tipo} where id=#{id}")
    public Integer editarExpress(
    @Param("id") Integer id,
    @Param("numero") Integer numero,
    @Param("descripcion") String descripcion, 
    @Param("num_cama") Integer num_cama,
    @Param("num_controles")  Integer num_controles,
    @Param("num_toallas") Integer num_toallas, 
    @Param("codigo_condones")  Integer codigo_condones,
    @Param("tipo")  Boolean tipo);    

}
