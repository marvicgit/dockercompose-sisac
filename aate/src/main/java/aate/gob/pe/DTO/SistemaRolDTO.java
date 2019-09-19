package aate.gob.pe.DTO;

import aate.gob.pe.model.Rol;

public class SistemaRolDTO {
	
	private Integer SISCOD;
	private Rol rol;
	
	public SistemaRolDTO(Integer sISCOD, Rol rol) {
		super();
		SISCOD = sISCOD;
		this.rol = rol;
	}
	
	public Integer getSISCOD() {
		return SISCOD;
	}
	public void setSISCOD(Integer sISCOD) {
		SISCOD = sISCOD;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
}
