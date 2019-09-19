package aate.gob.pe.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import aate.gob.pe.DTO.UsuarioSistemaRolDTO;
import aate.gob.pe.model.UserSisRolFuncionalidad;

public interface IUserSisRolFuncionalidadRepo extends JpaRepository<UserSisRolFuncionalidad,Integer> {
	
	
	@Query(value ="select distinct new aate.gob.pe.DTO.UsuarioSistemaRolDTO(usrf.USUSISROLCOD, s, r, u) from UserSisRolFuncionalidad usrf join Sistema s on s.SISCOD = usrf.SISCOD join usrf.usuario u join usrf.rol r") 
	List<UsuarioSistemaRolDTO> listarUsuarioSistemaRol();
	 
	
/*	@Query(value = "select distinct new aate.gob.pe.DTO.UsuarioSistemaDTO(0, s.SISCOD, s.SISNOM) from RolMenuFuncionalidad rmf join rmf.rolMenu rm join rm.menu m join m.sistema s")
	List<UsuarioSistemaDTO> listarSistemasAptos();
	
	@Query(value = "select distinct new aate.gob.pe.DTO.UsuarioSistemaDTO(u.USUCOD, s.SISCOD, s.SISNOM) from UserRolMenuFuncionalidad urmf join urmf.rolMenuFuncionalidad rmf join rmf.rolMenu rm join rm.menu m join m.sistema s join rm.rol r join urmf.usuario u")
	List<UsuarioSistemaDTO> listarUsuarioSistema();
	
	@Query(value = "select distinct new aate.gob.pe.DTO.UsuarioSistemaRolDTO(0, s.SISCOD, r.ROLCOD, r.ROLNOM) from RolMenuFuncionalidad rmf join rmf.rolMenu rm join rm.menu m join m.sistema s join rm.rol r")
	List<UsuarioSistemaRolDTO> listarSistemaRolAptos();
	
	@Query(value = "select distinct new aate.gob.pe.DTO.UsuarioSistemaRolDTO(u.USUCOD, s.SISCOD, r.ROLCOD, r.ROLNOM) from UserRolMenuFuncionalidad urmf join urmf.rolMenuFuncionalidad rmf join rmf.rolMenu rm join rm.menu m join m.sistema s join rm.rol r join urmf.usuario u")
	List<UsuarioSistemaRolDTO> listarUsuarioSistemaRol();
	
	@Transactional
	@Modifying
	@Query(value = "delete from UserRolMenuFuncionalidad fun where fun.USUROLMENFUNCOD in ( select urmf.USUROLMENFUNCOD from UserRolMenuFuncionalidad urmf join urmf.rolMenuFuncionalidad rmf "
				 + "join rmf.rolMenu rm join rm.menu m join m.sistema s join rm.rol r join rmf.funcionalidad f join urmf.usuario u "
			     + "where s.SISCOD = :siscod and u.USUCOD = :usucod )")
	void eliminarUsuRolMenFunc(@Param("siscod") Integer siscod, @Param("usucod") Integer usucod);
	
	@Transactional
	@Modifying
	@Query(value = "delete from UserRolMenuFuncionalidad fun where fun.USUROLMENFUNCOD in ( select urmf.USUROLMENFUNCOD from UserRolMenuFuncionalidad urmf join urmf.rolMenuFuncionalidad rmf "
				 + "join rmf.rolMenu rm join rm.menu m join m.sistema s join rm.rol r join rmf.funcionalidad f join urmf.usuario u "
			     + "where u.USUCOD = :usucod )")
	void eliminarAsignacionSisUsu(@Param("usucod") Integer usucod);*/
}
