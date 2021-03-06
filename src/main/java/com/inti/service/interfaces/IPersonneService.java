package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Personne;

public interface IPersonneService {
	List<Personne> findAll();

	Personne findOne(Long idPersonne);

	Personne save(Personne personne);

	void delete(Long idPersonne);

	Personne findByUsername(String username);

	Personne findByUsernameAndPassword(String username, String password);

	
	List<Personne> findByRole(String type);


	Personne findByEmail(String email);

}
