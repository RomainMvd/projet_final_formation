package com.inti.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Enseignant;


@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long>{
	
	Enseignant findByUsername(String username);
	Enseignant findByUsernameAndPassword(String username, String password);
	Enseignant findByEmail(String email);
	
	List<Enseignant> findBySalaire(Double salaire);
	List<Enseignant> findByEnabled(boolean enabled);
	
}
