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

@Table(name = "ACSE_TV_ROL_MENU")
@Entity(name = "RolMenu")
public class RolMenu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ACSE_SQ_ROL_MENU")
//    @SequenceGenerator(sequenceName = "ACSE_SQ_ROL_MENU", allocationSize = 1, name = "ACSE_SQ_ROL_MENU")
	@Column(name = "ROLMENCOD")
	private Integer ROLMENCOD;
	
	@ManyToOne
	@JoinColumn(name = "MENCOD", nullable = false, foreignKey = @ForeignKey(name = "FK_ACSE_ROL_MENU_TM_MENU"))
	private Menu menu;

	@ManyToOne
	@JoinColumn(name = "ROLCOD", nullable = false, foreignKey = @ForeignKey(name = "FK_ACSE_ROL_MENU_TM_ROL"))
	private Rol rol;
	
	@Column(name = "SISCOD")
	private Integer SISCOD;
	
	@Column(name = "USUREG", nullable = true, length = 30)
	private String USUREG;
	@Column(name = "FECREG", nullable = true)
	private LocalDate FECREG = LocalDate.now();
	@Column(name = "USUMOD", nullable = true, length = 30)
	private String USUMOD;
	@Column(name = "FECMOD", nullable = true)
	private LocalDate FECMOD;
	@Column(name = "ESTREG", nullable = true, length = 3)
	private Integer ESTREG;
	
	
	public Integer getSISCOD() {
		return SISCOD;
	}
	public void setSISCOD(Integer sISCOD) {
		SISCOD = sISCOD;
	}
	public Integer getROLMENCOD() {
		return ROLMENCOD;
	}
	public void setROLMENCOD(Integer rOLMENCOD) {
		ROLMENCOD = rOLMENCOD;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
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
