package aate.gob.pe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import aate.gob.pe.DTO.RolMenuDTO;
import aate.gob.pe.DTO.SistemaRolDTO;
import aate.gob.pe.model.RolMenu;
import aate.gob.pe.repo.IRolMenuRepo;
import aate.gob.pe.service.IRolMenuService;

@Service
public class RolMenuServiceImpl implements IRolMenuService {

	@Autowired
	private IRolMenuRepo repo;
	
	@Override
	public Integer registrarTransaccional(RolMenuDTO rolmenu) { 
		 rolmenu.getLstMenus().forEach(m -> { 
		  RolMenu rm = new RolMenu();
		  rm.setSISCOD(rolmenu.getSiscod());
		  rm.setRol(rolmenu.getRol()); 
		  rm.setMenu(m); 
		  repo.save(rm);
		  });	

		return 1;	 
	}
	
	@Override
	public RolMenu registrar(RolMenu t) {
	 return	repo.save(t);
	}

	@Override
	public RolMenu modificar(RolMenu t) {
		return	repo.save(t);
	}

	@Override
	public List<RolMenu> listar() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by(Sort.Direction.DESC, "ROLMENCOD"));
	}

	@Override
	public RolMenu leer(Integer id) {
		Optional<RolMenu> op = repo.findById(id);
		return op.isPresent() ? op.get() : new RolMenu();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<SistemaRolDTO> buscarSistemaRol() {
		// TODO Auto-generated method stub
		return repo.buscarSistemaRol();
	}

	@Override
	public List<Integer> buscarIdRolMenuxSistema(Integer siscod, Integer rolcod) {
		// TODO Auto-generated method stub
		return repo.buscarIdRolMenuxSistema(siscod, rolcod);
	}
}
