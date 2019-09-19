package aate.gob.pe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="OAUTH_ACCESS_TOKEN ")
@Entity(name = "OauthAccesToken")
public class OauthAccesToken {
	  @Id
	  @Column(name = "TOKEN_ID", nullable = true)
	  private String token_id;
	  @Column(name = "TOKEN", nullable = true)
	  private byte[] token;
	  @Column(name = "AUTHENTICATION_ID", nullable = true)
	  private String authentication_id;
	  @Column(name = "USER_NAME", nullable = true)
	  private String user_name;
	  @Column(name = "CLIENT_ID", nullable = true)
	  private String client_id;
	  @Column(name = "AUTHENTICATION", nullable = true)
	  private byte[] authentication;
	  @Column(name = "REFRESH_TOKEN", nullable = true)
	  private String refresh_token;
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
	public String getAuthentication_id() {
		return authentication_id;
	}
	public void setAuthentication_id(String authentication_id) {
		this.authentication_id = authentication_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public byte[] getAuthentication() {
		return authentication;
	}
	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	  
}
