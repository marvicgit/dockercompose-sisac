package aate.gob.pe.controller;

import java.time.LocalDate;
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
import aate.gob.pe.model.Rol;
import aate.gob.pe.service.IRolMenuService;
import aate.gob.pe.service.IRolService;
import aate.gob.pe.service.ISisRolFuncionalidadService;

@RestController
@RequestMapping("/roles")
public class RolController {

	@Autowired
	private IRolService service;
	@Autowired
	private IRolMenuService serviceRolMen;
	@Autowired
	private ISisRolFuncionalidadService serviceRolFun;
	
	@GetMapping
	public ResponseEntity<List<Rol>> listar()
	{
		List<Rol> lRol = service.listar();
		return new ResponseEntity<List<Rol>>(lRol, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarPorId/{id}")
	public ResponseEntity<Rol> listarPorId(@PathVariable("id") Integer idRol)
	{
		Rol rol = service.leer(idRol);
		if(rol.getROLCOD() ==null)
		{
			throw new ModeloNotFoundException("id no encontrado: "+ idRol);
		}
		return new ResponseEntity<Rol>(rol, HttpStatus.OK);
	}
	
	
	@PostMapping
	public  ResponseEntity<Rol> registrar(@RequestBody Rol rol) {
		Rol obj = service.registrar(rol);
		return new ResponseEntity<Rol>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Rol> modificar(@RequestBody Rol rol) {
		rol.setFECMOD(LocalDate.now());
		Rol obj = service.modificar(rol);
		return new ResponseEntity<Rol>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		if(serviceRolMen.existeRol(id) > 0) {
			throw new ModeloNotFoundException("El rol tiene asignación de menú");
		}
		if(serviceRolFun.existeRol(id) > 0) {
			throw new ModeloNotFoundException("El rol tiene asignación de funcionalidad");
		}
		service.eliminar(id);
	}
	
}
