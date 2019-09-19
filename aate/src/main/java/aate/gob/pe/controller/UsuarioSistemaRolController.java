package aate.gob.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aate.gob.pe.DTO.UsuarioSistemaDTO;
import aate.gob.pe.DTO.UsuarioSistemaRolDTO;
import aate.gob.pe.exception.ModeloNotFoundException;
import aate.gob.pe.model.UserSisRolFuncionalidad;
import aate.gob.pe.service.IUserSisRolFuncionalidadService;

@RestController
@RequestMapping("/userSistemaRoles")
public class UsuarioSistemaRolController {

	@Autowired
	private IUserSisRolFuncionalidadService service;	
	
	@GetMapping
	public ResponseEntity<List<UserSisRolFuncionalidad>> listar()
	{
		List<UserSisRolFuncionalidad> lista = service.listar();
		if(lista == 	null)
		{
			throw new ModeloNotFoundException("no eisten datos");
		}
		return new ResponseEntity<List<UserSisRolFuncionalidad>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarUsuarioSistema")
	public ResponseEntity<List<UsuarioSistemaDTO>> listarUsuarioSistema()
	{
		List<UsuarioSistemaDTO> lista = service.listarUsuarioSistema();
		if(lista == 	null)
		{
			throw new ModeloNotFoundException("no eisten datos");
		}
		return new ResponseEntity<List<UsuarioSistemaDTO>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarSistemasAptos")
	public ResponseEntity<List<UsuarioSistemaDTO>> listarSistemasAptos()
	{
		List<UsuarioSistemaDTO> lista = service.listarSistemasAptos();
		if(lista == 	null)
		{
			throw new ModeloNotFoundException("no eisten datos");
		}
		return new ResponseEntity<List<UsuarioSistemaDTO>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarUsuarioSistemaRol")
	public ResponseEntity<List<UsuarioSistemaRolDTO>> listarUsuarioSistemaRol()
	{
		List<UsuarioSistemaRolDTO> lista = service.listarUsuarioSistemaRol();
		if(lista == 	null)
		{
			throw new ModeloNotFoundException("no eisten datos");
		}
		return new ResponseEntity<List<UsuarioSistemaRolDTO>>(lista, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarSistemaRolAptos")
	public ResponseEntity<List<UsuarioSistemaRolDTO>> listarSistemaRolAptos()
	{
		List<UsuarioSistemaRolDTO> lista = service.listarSistemaRolAptos();
		if(lista == 	null)
		{
			throw new ModeloNotFoundException("no eisten datos");
		}
		return new ResponseEntity<List<UsuarioSistemaRolDTO>>(lista, HttpStatus.OK);
	}
	
	 @PostMapping 
	 public ResponseEntity<UserSisRolFuncionalidad> registrar(@RequestBody UserSisRolFuncionalidad ususisrol)
	 { 
		 UserSisRolFuncionalidad rpta = service.registrar(ususisrol); 
		 return new ResponseEntity<UserSisRolFuncionalidad>(rpta, HttpStatus.CREATED); 
	 }
	
}
