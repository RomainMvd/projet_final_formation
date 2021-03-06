package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Etudiant;
import com.inti.entities.Personne;
import com.inti.repository.EtudiantRepository;
import com.inti.repository.PersonneRepository;
import com.inti.service.interfaces.IEtudiantService;
import com.inti.service.interfaces.IPersonneService;

@Service
public class EtudiantService implements IEtudiantService {

	@Autowired
	EtudiantRepository etudiantRepository;

	@Override
	public List<Etudiant> findAll() {
		return etudiantRepository.findAll();
	}

	@Override
	public Etudiant findOne(Long idEtudiant) {
		return etudiantRepository.findById(idEtudiant).get();
	}

	@Override
	public Etudiant save(Etudiant etudiant) {
		return etudiantRepository.save(etudiant);
	}

	@Override
	public void delete(Long idEtudiant) {
		etudiantRepository.deleteById(idEtudiant);

	}

	@Override
	public Etudiant findByUsername(String username) {
		return etudiantRepository.findByUsername(username);
	}

	@Override
	public Etudiant findByUsernameAndPassword(String username, String password) {
		return etudiantRepository.findByUsernameAndPassword(username, password);
	}


	@Override
	public Etudiant findByEmail(String email) {
		return etudiantRepository.findByEmail(email);
	}

	@Override
	public List<Etudiant> findByMoyenne(Double moyenne) {
		return etudiantRepository.findByMoyenne(moyenne);
	}

	@Override
	public List<Etudiant> findByEnabled(boolean enabled) {
		return etudiantRepository.findByEnabled(enabled);
	}
	

}
