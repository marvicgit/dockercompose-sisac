package aate.gob.pe.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import aate.gob.pe.model.ResetToken;


public interface IResetTokenRepo extends JpaRepository<ResetToken, Long> {
	
	//from ResetToken where token = :?
	ResetToken findByToken(String token);

}
