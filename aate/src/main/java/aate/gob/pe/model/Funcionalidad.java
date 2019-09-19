package aate.gob.pe.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="ACSE_TM_FUNCIONALIDAD")
@Entity(name = "Funcionalidad")
public class Funcionalidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ACSE_SQ_FUNCIONALIDAD")
//    @SequenceGenerator(sequenceName = "ACSE_SQ_FUNCIONALIDAD", allocationSize = 1, name = "ACSE_SQ_FUNCIONALIDAD")
	@Column(name = "FUNCOD")
	private Integer FUNCOD;
	
	@Column(name = "FUNNOM", nullable = true,length = 50)
	private String FUNNOM;
	@Column(name = "FUNDES", nullable = true,length = 100)
	private String FUNDES;
	@Column(name = "FUNSIG", nullable = true, length = 20)
	private String FUNSIG;
	@Column(name = "USUREG", nullable = true,length = 30)
	private String USUREG;
	@Column(name = "FECREG", nullable = true)
	private LocalDate FECREG = LocalDate.now();
	@Column(name = "USUMOD", nullable = true, length = 30)
	private String USUMOD;
	@Column(name = "FECMOD", nullable = true)
	private LocalDate FECMOD;
	@Column(name = "ESTREG", nullable = true, length = 3)
	private Integer ESTREG;
	
	
	
	public Integer getFUNCOD() {
		return FUNCOD;
	}
	public void setFUNCOD(Integer fUNCOD) {
		FUNCOD = fUNCOD;
	}

	/*
	 * public Sistema getSistema() { return sistema; } public void
	 * setSistema(Sistema sistema) { this.sistema = sistema; }
	 */
	public String getFUNNOM() {
		return FUNNOM;
	}
	public void setFUNNOM(String fUNNOM) {
		FUNNOM = fUNNOM;
	}
	public String getFUNDES() {
		return FUNDES;
	}
	public void setFUNDES(String fUNDES) {
		FUNDES = fUNDES;
	}
	public String getFUNSIG() {
		return FUNSIG;
	}
	public void setFUNSIG(String fUNSIG) {
		FUNSIG = fUNSIG;
	}

	public String getUSUREG() {
		return USUREG;
	}
	public void setUSUREG(String uSUREG) {
		USUREG = uSUREG;
	}
	public LocalDate getFECREG() {
		return FECREG;
	}
	public void setFECREG(LocalDate fECREG) {
		FECREG = fECREG;
	}
	public String getUSUMOD() {
		return USUMOD;
	}
	public void setUSUMOD(String uSUMOD) {
		USUMOD = uSUMOD;
	}
	public LocalDate getFECMOD() {
		return FECMOD;
	}
	public void setFECMOD(LocalDate fECMOD) {
		FECMOD = fECMOD;
	}
	public Integer getESTREG() {
		return ESTREG;
	}
	public void setESTREG(Integer eSTREG) {
		ESTREG = eSTREG;
	}
	
	
	
	
}
