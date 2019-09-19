package aate.gob.pe.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aate.gob.pe.DTO.RolMenuFuncDTO;
import aate.gob.pe.exception.ModeloNotFoundException;
import aate.gob.pe.model.ResetToken;
import aate.gob.pe.model.Usuario;
import aate.gob.pe.service.ILoginService;
import aate.gob.pe.service.IResetTokenService;
import aate.gob.pe.service.ISisRolFuncionalidadService;
import aate.gob.pe.util.EmailService;
import aate.gob.pe.util.Mail;

@RestController
@RequestMapping("/login")
public class loginController {

	@Autowired
	private ILoginService service;

	@Autowired
	private IResetTokenService tokenService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
    private ISisRolFuncionalidadService eservice;
	

	@PostMapping(value = "/enviarCorreo", consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<Integer> enviarCorreo(@RequestBody String username) {
		int rpta = 0;
		try {
			Usuario us = service.verificarNombreUsuario(username);
			if (us != null && us.getUSUCOD() > 0) {
			
				ResetToken token = new ResetToken();
				token.setToken(UUID.randomUUID().toString());
				token.setUsuario(us);
				token.setExpiracion(10);
				tokenService.guardar(token);
				
				Mail mail = new Mail();
				mail.setFrom("alertaplicaciones@aate.gob.pe");
				mail.setTo(us.getUSUCOR());
				mail.setSubject("RESTABLECER CONTRASEÑA - SISAC");
				
				Map<String, Object> model = new HashMap<>();
				String url = "http://localhost:4200/recuperar/" + token.getToken();
				model.put("user", token.getUsuario().getUSULOG());
				model.put("resetUrl", url);
				mail.setModel(model);
				emailService.sendEmail(mail);
				rpta = 1;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}
	
	@GetMapping(value = "/restablecer/verificar/{token}")
	public ResponseEntity<Integer> restablecerClave(@PathVariable("token") String token) {
		int rpta = 0;
		try {
			if (token != null && !token.isEmpty()) {
				ResetToken rt = tokenService.findByToken(token);
				if (rt != null && rt.getId() > 0) {
					if (!rt.isExpirado()) {
						rpta = 1;
					}
				}
			}
		} catch (Exception e) {
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}
	
	@PostMapping(value = "/restablecer/{token}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> restablecerClave(@PathVariable("token") String token, @RequestBody String clave) {
		int rpta = 0;
		try {
			ResetToken rt = tokenService.findByToken(token);
			String claveHash = bcrypt.encode(clave);
			rpta = service.cambiarClave(claveHash, rt.getUsuario().getUSULOG());
			tokenService.eliminar(rt);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}
	
	@PostMapping(value = "/cambiarClave")
	public ResponseEntity<Integer> cambiarClave(@RequestBody Usuario usuario) {
		int rpta = 0;
		try {
			//ResetToken rt = tokenService.findByToken("");
			String claveHash = bcrypt.encode(usuario.getUSUPAS());
			rpta = service.cambiarClave(claveHash, usuario.getUSULOG());
			//tokenService.eliminar(rt);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(rpta, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
	}

	@PostMapping(value = "/permisos")
    public ResponseEntity <RolMenuFuncDTO>acceso(@RequestBody RolMenuFuncDTO entidad)
    {
          RolMenuFuncDTO beEntidad = eservice.obtenerAcceso(entidad.getSissig(), entidad.getUsulog());
          if(beEntidad== null)
          {
                 throw new ModeloNotFoundException("Usuario no registrado");
          }
          
          return new ResponseEntity<RolMenuFuncDTO>(beEntidad, HttpStatus.OK);
    }

}
