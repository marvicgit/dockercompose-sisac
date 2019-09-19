package aate.gob.pe.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import aate.gob.pe.model.Usuario;

public interface ILoginRepo extends JpaRepository<Usuario, Integer>{

	@Query(value = "select u from Usuario u WHERE u.USULOG = :username")
	Usuario verificarNombreUsuario(String username);
	
	@Transactional
	@Modifying
	@Query("UPDATE Usuario us SET us.USUPAS = :clave WHERE us.USULOG = :nombre")
	void cambiarClave(@Param("clave") String clave, @Param("nombre") String nombre) throws Exception;
}
