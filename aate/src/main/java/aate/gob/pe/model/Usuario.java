package aate.gob.pe.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Table(name="ACSE_TM_USUARIO")
@Entity(name = "Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ACSE_SQ_USUARIO")
//    @SequenceGenerator(sequenceName = "ACSE_SQ_USUARIO", allocationSize = 1, name = "ACSE_SQ_USUARIO")
	@Column(name = "USUCOD")
	private Integer USUCOD;
	@Column(name = "USUTIPDOC",nullable = true, length = 3)
	private int USUTIPDOC;
	@Column(name = "USUDNI",nullable = true, length = 12 )
	private String USUDNI;
	@Column(name = "USUNOM",nullable = true, length = 50)
	private String USUNOM;
	@Column(name = "USUAPEPAT",nullable = true, length = 50)
	private String USUAPEPAT;
	@Column(name = "USUAPEMAT",nullable = true, length = 50)
	private String USUAPEMAT;
	@Column(name = "USUSEXO",nullable = true, length = 1)
	private int USUSEXO;
	@Column(name = "USUAREA",nullable = true, length = 100)
	private String USUAREA;
	@Column(name = "USUCARGO",nullable = true, length = 100)
	private String USUCARGO;
	@Column(name = "USUDIREC",nullable = true, length = 200)
	private String USUDIREC;
	@Column(name = "USUCOR",nullable = true, length = 50)
	private String USUCOR;
	@Column(name = "USULOG",nullable = true, length = 30)
	private String USULOG;
	@Column(name = "USUPAS",nullable = true, length = 200)
	private String USUPAS;
	@Column(name = "USUPASSAL",nullable = true, length = 50)
	private String USUPASSAL;
	@Column(name = "PRECOD",nullable = true, length = 3)
	private Integer PRECOD;
	@Column(name = "USURESSEC",nullable = true, length = 300)
	private String USURESSEC;
	@Column(name = "USURESSAL",nullable = true, length = 50)
	private String USURESSAL;
	@Column(name = "USUBLO", nullable = true, length = 1)
	private Integer USUBLO;
	@Column(name = "USUDCP",nullable = true, length = 1)
	private Integer USUDCP;
	@Column(name = "USUNCP",nullable = true, length = 1 )
	private Integer USUNCP;
	@Column(name = "USUPNE",nullable = true, length = 1 )
	private Integer USUPNE;
	@Column(name = "USUREG",nullable = true, length = 30)
	private String USUREG;
	@Column(name = "FECREG",nullable = true)
	private LocalDate FECREG = LocalDate.now();
	@Column(name = "USUMOD",nullable = true, length = 30)
	private String USUMOD;
	@Column(name = "FECMOD",nullable = true)
	private LocalDate FECMOD;
	@Column(name = "ESTREG",nullable = true,length = 3 )
	private Integer ESTREG;
	@Column(name = "USUFOT", updatable = false)
	private byte[] USUFOT;
	@Column(name = "USUFIR", updatable = false)
	private byte[] USUFIR;
	@Column(name = "USUVIS", updatable = false)
	private byte[] USUVIS;
	@Column(name = "FECEXPAS",nullable = true)
	private LocalDate FECEXPAS; 
	@Column(name = "USUTEFFIJO",nullable = true, length = 10)
	private String USUTEFFIJO;  
	@Column(name = "USUTEFMOVIL",nullable = true, length = 10)
	private String USUTEFMOVIL;  
	@Column(name = "USUANEXO",nullable = true, length = 10)
	private String USUANEXO;
	public Integer getUSUCOD() {
		return USUCOD;
	}
	public void setUSUCOD(Integer uSUCOD) {
		USUCOD = uSUCOD;
	}
	public String getUSUDNI() {
		return USUDNI;
	}
	public void setUSUDNI(String uSUDNI) {
		USUDNI = uSUDNI;
	}
	public String getUSUNOM() {
		return USUNOM;
	}
	public void setUSUNOM(String uSUNOM) {
		USUNOM = uSUNOM;
	}
	public String getUSUAPEPAT() {
		return USUAPEPAT;
	}
	public void setUSUAPEPAT(String uSUAPEPAT) {
		USUAPEPAT = uSUAPEPAT;
	}
	public String getUSUAPEMAT() {
		return USUAPEMAT;
	}
	public void setUSUAPEMAT(String uSUAPEMAT) {
		USUAPEMAT = uSUAPEMAT;
	}
	public String getUSUCOR() {
		return USUCOR;
	}
	public void setUSUCOR(String uSUCOR) {
		USUCOR = uSUCOR;
	}
	public String getUSULOG() {
		return USULOG;
	}
	public void setUSULOG(String uSULOG) {
		USULOG = uSULOG;
	}
	public String getUSUPAS() {
		return USUPAS;
	}
	public void setUSUPAS(String uSUPAS) {
		USUPAS = uSUPAS;
	}
	public String getUSUPASSAL() {
		return USUPASSAL;
	}
	public void setUSUPASSAL(String uSUPASSAL) {
		USUPASSAL = uSUPASSAL;
	}
	public Number getPRECOD() {
		return PRECOD;
	}
	public void setPRECOD(Integer pRECOD) {
		PRECOD = pRECOD;
	}
	public String getUSURESSEC() {
		return USURESSEC;
	}
	public void setUSURESSEC(String uSURESSEC) {
		USURESSEC = uSURESSEC;
	}
	public String getUSURESSAL() {
		return USURESSAL;
	}
	public void setUSURESSAL(String uSURESSAL) {
		USURESSAL = uSURESSAL;
	}
	public Integer getUSUBLO() {
		return USUBLO;
	}
	public void setUSUBLO(Integer uSUBLO) {
		USUBLO = uSUBLO;
	}
	public Integer getUSUDCP() {
		return USUDCP;
	}
	public void setUSUDCP(Integer uSUDCP) {
		USUDCP = uSUDCP;
	}
	public Integer getUSUNCP() {
		return USUNCP;
	}
	public void setUSUNCP(Integer uSUNCP) {
		USUNCP = uSUNCP;
	}
	public Integer getUSUPNE() {
		return USUPNE;
	}
	public void setUSUPNE(Integer uSUPNE) {
		USUPNE = uSUPNE;
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
	public byte[] getUSUFOT() {
		return USUFOT;
	}
	public void setUSUFOT(byte[] uSUFOT) {
		USUFOT = uSUFOT;
	}
	public byte[] getUSUFIR() {
		return USUFIR;
	}
	public void setUSUFIR(byte[] uSUFIR) {
		USUFIR = uSUFIR;
	}
	public byte[] getUSUVIS() {
		return USUVIS;
	}
	public void setUSUVIS(byte[] uSUVIS) {
		USUVIS = uSUVIS;
	}
	public LocalDate getFECEXPAS() {
		return FECEXPAS;
	}
	public void setFECEXPAS(LocalDate fECEXPAS) {
		FECEXPAS = fECEXPAS;
	}
	public String getUSUTEFFIJO() {
		return USUTEFFIJO;
	}
	public void setUSUTEFFIJO(String uSUTEFFIJO) {
		USUTEFFIJO = uSUTEFFIJO;
	}
	public String getUSUTEFMOVIL() {
		return USUTEFMOVIL;
	}
	public void setUSUTEFMOVIL(String uSUTEFMOVIL) {
		USUTEFMOVIL = uSUTEFMOVIL;
	}
	public String getUSUANEXO() {
		return USUANEXO;
	}
	public void setUSUANEXO(String uSUANEXO) {
		USUANEXO = uSUANEXO;
	}
	public int getUSUTIPDOC() {
		return USUTIPDOC;
	}
	public void setUSUTIPDOC(int uSUTIPDOC) {
		USUTIPDOC = uSUTIPDOC;
	}
	public int getUSUSEXO() {
		return USUSEXO;
	}
	public void setUSUSEXO(int uSUSEXO) {
		USUSEXO = uSUSEXO;
	}
	public String getUSUAREA() {
		return USUAREA;
	}
	public void setUSUAREA(String uSUAREA) {
		USUAREA = uSUAREA;
	}
	public String getUSUCARGO() {
		return USUCARGO;
	}
	public void setUSUCARGO(String uSUCARGO) {
		USUCARGO = uSUCARGO;
	}
	public String getUSUDIREC() {
		return USUDIREC;
	}
	public void setUSUDIREC(String uSUDIREC) {
		USUDIREC = uSUDIREC;
	}
}
