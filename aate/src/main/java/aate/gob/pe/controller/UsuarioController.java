package aate.gob.pe.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aate.gob.pe.DTO.ReporteDTO;
import aate.gob.pe.exception.ModeloNotFoundException;
import aate.gob.pe.model.Usuario;
import aate.gob.pe.service.IUsuarioService;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private IUsuarioService service;
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@GetMapping
	public List<Usuario> listar()
	{
		return service.listar();
	}
	
//	@PostMapping
//	public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
//		Usuario usu = service.registrar(usuario);
//		return new ResponseEntity<Usuario>(usu, HttpStatus.CREATED);
//	}
	
	@PutMapping
	public ResponseEntity<Usuario> modificar(@RequestBody Usuario usuario) {
		if(usuario.getUSUPAS() == null || usuario.getUSUPAS().trim() == "") {
			Usuario objeto = service.leer(usuario.getUSUCOD());
			usuario.setUSUPAS(objeto.getUSUPAS());
		} else {
			usuario.setUSUPAS(bcrypt.encode(usuario.getUSUPAS()));
		}
		usuario.setFECMOD(LocalDate.now());
		Usuario usu = service.modificar(usuario);
		return new ResponseEntity<Usuario>(usu, HttpStatus.OK);
	}

	@GetMapping("/BuscarUsuarioLdap/{user}")
	public ResponseEntity<Usuario> BuscarUsuarioLdap(@PathVariable("user") String user)
	{
		Usuario usuario= service.BuscarUsuarioLdap(user);
		if(usuario.getUSULOG() == null)
		{
			throw new ModeloNotFoundException("No se encontró el usuario en el ldap");
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PostMapping(produces = "application/json", consumes = "application/json")
	private ResponseEntity<Object> registrar(@RequestBody Usuario usuario){		
		usuario.setUSUPAS(bcrypt.encode(usuario.getUSUPAS()));
		service.registrar(usuario);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	@GetMapping("/ObtenerUsuarioDetalle")
	public ResponseEntity<List<ReporteDTO>> ObtenerUsuarioDetalle()
	{
		List<ReporteDTO> reporte= service.ObtenerDetalleUsusario();
		if(reporte ==null)
		{
			throw new ModeloNotFoundException("No se encontró el usuario en el ldap");
		}
		return new ResponseEntity<List<ReporteDTO>>(reporte, HttpStatus.OK);
	}
}
