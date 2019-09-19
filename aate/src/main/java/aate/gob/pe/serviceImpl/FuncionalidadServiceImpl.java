package aate.gob.pe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import aate.gob.pe.model.Funcionalidad;
import aate.gob.pe.repo.IFuncionalidadRepo;
import aate.gob.pe.service.IFuncionalidadService;


@Service
public class FuncionalidadServiceImpl implements IFuncionalidadService {

	@Autowired
	IFuncionalidadRepo repo;

	@Override
	public Funcionalidad registrar(Funcionalidad t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public Funcionalidad modificar(Funcionalidad t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public List<Funcionalidad> listar() {
		return repo.findAll(Sort.by(Sort.Direction.DESC, "FUNCOD"));
	}

	@Override
	public Funcionalidad leer(Integer id) {
		// TODO Auto-generated method stub
		Optional<Funcionalidad> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Funcionalidad();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	


	

}
