package aate.gob.pe.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import aate.gob.pe.DTO.ReporteDTO;
import aate.gob.pe.model.Usuario;

public interface IUsuarioService extends ICrud<Usuario>{
	Usuario BuscarUsuarioLdap (@Param("user") String user);
	List<ReporteDTO> ObtenerDetalleUsusario();
}


