package aate.gob.pe.DTO;

import aate.gob.pe.model.Rol;
import aate.gob.pe.model.Sistema;
import aate.gob.pe.model.Usuario;

public class UsuarioSistemaRolDTO {
	private Integer ususisrolcod;
	private Sistema sistema;
	private Rol rol;
	private Usuario usuario;
	
	public UsuarioSistemaRolDTO(Integer ususisrolcod, Sistema sistema, Rol rol, Usuario usuario) {
		super();
		this.ususisrolcod = ususisrolcod;
		this.sistema = sistema;
		this.rol = rol;
		this.usuario = usuario;
	}

	public Integer getUsusisrolcod() {
		return ususisrolcod;
	}

	public void setUsusisrolcod(Integer ususisrolcod) {
		this.ususisrolcod = ususisrolcod;
	}

	public Sistema getSistema() {
		return sistema;
	}
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
}
