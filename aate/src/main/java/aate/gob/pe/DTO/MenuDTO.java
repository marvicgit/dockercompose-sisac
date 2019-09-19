package aate.gob.pe.DTO;

public class MenuDTO {
	
	private Integer MENCOD;
	private String MENNOM;
	private Integer MENORD;
	private String MENICO;
	private String MENRUT;
	private Integer MENPADCOD;
	
	public MenuDTO(Integer mENCOD, String mENNOM, Integer mENORD, String mENICO, String mENRUT, Integer mENPADCOD) {
		super();
		MENCOD = mENCOD;
		MENNOM = mENNOM;
		MENORD = mENORD;
		MENICO = mENICO;
		MENRUT = mENRUT;
		MENPADCOD = mENPADCOD;
	}
	
	public Integer getMENCOD() {
		return MENCOD;
	}
	public void setMENCOD(Integer mENCOD) {
		MENCOD = mENCOD;
	}
	public String getMENNOM() {
		return MENNOM;
	}
	public void setMENNOM(String mENNOM) {
		MENNOM = mENNOM;
	}
	public Integer getMENORD() {
		return MENORD;
	}
	public void setMENORD(Integer mENORD) {
		MENORD = mENORD;
	}
	public String getMENRUT() {
		return MENRUT;
	}
	public void setMENRUT(String mENRUT) {
		MENRUT = mENRUT;
	}
	public Integer getMENPADCOD() {
		return MENPADCOD;
	}
	public void setMENPADCOD(Integer mENPADCOD) {
		MENPADCOD = mENPADCOD;
	}
	public String getMENICO() {
		return MENICO;
	}
	public void setMENICO(String mENICO) {
		MENICO = mENICO;
	}
	
	
	
	
}
