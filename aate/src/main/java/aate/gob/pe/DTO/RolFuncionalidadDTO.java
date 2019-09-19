package aate.gob.pe.DTO;

import java.util.List;

import aate.gob.pe.model.Funcionalidad;

public class RolFuncionalidadDTO {
	private Integer SISCOD;
	private Integer ROLCOD;
	private List<Funcionalidad> lstFuncionalidad;
	public Integer getSISCOD() {
		return SISCOD;
	}
	public void setSISCOD(Integer sISCOD) {
		SISCOD = sISCOD;
	}
	public Integer getROLCOD() {
		return ROLCOD;
	}
	public void setROLCOD(Integer rOLCOD) {
		ROLCOD = rOLCOD;
	}
	public List<Funcionalidad> getLstFuncionalidad() {
		return lstFuncionalidad;
	}
	public void setLstFuncionalidad(List<Funcionalidad> lstFuncionalidad) {
		this.lstFuncionalidad = lstFuncionalidad;
	}
}
