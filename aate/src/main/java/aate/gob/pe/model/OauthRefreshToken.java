package aate.gob.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="OAUTH_REFRESH_TOKEN ")
@Entity(name = "OauthRefreshToken")
public class OauthRefreshToken {
	 @Id
	  @Column(name = "TOKEN_ID", nullable = true)
	  private String token_id;
	 @Column(name = "TOKEN", nullable = true)
	  private byte[] token;
	 @Column(name = "AUTHENTICATION", nullable = true)
	  private byte[] authentication;
	public String getToken_id() {
		return token_id;
	}
	public void setToken_id(String token_id) {
		this.token_id = token_id;
	}
	public byte[] getToken() {
		return token;
	}
	public void setToken(byte[] token) {
		this.token = token;
	}
	public byte[] getAuthentication() {
		return authentication;
	}
	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}
	 
}
