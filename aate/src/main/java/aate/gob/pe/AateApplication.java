package aate.gob.pe;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

import aate.gob.pe.model.Funcionalidad;
import aate.gob.pe.model.Menu;
import aate.gob.pe.model.Rol;
import aate.gob.pe.model.RolMenu;
import aate.gob.pe.model.SisRolFuncionalidad;
import aate.gob.pe.model.Sistema;
import aate.gob.pe.model.UserSisRolFuncionalidad;
import aate.gob.pe.model.Usuario;
import aate.gob.pe.service.IFuncionalidadService;
import aate.gob.pe.service.IMenuService;
import aate.gob.pe.service.IRolMenuService;
import aate.gob.pe.service.IRolService;
import aate.gob.pe.service.ISisRolFuncionalidadService;
import aate.gob.pe.service.ISistemaService;
import aate.gob.pe.service.IUserSisRolFuncionalidadService;
import aate.gob.pe.service.IUsuarioService;


@SpringBootApplication
public class AateApplication  {

	@Autowired
	private ISistemaService serviceSis;
	@Autowired
	private IUsuarioService service;
	@Autowired
	private IMenuService serviceMen;
	@Autowired
	private IRolService serviceRol;
	@Autowired
	private IFuncionalidadService serviceFun;
	@Autowired
	private IRolMenuService serviceRolMen;
	@Autowired
	private ISisRolFuncionalidadService serviceRolFun;
	@Autowired
	private IUserSisRolFuncionalidadService serviceSisUsu;
	
	public static void main(String[] args) {
		SpringApplication.run(AateApplication.class, args);
	}
	
	@Transactional
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	if (serviceSis.listar().isEmpty()) {
	    		Sistema objeto = new Sistema();
	    		objeto.setSISNOM("Sistema de Seguridad y Acceso");
	    		objeto.setSISSIG("SISAC");
	    		objeto.setSISDES("Sistema de Seguridad y Acceso");
	    		objeto.setESTREG(1);
				serviceSis.registrar(objeto);
			}
	    	
	    	if (serviceMen.listar().isEmpty()) {
	    		Sistema sis = new Sistema();
	    		sis.setSISCOD(1);
	    		Menu objeto = null;
	    		objeto = new Menu();
	    		objeto.setMENNOM("Sistema");
	    		objeto.setMENICO("fa-desktop");
	    		objeto.setMENORD(10);
	    		objeto.setMENRUT("/sistema");
	    		objeto.setMENSIG("SISAC_MNU_SISTEMA");
	    		objeto.setUSUREG("1");
	    		objeto.setESTREG(1);
	    		objeto.setSistema(sis);
	    		serviceMen.registrar(objeto);
	    		
	    		objeto = new Menu();
	    		objeto.setMENNOM("Menu");
	    		objeto.setMENICO("fa-th-list");
	    		objeto.setMENORD(20);
	    		objeto.setMENRUT("/menu");
	    		objeto.setMENSIG("SISAC_MNU_MENU");
	    		objeto.setUSUREG("1");
	    		objeto.setESTREG(1);
	    		objeto.setSistema(sis);
	    		serviceMen.registrar(objeto);
	    		
	    		objeto = new Menu();
	    		objeto.setMENNOM("Rol");
	    		objeto.setMENICO("fa-user-md");
	    		objeto.setMENORD(30);
	    		objeto.setMENRUT("/rol");
	    		objeto.setMENSIG("SISAC_MNU_ROL");
	    		objeto.setUSUREG("1");
	    		objeto.setESTREG(1);
	    		objeto.setSistema(sis);
	    		serviceMen.registrar(objeto);
	    		
	    		objeto = new Menu();
	    		objeto.setMENNOM("Funcionalidad");
	    		objeto.setMENICO("fa-wrench");
	    		objeto.setMENORD(40);
	    		objeto.setMENRUT("/funcionalidad");
	    		objeto.setMENSIG("SISAC_MNU_FUNC");
	    		objeto.setUSUREG("1");
	    		objeto.setESTREG(1);
	    		objeto.setSistema(sis);
	    		serviceMen.registrar(objeto);
	    		
	    		objeto = new Menu();
	    		objeto.setMENNOM("Asignar Menu - Rol");
	    		objeto.setMENICO("fa-exchange");
	    		objeto.setMENORD(50);
	    		objeto.setMENRUT("/rol-men");
	    		objeto.setMENSIG("SISAC_MNU_ROLMEN");
	    		objeto.setUSUREG("1");
	    		objeto.setESTREG(1);
	    		objeto.setSistema(sis);
	    		serviceMen.registrar(objeto);
	    		
	    		objeto = new Menu();
	    		objeto.setMENNOM("Asignar Func. - Rol");
	    		objeto.setMENICO("fa-exchange");
	    		objeto.setMENORD(60);
	    		objeto.setMENRUT("/rol-funcionalidad");
	    		objeto.setMENSIG("SISAC_MNU_ROLFUN");
	    		objeto.setUSUREG("1");
	    		objeto.setESTREG(1);
	    		objeto.setSistema(sis);
	    		serviceMen.registrar(objeto);
	    		
	    		objeto = new Menu();
	    		objeto.setMENNOM("Usuario");
	    		objeto.setMENICO("fa-user");
	    		objeto.setMENORD(60);
	    		objeto.setMENRUT("/usuario");
	    		//objeto.setMENSIG('SISAC_MNU_USUARIO');
	    		objeto.setUSUREG("1");
	    		objeto.setESTREG(1);
	    		objeto.setSistema(sis);
	    		serviceMen.registrar(objeto);
	    		
	    		objeto = new Menu();
	    		objeto.setMENNOM("Sistema - Usuario");
	    		objeto.setMENICO("fa-list-alt");
	    		objeto.setMENORD(70);
	    		objeto.setMENRUT("/sis-usuario");
	    		//objeto.setMENSIG('SISAC_MNU_SISUSU');
	    		objeto.setUSUREG("1");
	    		objeto.setESTREG(1);
	    		objeto.setSistema(sis);
	    		serviceMen.registrar(objeto);
	    		
	    		objeto = new Menu();
	    		objeto.setMENNOM("Reporte");
	    		objeto.setMENICO("fa-table");
	    		objeto.setMENORD(70);
	    		objeto.setMENRUT("/reporte");
	    		//objeto.setMENSIG('SISAC_MNU_REPORTE');
	    		objeto.setUSUREG("1");
	    		objeto.setESTREG(1);
	    		objeto.setSistema(sis);
	    		serviceMen.registrar(objeto);
			}
	    	
	    	if (serviceRol.listar().isEmpty()) {
				Rol objeto = new Rol();
				objeto.setROLNOM("ADMNISTRADOR");
				objeto.setROLDES("ADMNISTRADOR");
				objeto.setROLSIG("ROL_ADMIN");
				objeto.setUSUREG("1");
				objeto.setESTREG(1);
				serviceRol.registrar(objeto);
			}
	    	
	    	if (serviceFun.listar().isEmpty()) {
				Funcionalidad objeto = new Funcionalidad();
				objeto.setFUNNOM("ADMINISTRADOR");
				objeto.setFUNDES("ADMINISTRADOR");
				objeto.setFUNSIG("FUN_ADMIN");;
				objeto.setUSUREG("1");
				objeto.setESTREG(1);
				serviceFun.registrar(objeto);
			}
	    	
	    	if (serviceRolMen.listar().isEmpty()) {
	    		Rol rol = new Rol();
				rol.setROLCOD(1);
				Sistema sis = new Sistema();
	    		sis.setSISCOD(1);
				Menu menu = null;
				RolMenu objeto = null;
	    		
				menu = new Menu();
	    		menu.setMENCOD(1);
				menu.setSistema(sis);
				objeto = new RolMenu();
				objeto.setSISCOD(1);
				objeto.setMenu(menu);
				objeto.setRol(rol);
				objeto.setUSUREG("1");
				objeto.setESTREG(1);
				serviceRolMen.registrar(objeto);
				
				menu = new Menu();
	    		menu.setMENCOD(2);
				menu.setSistema(sis);
				objeto = new RolMenu();
				objeto.setSISCOD(1);
				objeto.setMenu(menu);
				objeto.setRol(rol);
				objeto.setUSUREG("1");
				objeto.setESTREG(1);
				serviceRolMen.registrar(objeto);
				
				menu = new Menu();
	    		menu.setMENCOD(3);
				menu.setSistema(sis);
				objeto = new RolMenu();
				objeto.setSISCOD(1);
				objeto.setMenu(menu);
				objeto.setRol(rol);
				objeto.setUSUREG("1");
				objeto.setESTREG(1);
				serviceRolMen.registrar(objeto);
				
				menu = new Menu();
	    		menu.setMENCOD(4);
				menu.setSistema(sis);
				objeto = new RolMenu();
				objeto.setSISCOD(1);
				objeto.setMenu(menu);
				objeto.setRol(rol);
				objeto.setUSUREG("1");
				objeto.setESTREG(1);
				serviceRolMen.registrar(objeto);
				
				menu = new Menu();
	    		menu.setMENCOD(5);
				menu.setSistema(sis);
				objeto = new RolMenu();
				objeto.setSISCOD(1);
				objeto.setMenu(menu);
				objeto.setRol(rol);
				objeto.setUSUREG("1");
				objeto.setESTREG(1);
				serviceRolMen.registrar(objeto);
				
				menu = new Menu();
	    		menu.setMENCOD(6);
				menu.setSistema(sis);
				objeto = new RolMenu();
				objeto.setSISCOD(1);
				objeto.setMenu(menu);
				objeto.setRol(rol);
				objeto.setUSUREG("1");
				objeto.setESTREG(1);
				serviceRolMen.registrar(objeto);
				
				menu = new Menu();
	    		menu.setMENCOD(7);
				menu.setSistema(sis);
				objeto = new RolMenu();
				objeto.setSISCOD(1);
				objeto.setMenu(menu);
				objeto.setRol(rol);
				objeto.setUSUREG("1");
				objeto.setESTREG(1);
				serviceRolMen.registrar(objeto);
				
				menu = new Menu();
	    		menu.setMENCOD(8);
				menu.setSistema(sis);
				objeto = new RolMenu();
				objeto.setSISCOD(1);
				objeto.setMenu(menu);
				objeto.setRol(rol);
				objeto.setUSUREG("1");
				objeto.setESTREG(1);
				serviceRolMen.registrar(objeto);
				
				menu = new Menu();
	    		menu.setMENCOD(9);
				menu.setSistema(sis);
				objeto = new RolMenu();
				objeto.setSISCOD(1);
				objeto.setMenu(menu);
				objeto.setRol(rol);
				objeto.setUSUREG("1");
				objeto.setESTREG(1);
				serviceRolMen.registrar(objeto);
			}
	    	
	    	if (serviceRolFun.listar().isEmpty()) {
	    		SisRolFuncionalidad objeto = new SisRolFuncionalidad();
	    		Rol rol = new Rol();
				rol.setROLCOD(1);
				Funcionalidad fun = new Funcionalidad();
				fun.setFUNCOD(1);
	    		objeto.setSISCOD(1);
	    		objeto.setRol(rol);
	    		objeto.setFuncionalidad(fun);
	    		objeto.setUSUREG("1");
				objeto.setESTREG(1);
				serviceRolFun.registrar(objeto);
	    	}
	    	
	    	if (service.listar().isEmpty()) {
				Usuario us = new Usuario();
				us.setUSUREG("1");
				us.setESTREG(1);
				us.setPRECOD(1);
				us.setUSUAPEPAT("CARRILLO");
				us.setUSUAPEMAT("DURAND");
				us.setUSUNOM("MARTIN");
				us.setUSUBLO(0);
				us.setUSUDNI("43408900");
				us.setUSUSEXO(1);
				us.setUSUAREA("SISTEMAS");
				us.setUSUCARGO("ANALISTA");
				us.setUSUCOR("DESARROLLO10@AATE.GOB.PE");
				us.setUSULOG("DESARROLLO10");
				us.setUSUPAS("$2a$10$EpTxl48p8zvBfSMvT2W/9uY20PVl29ANqlAjdT3KGrGbRPClrGQUC");
				//System.out.println("Usuario = DESARROLLO10 y Contraseña = 123");
				service.registrar(us);
			}
	    	
	    	if (serviceSisUsu.listar().isEmpty()) {
	    		UserSisRolFuncionalidad objeto = new UserSisRolFuncionalidad();
	    		Rol rol = new Rol();
				rol.setROLCOD(1);
				Usuario usu = new Usuario();
				usu.setUSUCOD(1);
	    		objeto.setSISCOD(1);
	    		objeto.setRol(rol);
	    		objeto.setUsuario(usu);
	    		objeto.setUSUREG("1");
				objeto.setESTREG(1);
				serviceSisUsu.registrar(objeto);
	    	}
	    	
	    	/*if (serviceOauth.listar().isEmpty()) {
	    		OauthClientDetails auth = new OauthClientDetails();
	    		auth.setClient_id("SISAC");
	    		auth.setClient_secret("$2a$10$4shvkjncsFvuLIu.DD6w3OE8MnTwdfQzqPTDDTaCsHftPYHE1Lu6u");
	    		auth.setScope("read,write,trust");
	    		auth.setAuthorized_grant_types("password,refresh_token");
	    		auth.setAuthorities("role_client,role_trusted_client");
	    		auth.setAccess_token_validity(900);
	    		auth.setRefresh_token_validity(2592000);
				//System.out.println(us.getUSUPAS());
	    		serviceOauth.registrar(auth);
			}*/
	      };
	   }
	
}
