package aate.gob.pe.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import aate.gob.pe.DTO.UsuarioSisRolDTO;
import aate.gob.pe.DTO.UsuarioSistemaDTO;
import aate.gob.pe.DTO.UsuarioSistemaRolDTO;
import aate.gob.pe.model.UserSisRolFuncionalidad;

public interface IUserSisRolFuncionalidadService extends ICrud<UserSisRolFuncionalidad>{
	List<UsuarioSistemaRolDTO> listarUsuarioSistemaRol();
	long existeUsuario(Integer usucod);
	long existeSistema(Integer siscod);
}
