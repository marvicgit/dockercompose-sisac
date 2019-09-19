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
import aate.gob.pe.model.Funcionalidad;
import aate.gob.pe.service.IFuncionalidadService;

@RestController
@RequestMapping("/funcionalidades")

public class FuncionalidadController {
	
	@Autowired
	private IFuncionalidadService service;
	
	@GetMapping
	public ResponseEntity<List<Funcionalidad>>listar()
	{
		List<Funcionalidad> lfuncionalidad = service.listar();
		if(lfuncionalidad==null)
		{
			throw new ModeloNotFoundException("Sin resultados");
		}
		
		return new ResponseEntity<List<Funcionalidad>>(lfuncionalidad, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarPorId/{id}")
	public ResponseEntity<Funcionalidad> listarPorId(@PathVariable("id") Integer id)
	{
		Funcionalidad funcionalidad = service.leer(id);
		if(funcionalidad.getFUNCOD() ==null)
		{
			throw new ModeloNotFoundException("id no encontrado: "+ id);
		}
		return new ResponseEntity<Funcionalidad>(funcionalidad, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Funcionalidad>  registrar(@RequestBody Funcionalidad fun) {
		Funcionalidad funcionalidad = service.registrar(fun);
		return new ResponseEntity<Funcionalidad>(funcionalidad, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Funcionalidad> modificar(@RequestBody Funcionalidad fun) {
		fun.setFECMOD(LocalDate.now());
		Funcionalidad funcionalidad = service.modificar(fun);
		return new ResponseEntity<Funcionalidad>(funcionalidad, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}

}
