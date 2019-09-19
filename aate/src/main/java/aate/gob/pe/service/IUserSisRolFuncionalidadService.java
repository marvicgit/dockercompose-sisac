package aate.gob.pe.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import aate.gob.pe.DTO.UsuarioSisRolDTO;
import aate.gob.pe.DTO.UsuarioSistemaDTO;
import aate.gob.pe.DTO.UsuarioSistemaRolDTO;
import aate.gob.pe.model.UserSisRolFuncionalidad;

public interface IUserSisRolFuncionalidadService extends ICrud<UserSisRolFuncionalidad>{
	Integer registrarTransaccionalSis(UsuarioSisRolDTO usersisrol);
	Integer registrarTransaccionalSisRol(UsuarioSisRolDTO usersisrol);
	List<UsuarioSistemaDTO> listarUsuarioSistema();
	List<UsuarioSistemaDTO> listarSistemasAptos();
	List<UsuarioSistemaRolDTO> listarUsuarioSistemaRol();
	List<UsuarioSistemaRolDTO> listarSistemaRolAptos();
	void eliminarUsuRolMenFunc(@Param("siscod") Integer siscod, @Param("usucod") Integer usucod);
	void eliminarAsignacionSisUsu(@Param("usucod") Integer usucod);
}
