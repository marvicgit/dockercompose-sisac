package aate.gob.pe;

import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import aate.gob.pe.model.Menu;
import aate.gob.pe.model.Rol;
import aate.gob.pe.model.Usuario;
import aate.gob.pe.service.IRolService;
import aate.gob.pe.service.IUsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AateApplicationTests {
	
	@Autowired
	private IUsuarioService service;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
		
//	@Test
//	public void crearUsuario() {
//		Usuario us = new Usuario();
//		us.setESTREG(1);
//		us.setPRECOD(1);
//		us.setUSUAPEPAT("CARRILLO");
//		us.setUSUAPEMAT("DURAND");
//		us.setUSUBLO(0);
//		us.setUSUDNI("43408900");
//		us.setUSUSEXO(1);
//		us.setUSUAREA("SISTEMAS");
//		us.setUSUCARGO("ANALISTA");
//		us.setUSUCOR("DESARROLLO10@AATE.GOB.PE");
//		us.setUSUNOM("MARTIN");
//		us.setUSULOG("DESARROLLO10");
//		us.setUSUPAS(bcrypt.encode("123"));
//		System.out.println(us.getUSUPAS());
//		
//		Usuario retorno = service.registrar(us);
//
//		assertTrue(retorno.getUSUPAS().equalsIgnoreCase(us.getUSUPAS()));
//	}

}
