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

import aate.gob.pe.DTO.RolFuncionalidadDTO;
import aate.gob.pe.DTO.SisRolFuncionalidadDTO;
import aate.gob.pe.model.SisRolFuncionalidad;
import aate.gob.pe.service.ISisRolFuncionalidadService;

@RestController
@RequestMapping("/sistemaRolesFunc")
public class SisRolFuncionalidadController {

	@Autowired
	private ISisRolFuncionalidadService service;
	
	
	@GetMapping
	public ResponseEntity<List<SisRolFuncionalidadDTO>> listar()
	{
		List<SisRolFuncionalidadDTO> lista = service.listaSistemaRolFun();
		return new ResponseEntity<List<SisRolFuncionalidadDTO>>(lista, HttpStatus.OK);
	}
	
	 @PostMapping 
	 public ResponseEntity<Integer> registrar(@RequestBody RolFuncionalidadDTO rolfun)
	 { 
		 Integer rpta = service.registrarTransaccional(rolfun); 
		 return new ResponseEntity<Integer>(rpta, HttpStatus.CREATED); 
	 }

	@PutMapping
	public ResponseEntity<SisRolFuncionalidad> modificar(@RequestBody SisRolFuncionalidad rolmenfun) {
		rolmenfun.setFECMOD(LocalDate.now());
		SisRolFuncionalidad obj = service.modificar(rolmenfun);
		return new ResponseEntity<SisRolFuncionalidad>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}
}
