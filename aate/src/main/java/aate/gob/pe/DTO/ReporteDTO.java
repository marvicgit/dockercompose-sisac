package aate.gob.pe.DTO;

public class ReporteDTO {
	
	private Integer siscod;
	private String sisnom;
	private String usulog;
	private Integer rolcod;
	private String rolnom;
	private Integer estreg;
	
	
	public ReporteDTO(Integer siscod, String sisnom, String usulog, Integer rolcod, String rolnom, Integer estreg) {
		super();
		this.siscod = siscod;
		this.sisnom = sisnom;
		this.usulog = usulog;
		this.rolcod = rolcod;
		this.rolnom = rolnom;
		this.estreg = estreg;
	}
	
	public String getUsulog() {
		return usulog;
	}

	public void setUsulog(String usulog) {
		this.usulog = usulog;
	}

	public Integer getSiscod() {
		return siscod;
	}
	public void setSiscod(Integer siscod) {
		this.siscod = siscod;
	}
	public String getSisnom() {
		return sisnom;
	}
	public void setSisnom(String sisnom) {
		this.sisnom = sisnom;
	}
	public Integer getRolcod() {
		return rolcod;
	}
	public void setRolcod(Integer rolcod) {
		this.rolcod = rolcod;
	}
	public String getRolnom() {
		return rolnom;
	}
	public void setRolnom(String rolnom) {
		this.rolnom = rolnom;
	}
	public Integer getEstreg() {
		return estreg;
	}
	public void setUsuest(Integer estreg) {
		this.estreg = estreg;
	}

	
}
