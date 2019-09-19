package aate.gob.pe.DTO;

public class RolDTO {

	private String ROLNOM;
	private String ROLSIG;
	
	
	public RolDTO(String rOLNOM, String rOLSIG) {
		super();
		ROLNOM = rOLNOM;
		ROLSIG = rOLSIG;
	}
	public String getROLNOM() {
		return ROLNOM;
	}
	public void setROLNOM(String rOLNOM) {
		ROLNOM = rOLNOM;
	}
	public String getROLSIG() {
		return ROLSIG;
	}
	public void setROLSIG(String rOLSIG) {
		ROLSIG = rOLSIG;
	}
	
	
	
}
