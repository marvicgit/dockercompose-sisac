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

import aate.gob.pe.DTO.RolMenuDTO;
import aate.gob.pe.DTO.SistemaRolDTO;
import aate.gob.pe.model.RolMenu;
import aate.gob.pe.service.IRolMenuService;

@RestController
@RequestMapping("/rolesMenus")
public class RolMenuController {

	@Autowired
	private IRolMenuService service;
	
	@GetMapping
	public ResponseEntity<List<RolMenu>> listar()
	{
		List<RolMenu> lRol = service.listar();
		return new ResponseEntity<List<RolMenu>>(lRol, HttpStatus.OK);
	}
	
	@GetMapping(value = "listarSisRol")
	public ResponseEntity<List<SistemaRolDTO>> listarSistemaRol()
	{
		List<SistemaRolDTO> lRol = service.buscarSistemaRol();
		return new ResponseEntity<List<SistemaRolDTO>>(lRol, HttpStatus.OK);
	}
	
	@PostMapping
	public  ResponseEntity<Integer> registrar(@RequestBody RolMenuDTO rolmenu) {
		Integer obj = service.registrarTransaccional(rolmenu);
		return new ResponseEntity<Integer>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<RolMenu> modificar(@RequestBody RolMenu rolmenfun) {
		rolmenfun.setFECMOD(LocalDate.now());
		RolMenu obj = service.modificar(rolmenfun);
		return new ResponseEntity<RolMenu>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}
	
}
