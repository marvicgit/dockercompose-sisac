package aate.gob.pe.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aate.gob.pe.model.OauthClientDetails;
import aate.gob.pe.repo.IOauthClientDetailsRepo;
import aate.gob.pe.service.IOauthClientDetailsService;

@Service
public class OauthClientDetailsServiceImpl implements IOauthClientDetailsService {

	@Autowired
	private IOauthClientDetailsRepo repo;
	@Override
	public OauthClientDetails registrar(OauthClientDetails t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public OauthClientDetails modificar(OauthClientDetails t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public List<OauthClientDetails> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public OauthClientDetails leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

}
