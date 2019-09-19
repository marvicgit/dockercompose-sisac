package aate.gob.pe.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Table(name="ACSE_TM_RESET_TOKEN")
@Entity(name = "ResetToken")
//https://memorynotfound.com/spring-security-forgot-password-send-email-reset-password/
public class ResetToken implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACSE_SQ_TOKEN_RESET")
//    @SequenceGenerator(sequenceName = "ACSE_SQ_TOKEN_RESET", allocationSize = 1, name = "ACSE_SQ_TOKEN_RESET")
	@Column(name = "ID")
	private Long id;

	@Column(name = "TOKEN", nullable = false)
	private String token;

	@OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "USUCOD")
	private Usuario user;

	@Column(name = "EXPIRACION", nullable = false)
	private Date expiracion;	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Usuario getUsuario() {
		return user;
	}

	public void setUsuario(Usuario user) {
		this.user = user;
	}

	public Date getExpiracion() {
		return expiracion;
	}

	public void setExpiracion(Date expiracion) {
		this.expiracion = expiracion;
	}

	public void setExpiracion(int minutes) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, minutes);
		this.expiracion = now.getTime();
	}

	public boolean isExpirado() {
		return new Date().after(this.expiracion);
	}
}
