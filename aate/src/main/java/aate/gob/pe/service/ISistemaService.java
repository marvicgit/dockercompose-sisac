package aate.gob.pe.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import aate.gob.pe.model.Sistema;

public interface ISistemaService extends ICrud<Sistema>{

	List<Sistema> siglaFindAll(@Param("sigla") String sigla);
	List<Sistema> buscarSistema(Sistema filtro);
}


