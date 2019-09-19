package aate.gob.pe.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import aate.gob.pe.DTO.ReporteDTO;
import aate.gob.pe.model.Rol;
import aate.gob.pe.model.Usuario;

//@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
	
	@Query(value = "select u from Usuario u WHERE u.USULOG = :username")
	Usuario buscarUsuarioxLogin(String username);
	
	@Query(value = "select r from UserSisRolFuncionalidad usr inner join usr.rol r inner join usr.usuario u inner join Sistema s on s.SISCOD = usr.SISCOD WHERE u.USULOG = :username and s.SISSIG = :sissig")
	List<Rol> getUserRoleDetails(String username, String sissig);
	
	@Query(value = "select new aate.gob.pe.DTO.ReporteDTO(s.SISCOD, s.SISNOM, u.USULOG, r.ROLCOD, r.ROLNOM, u.ESTREG)  from UserSisRolFuncionalidad usr inner join usr.rol r inner join usr.usuario u inner join Sistema s on s.SISCOD = usr.SISCOD")
	List<ReporteDTO> ObtenerDetalleUsusario();

}
