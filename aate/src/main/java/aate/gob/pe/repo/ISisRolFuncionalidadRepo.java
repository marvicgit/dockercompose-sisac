package aate.gob.pe.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aate.gob.pe.DTO.FuncionalidadDTO;
import aate.gob.pe.DTO.MenuDTO;
import aate.gob.pe.DTO.RolDTO;
import aate.gob.pe.DTO.RolMenuFuncDTO;
import aate.gob.pe.DTO.SisRolFuncionalidadDTO;
import aate.gob.pe.model.SisRolFuncionalidad;

public interface ISisRolFuncionalidadRepo extends JpaRepository<SisRolFuncionalidad,Integer> {

	
	  @Query(value = "select distinct new aate.gob.pe.DTO.SisRolFuncionalidadDTO(srf.SISROLFUNCOD, s,r,f) from SisRolFuncionalidad srf join srf.rol r join srf.funcionalidad f join Sistema s on s.SISCOD = srf.SISCOD ")
	  List<SisRolFuncionalidadDTO> listaSistemaRolFun();
	  
	  @Query(value = "select new aate.gob.pe.DTO.RolDTO(r.ROLNOM, TRIM(r.ROLSIG)) from  UserSisRolFuncionalidad usrf  inner join usrf.rol r inner join usrf.usuario u inner join Sistema s on usrf.SISCOD = s.SISCOD  and s.ESTREG = 1 where s.SISSIG = :vSissig and u.USULOG = :vUsulog ")
      List<RolDTO>listaRol(@Param("vSissig") String vSissig, @Param("vUsulog") String  vUsulog);
          
      @Query(value ="select distinct new aate.gob.pe.DTO.MenuDTO( m.MENCOD,m.MENNOM, m.MENORD, m.MENICO ,m.MENRUT,m.padre.MENCOD) from UserSisRolFuncionalidad usrf inner join usrf.rol r inner join RolMenu rm on rm.rol = r and rm.SISCOD = usrf.SISCOD inner join rm.menu m inner join m.sistema s inner join usrf.usuario u where s.SISSIG = :vSissig and u.USULOG = :vUsulog ORDER BY m.MENORD ASC")
      List<MenuDTO>listaMenu(@Param("vSissig") String vSissig, @Param("vUsulog") String  vUsulog);
    
      @Query(value ="select new aate.gob.pe.DTO.FuncionalidadDTO(f.FUNNOM, TRIM(f.FUNSIG) ) from UserSisRolFuncionalidad usrf inner join usrf.rol r inner join SisRolFuncionalidad srf on srf.rol = r inner join srf.funcionalidad f inner join usrf.usuario u inner join Sistema s on s.SISCOD = usrf.SISCOD where s.SISSIG = :vSissig and u.USULOG = :vUsulog ")
      List<FuncionalidadDTO>listaFuncionalidad(@Param("vSissig") String vSissig, @Param("vUsulog") String  vUsulog);
      
      @Query(value="select distinct new aate.gob.pe.DTO.RolMenuFuncDTO(s.SISSIG, u.USULOG, u.USUCOD) from UserSisRolFuncionalidad usrf inner join usrf.usuario u inner join Sistema s on s.SISCOD = usrf.SISCOD where s.SISSIG = :vSissig and u.USULOG = :vUsulog")
      RolMenuFuncDTO ObtenerAcceso(@Param("vSissig") String vSissig, @Param("vUsulog") String  vUsulog);
      
      @Query(value ="select count(rf) from SisRolFuncionalidad rf join Sistema s on s.SISCOD = rf.SISCOD join rf.rol r join rf.funcionalidad f where s.SISCOD = :siscod") 
  	  long existeSistema(@Param("siscod") Integer siscod);
      
      @Query(value ="select count(rf) from SisRolFuncionalidad rf join Sistema s on s.SISCOD = rf.SISCOD join rf.rol r join rf.funcionalidad f where r.ROLCOD = :rolcod") 
  	  long existeRol(@Param("rolcod") Integer rolcod);
      
      @Query(value ="select count(rf) from SisRolFuncionalidad rf join Sistema s on s.SISCOD = rf.SISCOD join rf.rol r join rf.funcionalidad f where f.FUNCOD = :funcod") 
  	  long existeFuncionalidad(@Param("funcod") Integer funcod);
	
}
