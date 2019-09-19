package aate.gob.pe.controller;

import javax.annotation.Resource;

import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {
	
	@Resource(name = "tokenServices")
	private ConsumerTokenServices tokenServices;
	
	//  anular/12/05-2019  2019/52
	@GetMapping(value = "/anular/{tokenId:.*}")
	public void revokeToken(@PathVariable("tokenId") String token) {
		tokenServices.revokeToken(token);				
	}

}
