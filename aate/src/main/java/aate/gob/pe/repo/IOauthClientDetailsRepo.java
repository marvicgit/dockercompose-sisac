package aate.gob.pe.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import aate.gob.pe.model.OauthClientDetails;

public interface IOauthClientDetailsRepo extends JpaRepository<OauthClientDetails,Integer>  {

}
