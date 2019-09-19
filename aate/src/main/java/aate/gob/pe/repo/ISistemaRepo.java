package aate.gob.pe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aate.gob.pe.model.Sistema;

//@Repository
public interface ISistemaRepo extends JpaRepository<Sistema, Integer> {
	
	@Query(value = "SELECT s FROM Sistema s where s.SISSIG = :sigla")
	Sistema siglaFindAll(@Param("sigla") String sigla);
	
	@Query("from Sistema s where LOWER(s.SISNOM)  like %:SISNOM% or lower(s.SISSIG) like %:SISSIG% or s.ESTREG = :ESTREG")
	List<Sistema> buscarSistema( @Param("SISNOM")String SISNOM,  @Param("SISSIG")String SISSIG, @Param("ESTREG") Integer ESTREG );

}
