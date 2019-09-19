package aate.gob.pe.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aate.gob.pe.DTO.RolFuncionalidadDTO;
import aate.gob.pe.DTO.RolMenuFuncDTO;
import aate.gob.pe.DTO.SisRolFuncionalidadDTO;
import aate.gob.pe.model.Rol;
import aate.gob.pe.model.SisRolFuncionalidad;
import aate.gob.pe.repo.ISisRolFuncionalidadRepo;
import aate.gob.pe.service.ISisRolFuncionalidadService;

@Service
public class SisRolFuncionalidadServiceImpl implements ISisRolFuncionalidadService {

	@Autowired
	private ISisRolFuncionalidadRepo repo;
	
	@Override
	public SisRolFuncionalidad registrar(SisRolFuncionalidad t) {
	 return	repo.save(t);
	}

	@Override
	public SisRolFuncionalidad modificar(SisRolFuncionalidad t) {
		return	repo.save(t);
	}

	@Override
	public List<SisRolFuncionalidad> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public SisRolFuncionalidad leer(Integer id) {
		Optional<SisRolFuncionalidad> op = repo.findById(id);
		return op.isPresent() ? op.get() : new SisRolFuncionalidad();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	//@Transactional
	@Override
	public Integer registrarTransaccional(RolFuncionalidadDTO rolfun) { 
		//List<Integer> listaRM = repoMR.buscarIdRolMenuxSistema(rolfun.getSISCOD(), rolfun.getROLCOD());
		//listaRM.forEach(i -> {
			rolfun.getLstFuncionalidad().forEach(f -> {
				SisRolFuncionalidad mrf = new SisRolFuncionalidad();
				mrf.setSISCOD(rolfun.getSISCOD());
				Rol r = new Rol();
				r.setROLCOD(rolfun.getROLCOD());
				mrf.setRol(r);
				mrf.setFuncionalidad(f); 
				repo.save(mrf);			
			});
		//});
		
		return 1;
		 
	}

	@Override
	public List<SisRolFuncionalidadDTO> listaSistemaRolFun() {
		// TODO Auto-generated method stub
		return repo.listaSistemaRolFun();
	}

	@Override
	public void eliminarRolMenFunc(SisRolFuncionalidadDTO sisrolfun) {
		// TODO Auto-generated method stub
		//repo.eliminarRolMenFunc(sisrolfun.getSistema().getSISCOD(), sisrolfun.getRol().getROLCOD(), sisrolfun.getFuncionalidad().getFUNCOD());
	}

	@Override
	public List<Integer> buscarIdRolMenuFunxSistema(Integer siscod, Integer rolcod) {
		// TODO Auto-generated method stub
		return null; //repo.buscarIdRolMenuFunxSistema(siscod, rolcod);
	}
	
	@Override
    public RolMenuFuncDTO obtenerAcceso(String vSissig, String vUsulog) {
          RolMenuFuncDTO entidad = new RolMenuFuncDTO();

          try {
                 entidad.setRoles(repo.listaRol(vSissig, vUsulog));
                 entidad.setMenus(repo.listaMenu(vSissig, vUsulog));
                 entidad.setFuncionalidades(repo.listaFuncionalidad(vSissig, vUsulog));
                 RolMenuFuncDTO beEntidad = new RolMenuFuncDTO();
                 beEntidad = repo.ObtenerAcceso(vSissig, vUsulog);
                 entidad.setSissig(beEntidad.getSissig());
                 entidad.setUsulog(beEntidad.getUsulog());
                 entidad.setUsucod(beEntidad.getUsucod());
          } catch (Exception ex) {
                 entidad = null;

          }

          return entidad;
    }

	@Override
	public long existeSistema(Integer siscod) {
		// TODO Auto-generated method stub
		return repo.existeSistema(siscod);
	}

	@Override
	public long existeRol(Integer rolcod) {
		// TODO Auto-generated method stub
		return repo.existeRol(rolcod);
	}

	@Override
	public long existeFuncionalidad(Integer funcod) {
		// TODO Auto-generated method stub
		return repo.existeFuncionalidad(funcod);
	}


}
