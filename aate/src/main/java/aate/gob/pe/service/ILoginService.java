package aate.gob.pe.service;

import aate.gob.pe.model.Usuario;

public interface ILoginService {
	
	Usuario verificarNombreUsuario(String usuario) throws Exception;
	int cambiarClave(String clave, String nombre) throws Exception;

}
