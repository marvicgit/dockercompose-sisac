package aate.gob.pe.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import aate.gob.pe.model.Rol;
import aate.gob.pe.model.Sistema;
import aate.gob.pe.model.Usuario;
import aate.gob.pe.repo.ISistemaRepo;
import aate.gob.pe.repo.IUsuarioRepo;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
 
	@Autowired
	private IUsuarioRepo repoUser;
	@Autowired
	private ISistemaRepo repoSis;
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
  
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
         
        if (userName != null && authentication.getCredentials() != null) {
        	Usuario user = repoUser.buscarUsuarioxLogin(userName);
        	if(user != null) {
        		if(checkPass(password, user.getUSUPAS())) {
        			 String clientId = getClientId();
        	            if(clientId == "") {
        	            	 throw new BadCredentialsException("Authentication Failed!!!");
        	            	 
        	            } else {
        	            	Sistema sis = repoSis.siglaFindAll(clientId);
        	            	if(sis != null) {
        	            	List<GrantedAuthority> authorities = new ArrayList<>();
        	            	List<Rol> userRoles = repoUser.getUserRoleDetails(userName, clientId);
        	            	userRoles.forEach( role -> {
        	    			authorities.add(new SimpleGrantedAuthority(role.getROLSIG()));
        	            	});
        	                
        	                Authentication token =  new UsernamePasswordAuthenticationToken(userName, password, authorities);
        	                return token;
        	            	} else {
        	            		throw new BadCredentialsException("sistema Incorrecto!!!");
        	            	}
        	            }
        		} else {
        			throw new BadCredentialsException("Datos no encontrados!!!");
        		}
        	} else {
        		throw new BadCredentialsException("Datos no encontrados!!!");
        	}
           
        } else {
        	throw new BadCredentialsException("Ingreses sus credenciales!!!");
        }
    }
    
    private Boolean checkPass(String rawPassword, String encodedPassword) {
    	if (bcrypt.matches(rawPassword, encodedPassword))
    		return true;
    	else
    		return false;
    	}
    
    private  String getClientId(){
        final HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        final String authorizationHeaderValue = request.getHeader("Authorization");
        final String base64AuthorizationHeader = Optional.ofNullable(authorizationHeaderValue)
                .map(headerValue->headerValue.substring("Basic ".length())).orElse("");

        if(base64AuthorizationHeader != null || base64AuthorizationHeader != ""){
            String decodedAuthorizationHeader = new String(Base64.getDecoder().decode(base64AuthorizationHeader), Charset.forName("UTF-8"));
            return decodedAuthorizationHeader.split(":")[0];
        }

        return "";
    }
 
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}