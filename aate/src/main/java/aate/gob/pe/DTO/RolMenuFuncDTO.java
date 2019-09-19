package aate.gob.pe.DTO;

import java.util.List;

public class RolMenuFuncDTO {
	
	private String sissig;
	private String usulog;
	private Integer usucod;
	private List<MenuDTO>menus;
	private List<RolDTO>roles;
	private List<FuncionalidadDTO>funcionalidades;
	
	
	public RolMenuFuncDTO() {} ;

	public RolMenuFuncDTO(String sissig, String usulog, Integer usucod) {
		super();
		this.sissig = sissig;
		this.usulog = usulog;
		this.usucod = usucod;

	}
	
	
	
	public String getSissig() {
		return sissig;
	}
	public void setSissig(String sissig) {
		this.sissig = sissig;
	}
	public String getUsulog() {
		return usulog;
	}
	
	public Integer getUsucod() {
		return usucod;
	}
	public void setUsucod(Integer usucod) {
		this.usucod = usucod;
	}
	public void setUsulog(String usulog) {
		this.usulog = usulog;
	}
	public List<MenuDTO> getMenus() {
		return menus;
	}
	public void setMenus(List<MenuDTO> menus) {
		this.menus = menus;
	}

	public List<RolDTO> getRoles() {
		return roles;
	}
	public void setRoles(List<RolDTO> roles) {
		this.roles = roles;
	}
	public List<FuncionalidadDTO> getFuncionalidades() {
		return funcionalidades;
	}
	public void setFuncionalidades(List<FuncionalidadDTO> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}
	
	
	


}
