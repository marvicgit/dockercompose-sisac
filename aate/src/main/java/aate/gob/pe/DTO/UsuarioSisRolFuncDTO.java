package aate.gob.pe.DTO;

import aate.gob.pe.model.SisRolFuncionalidad;
import aate.gob.pe.model.Sistema;
import aate.gob.pe.model.Usuario;

public class UsuarioSisRolFuncDTO {
	private SisRolFuncionalidad sisrolfun;
	private Sistema sistema;
	private Usuario usuario;
	
	public UsuarioSisRolFuncDTO(SisRolFuncionalidad sisrolfun, Sistema sistema, Usuario usuario) {
		super();
		this.sisrolfun = sisrolfun;
		this.sistema = sistema;
		this.usuario = usuario;
	}
	public SisRolFuncionalidad getSisrolfun() {
		return sisrolfun;
	}
	public void setSisrolfun(SisRolFuncionalidad sisrolfun) {
		this.sisrolfun = sisrolfun;
	}
	public Sistema getSistema() {
		return sistema;
	}
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
