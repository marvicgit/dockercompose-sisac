package aate.gob.pe.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import aate.gob.pe.DTO.RolMenuDTO;
import aate.gob.pe.DTO.SistemaRolDTO;
import aate.gob.pe.model.RolMenu;

public interface IRolMenuService extends ICrud<RolMenu>{
	
	Integer registrarTransaccional(RolMenuDTO rolmenu);
	List<SistemaRolDTO> buscarSistemaRol();
	List<Integer> buscarIdRolMenuxSistema(@Param("siscod") Integer siscod, @Param("rolcod") Integer rolcod);
}
