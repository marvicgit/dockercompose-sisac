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
import aate.gob.pe.model.Menu;
import aate.gob.pe.service.IMenuService;

@RestController
@RequestMapping("/menus")
public class MenuController {

	@Autowired
	private IMenuService service;

	@GetMapping
	public ResponseEntity<List<Menu>> listar()
	{
		List<Menu> lmenu = service.listar();
		return new ResponseEntity<List<Menu>>(lmenu, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarPorId/{id}")
	public ResponseEntity<Menu> listarPorId(@PathVariable("id") Integer idMenu)
	{
		Menu menu = service.leer(idMenu);
		if(menu.getMENCOD() ==null)
		{
			throw new ModeloNotFoundException("id no encontrado: "+ idMenu);
		}
		return new ResponseEntity<Menu>(menu, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarPorIdSistema/{id}")
	public ResponseEntity<List<Menu>> listarPorIdSistema(@PathVariable("id")Integer id)
	{
		List<Menu> lmenu = service.listarPorIdSistema(id);
		return new ResponseEntity<List<Menu>>(lmenu, HttpStatus.OK);
	}
	
	
	@PostMapping
	public  ResponseEntity<Menu> registrar(@RequestBody Menu menu) {
		Menu obj = service.registrar(menu);
		//obj.setFECREG(new LocalDate.);
		return new ResponseEntity<Menu>(obj, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Menu> modificar(@RequestBody Menu menu) {
		menu.setFECMOD(LocalDate.now());
		Menu obj = service.modificar(menu);
		return new ResponseEntity<Menu>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		service.eliminar(id);
	}
}
