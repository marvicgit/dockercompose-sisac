package aate.gob.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aate.gob.pe.exception.ModeloNotFoundException;
import aate.gob.pe.model.Sistema;
import aate.gob.pe.repo.IUserSisRolFuncionalidadRepo;
import aate.gob.pe.service.IRolMenuService;
import aate.gob.pe.service.ISisRolFuncionalidadService;
import aate.gob.pe.service.ISistemaService;

   
@RestController
@RequestMapping("/sistemas")
public class SistemaController {

	@Autowired
	private ISistemaService service;
	@Autowired
	private IUserSisRolFuncionalidadRepo serviceUserRol;
	@Autowired
	private ISisRolFuncionalidadService serviceRolFun;
	@Autowired
	private IRolMenuService serviceRolMen;
	
	@GetMapping
	public ResponseEntity<List<Sistema>> listar()
	{
		List<Sistema> sis = service.listar();
		if(sis==null)
		{
			throw new ModeloNotFoundException("Sin resultados");
		}
		return new ResponseEntity<List<Sistema>>(sis, HttpStatus.OK);
	}

	@GetMapping(value = "/listarPorId/{id}")
	public ResponseEntity<Sistema> listarPorId(@PathVariable("id") Integer idSistema)
	{	
		Sistema sis = service.leer(idSistema);
		if(sis.getSISCOD() ==null)
		{
			throw new ModeloNotFoundException("id no encontrado: "+ idSistema);
		}
		return new ResponseEntity<Sistema>(sis, HttpStatus.OK);
	}
	
	@GetMapping(value = "/buscarSistema")
	public List<Sistema> buscarSistema(@RequestBody Sistema filtro)
	{
		return service.buscarSistema(filtro);
	}
	
	@PostMapping
	public ResponseEntity<Sistema> registrar(@RequestBody Sistema sistema) {
		Sistema sis = service.registrar(sistema);
		return new ResponseEntity<Sistema>(sis, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Sistema> modificar(@RequestBody Sistema sistema) {
		Sistema sis = service.modificar(sistema);
		return new ResponseEntity<Sistema>(sis, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		if(serviceUserRol.existeSistema(id) > 0) {
			throw new ModeloNotFoundException("El sistema tiene asignación de usuario");
		}
		if(serviceRolFun.existeSistema(id) > 0) {
			throw new ModeloNotFoundException("El sistema tiene asignación de funcionalidades");
		}
		if(serviceRolFun.existeSistema(id) > 0) {
			throw new ModeloNotFoundException("El sistema tiene asignación de roles");
		}
		service.eliminar(id);
	}
}
