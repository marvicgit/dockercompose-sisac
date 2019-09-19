package aate.gob.pe.service;

import aate.gob.pe.model.ResetToken;

public interface IResetTokenService{

	ResetToken findByToken(String token);
	
	void guardar(ResetToken token);
	
	void eliminar(ResetToken token);

}
