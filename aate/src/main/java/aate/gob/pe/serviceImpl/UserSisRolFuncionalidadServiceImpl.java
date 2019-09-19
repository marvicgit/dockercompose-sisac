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
	public List<UsuarioSistemaRolDTO> listarUsuarioSistemaRol() {
		// TODO Auto-generated method stub
		return repo.listarUsuarioSistemaRol();
	}

	@Override
	public long existeUsuario(Integer usucod) {
		// TODO Auto-generated method stub
		return repo.existeUsuario(usucod);
	}

	@Override
	public long existeSistema(Integer siscod) {
		// TODO Auto-generated method stub
		return repo.existeSistema(siscod);
	}

}
