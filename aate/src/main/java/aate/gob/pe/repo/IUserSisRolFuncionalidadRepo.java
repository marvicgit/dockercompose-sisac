package aate.gob.pe.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aate.gob.pe.DTO.UsuarioSistemaRolDTO;
import aate.gob.pe.model.UserSisRolFuncionalidad;

public interface IUserSisRolFuncionalidadRepo extends JpaRepository<UserSisRolFuncionalidad,Integer> {
	
	
	@Query(value ="select distinct new aate.gob.pe.DTO.UsuarioSistemaRolDTO(usrf.USUSISROLCOD, s, r, u) from UserSisRolFuncionalidad usrf join Sistema s on s.SISCOD = usrf.SISCOD join usrf.usuario u join usrf.rol r") 
	List<UsuarioSistemaRolDTO> listarUsuarioSistemaRol();
	 
	@Query(value ="select count(usrf) from UserSisRolFuncionalidad usrf join Sistema s on s.SISCOD = usrf.SISCOD join usrf.usuario u join usrf.rol r where u.USUCOD = :usucod") 
	long existeUsuario(@Param("usucod") Integer usucod);
	
	@Query(value ="select count(usrf) from UserSisRolFuncionalidad usrf join Sistema s on s.SISCOD = usrf.SISCOD join usrf.usuario u join usrf.rol r where s.SISCOD = :siscod") 
	long existeSistema(@Param("siscod") Integer siscod);
	
}
