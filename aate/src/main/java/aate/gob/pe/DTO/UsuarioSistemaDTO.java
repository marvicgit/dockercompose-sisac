package aate.gob.pe.DTO;

public class UsuarioSistemaDTO {
	private Integer USUCOD;
	private Integer SISCOD;
	private String SISNOM;
	
	public UsuarioSistemaDTO(Integer uSUCOD, Integer sISCOD, String sISNOM) {
		super();
		USUCOD = uSUCOD;
		SISCOD = sISCOD;
		SISNOM = sISNOM;
	}
	public Integer getUSUCOD() {
		return USUCOD;
	}
	public void setUSUCOD(Integer uSUCOD) {
		USUCOD = uSUCOD;
	}
	public Integer getSISCOD() {
		return SISCOD;
	}
	public void setSISCOD(Integer sISCOD) {
		SISCOD = sISCOD;
	}
	public String getSISNOM() {
		return SISNOM;
	}
	public void setSISNOM(String sISNOM) {
		SISNOM = sISNOM;
	}
	
	
}
