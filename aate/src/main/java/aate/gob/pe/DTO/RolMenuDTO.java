package aate.gob.pe.DTO;

import java.util.List;

import aate.gob.pe.model.Menu;
import aate.gob.pe.model.Rol;


public class RolMenuDTO {
	private Integer siscod;
	private Rol rol;
	private List<Menu> lstMenus;
	
	public Integer getSiscod() {
		return siscod;
	}
	public void setSiscod(Integer siscod) {
		this.siscod = siscod;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public List<Menu> getLstMenus() {
		return lstMenus;
	}
	public void setLstMenus(List<Menu> lstMenus) {
		this.lstMenus = lstMenus;
	}

}
