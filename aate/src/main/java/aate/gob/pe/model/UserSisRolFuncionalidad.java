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

@Table(name = "ACSE_TV_USER_SIS_ROL_FUNC")
@Entity(name = "UserSisRolFuncionalidad")
public class UserSisRolFuncionalidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ACSE_SQ_USESISROL")
//    @SequenceGenerator(sequenceName = "ACSE_SQ_USESISROL", allocationSize = 1, name = "ACSE_SQ_USESISROL")
	@Column(name = "USUSISROLCOD")
	private Integer USUSISROLCOD;
	
	@ManyToOne
	@JoinColumn(name = "ROLCOD", nullable = false, foreignKey = @ForeignKey(name = "FK_USUMENROLFUN_TM_ROL"))
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name = "USUCOD", nullable = false, foreignKey = @ForeignKey(name = "FK_USUMENROLFUN_USU"))
	private Usuario usuario;
	
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
	private Integer ESTREG = 1;

	
	public Integer getSISCOD() {
		return SISCOD;
	}
	public void setSISCOD(Integer sISCOD) {
		SISCOD = sISCOD;
	}
	public Integer getUSUSISROLCOD() {
		return USUSISROLCOD;
	}
	public void setUSUSISROLCOD(Integer uSUSISROLCOD) {
		USUSISROLCOD = uSUSISROLCOD;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
