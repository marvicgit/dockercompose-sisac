package aate.gob.pe.service;

import java.util.List;

import aate.gob.pe.model.Menu;

public interface IMenuService extends ICrud<Menu>{
	
	List<Menu> listarPorIdSistema(Integer idSistema);
}
