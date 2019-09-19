package aate.gob.pe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aate.gob.pe.DTO.UsuarioSisRolDTO;
import aate.gob.pe.DTO.UsuarioSistemaDTO;
import aate.gob.pe.DTO.UsuarioSistemaRolDTO;
import aate.gob.pe.model.UserSisRolFuncionalidad;
import aate.gob.pe.repo.IUserSisRolFuncionalidadRepo;
import aate.gob.pe.service.IUserSisRolFuncionalidadService;

@Service
public class UserSisRolFuncionalidadServiceImpl implements IUserSisRolFuncionalidadService {

	@Autowired
	private IUserSisRolFuncionalidadRepo repo;
	
	@Override
	public UserSisRolFuncionalidad registrar(UserSisRolFuncionalidad t) {
	 return	repo.save(t);
	}

	@Override
	public UserSisRolFuncionalidad modificar(UserSisRolFuncionalidad t) {
		return	repo.save(t);
	}

	@Override
	public List<UserSisRolFuncionalidad> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public UserSisRolFuncionalidad leer(Integer id) {
		Optional<UserSisRolFuncionalidad> op = repo.findById(id);
		return op.isPresent() ? op.get() : new UserSisRolFuncionalidad();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public Integer registrarTransaccionalSis(UsuarioSisRolDTO usersisrol) { 

		/*
		 * usersisrol.getLstSistema().forEach(s -> { List<Integer> listaRMF=
		 * repoRMF.buscarIdRolMenuFunxSistema(s.getSISCOD(), 1); listaRMF.forEach(i -> {
		 * UserSisRolFuncionalidad urmf = new UserSisRolFuncionalidad();
		 * SisRolFuncionalidad rmf = new SisRolFuncionalidad(); //
		 * rmf.setROLMENFUNCOD(i); // urmf.setRolMenuFuncionalidad(rmf); Usuario usuario
		 * = new Usuario(); usuario.setUSUCOD(usersisrol.getUsuario().getUSUCOD());
		 * urmf.setUsuario(usuario); repo.save(urmf); }); });
		 */ 
			return 1;

	}
	
	@Override
	public Integer registrarTransaccionalSisRol(UsuarioSisRolDTO usersisrol) { 
		/*
		 * if(usersisrol.getLstRol() == null) { usersisrol.getLstSistema().forEach(s ->
		 * { List<Integer> listaRMF= repoRMF.buscarIdRolMenuFunxSistema(s.getSISCOD(),
		 * 1); listaRMF.forEach(i -> { UserSisRolFuncionalidad urmf = new
		 * UserSisRolFuncionalidad(); SisRolFuncionalidad rmf = new
		 * SisRolFuncionalidad(); // rmf.setROLMENFUNCOD(i); //
		 * urmf.setRolMenuFuncionalidad(rmf); Usuario usuario = new Usuario();
		 * usuario.setUSUCOD(usersisrol.getUsuario().getUSUCOD());
		 * urmf.setUsuario(usuario); repo.save(urmf); }); }); return 1;
		 * 
		 * } else { usersisrol.getLstRol().forEach(r -> {
		 * repo.eliminarUsuRolMenFunc(r.getSISCOD(),
		 * usersisrol.getUsuario().getUSUCOD()); }); usersisrol.getLstRol().forEach(r ->
		 * { List<Integer> listaRMF= repoRMF.buscarIdRolMenuFunxSistema(r.getSISCOD(),
		 * r.getROLCOD()); listaRMF.forEach(i -> { UserSisRolFuncionalidad urmf = new
		 * UserSisRolFuncionalidad(); SisRolFuncionalidad rmf = new
		 * SisRolFuncionalidad(); // rmf.setROLMENFUNCOD(i); //
		 * urmf.setRolMenuFuncionalidad(rmf); Usuario usuario = new Usuario();
		 * usuario.setUSUCOD(usersisrol.getUsuario().getUSUCOD());
		 * urmf.setUsuario(usuario); repo.save(urmf); }); }); return 1; }
		 */
		return 1;
	}

	@Override
	public List<UsuarioSistemaDTO> listarUsuarioSistema() {
		// TODO Auto-generated method stub
		return null; //repo.listarUsuarioSistema();
	}

	@Override
	public List<UsuarioSistemaDTO> listarSistemasAptos() {
		// TODO Auto-generated method stub
		return null; //repo.listarSistemasAptos();
	}

	@Override
	public List<UsuarioSistemaRolDTO> listarUsuarioSistemaRol() {
		// TODO Auto-generated method stub
		return repo.listarUsuarioSistemaRol();
	}

	@Override
	public List<UsuarioSistemaRolDTO> listarSistemaRolAptos() {
		// TODO Auto-generated method stub
		return null; //repo.listarSistemaRolAptos();
	}

	@Override
	public void eliminarUsuRolMenFunc(Integer siscod, Integer usucod) {
		// TODO Auto-generated method stub
		//repo.eliminarUsuRolMenFunc(siscod, usucod);
	}

	@Override
	public void eliminarAsignacionSisUsu(Integer usucod) {
		// TODO Auto-generated method stub
		//repo.eliminarAsignacionSisUsu(usucod);
	}
}
