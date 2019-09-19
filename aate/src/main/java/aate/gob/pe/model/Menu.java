package aate.gob.pe.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="ACSE_TM_MENU")
@Entity(name = "Menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ACSE_SQ_MENU")
//    @SequenceGenerator(sequenceName = "ACSE_SQ_MENU", allocationSize = 1, name = "ACSE_SQ_MENU")
	@Column(name = "MENCOD")
	private Integer MENCOD;
	
	
	@ManyToOne
	@JoinColumn(name = "SISCOD",nullable = true,  foreignKey = @ForeignKey(name = "FK_ACSE_TM_MENU_TB_SISTEMA"))
	private Sistema sistema;
	
	@Column(name = "MENNOM", nullable = true,length = 50)
	private String MENNOM;
	@Column(name = "MENPADFLG", nullable = true, length = 3)
	private Integer MENPADFLG;
	@Column(name = "MENORD",nullable = true, length = 3)
	private Integer MENORD;
	
	@ManyToOne
	@JoinColumn(name = "MENPADCOD", referencedColumnName = "MENCOD", foreignKey =  @ForeignKey(name = "FK_ACSE_TM_MENU_TM_MENU") )
	private Menu padre;
	
	
	@Column(name = "MENSIG", nullable = true, length = 20)
	private String MENSIG;
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
	@Column(name = "MENRUT", nullable = true,length = 150)
	private String MENRUT;
	@Column(name = "MENICO", nullable = true,length = 50)
	private String MENICO;
	public Integer getMENCOD() {
		return MENCOD;
	}
	public void setMENCOD(Integer mENCOD) {
		MENCOD = mENCOD;
	}
	
	public Sistema getSistema() {
		return sistema;
	}
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	public String getMENNOM() {
		return MENNOM;
	}
	public void setMENNOM(String mENNOM) {
		MENNOM = mENNOM;
	}
	public Integer getMENPADFLG() {
		return MENPADFLG;
	}
	public void setMENPADFLG(Integer mENPADFLG) {
		MENPADFLG = mENPADFLG;
	}
	public Integer getMENORD() {
		return MENORD;
	}
	public void setMENORD(Integer mENORD) {
		MENORD = mENORD;
	}
	/*public Integer getMENPADCOD() {
		return MENPADCOD;
	}
	public void setMENPADCOD(Integer mENPADCOD) {
		MENPADCOD = mENPADCOD;
	}*/
	public String getMENSIG() {
		return MENSIG;
	}
	public void setMENSIG(String mENSIG) {
		MENSIG = mENSIG;
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
	public String getMENRUT() {
		return MENRUT;
	}
	public void setMENRUT(String mENRUT) {
		MENRUT = mENRUT;
	}
	public String getMENICO() {
		return MENICO;
	}
	public void setMENICO(String mENICO) {
		MENICO = mENICO;
	}
	public Menu getPadre() {
		return padre;
	}
	public void setPadre(Menu Padre) {
		this.padre = Padre;
	}
	
}
