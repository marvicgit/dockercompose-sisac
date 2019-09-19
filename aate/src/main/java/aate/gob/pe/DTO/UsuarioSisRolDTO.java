package aate.gob.pe.DTO;

import java.util.List;

import aate.gob.pe.model.Usuario;

public class UsuarioSisRolDTO {
	private Usuario usuario;
	private List<SistemaRolDTO> lstSistema;
	private List<UsuarioSistemaRolDTO> lstRol;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<SistemaRolDTO> getLstSistema() {
		return lstSistema;
	}
	public void setLstSistema(List<SistemaRolDTO> lstSistema) {
		this.lstSistema = lstSistema;
	}
	public List<UsuarioSistemaRolDTO> getLstRol() {
		return lstRol;
	}
	public void setLstRol(List<UsuarioSistemaRolDTO> lstRol) {
		this.lstRol = lstRol;
	}	
}
