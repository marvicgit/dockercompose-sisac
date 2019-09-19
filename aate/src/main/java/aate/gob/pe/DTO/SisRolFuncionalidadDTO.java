package aate.gob.pe.DTO;

import aate.gob.pe.model.Funcionalidad;
import aate.gob.pe.model.Rol;
import aate.gob.pe.model.Sistema;

public class SisRolFuncionalidadDTO {
	private Integer sisrolfuncod;
	private Sistema sistema;
	private Rol rol;
	private Funcionalidad funcionalidad;
	
	public SisRolFuncionalidadDTO(Integer sisrolfuncod, Sistema sistema, Rol rol, Funcionalidad funcionalidad) {
		super();
		this.sisrolfuncod = sisrolfuncod;
		this.sistema = sistema;
		this.rol = rol;
		this.funcionalidad = funcionalidad;
	}
	public Integer getSisrolfuncod() {
		return sisrolfuncod;
	}
	public void setSisrolfuncod(Integer sisrolfuncod) {
		this.sisrolfuncod = sisrolfuncod;
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
	public Funcionalidad getFuncionalidad() {
		return funcionalidad;
	}
	public void setFuncionalidad(Funcionalidad funcionalidad) {
		this.funcionalidad = funcionalidad;
	}
}
