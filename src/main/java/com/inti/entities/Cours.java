package com.inti.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "cours_type", discriminatorType = DiscriminatorType.STRING)
public class Cours implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCours;
	private String nomCours;
	private String nomMatiere;
	private Double nbrHeure;
	@Lob
	private byte[] fichierCours;
	@OneToMany(mappedBy = "cours")
	private Set<Evaluation> evaluations = new HashSet<>();

	@OneToMany(mappedBy = "cours")
	private Set<Examen> examens = new HashSet<>();

	public Cours(String nomCours, String nomMatiere, Double nbrHeure, Set<Evaluation> evaluations,
			Set<Examen> examens) {
		this.nomCours = nomCours;
		this.nomMatiere = nomMatiere;
		this.nbrHeure = nbrHeure;
		this.evaluations = evaluations;
		this.examens = examens;

	}

	public Cours(String nomCours, String nomMatiere, Double nbrHeure) {
		this.nomCours = nomCours;
		this.nomMatiere = nomMatiere;

		this.nbrHeure = nbrHeure;
	}

	public Cours() {
	}

	public Long getIdCours() {
		return idCours;
	}

	public void setIdCours(Long idCours) {
		this.idCours = idCours;
	}

	public String getNomCours() {
		return nomCours;
	}

	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}

	public String getNomMatiere() {
		return nomMatiere;
	}

	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}

	public Double getNbrHeure() {
		return nbrHeure;
	}

	public void setNbrHeure(Double nbrHeure) {
		this.nbrHeure = nbrHeure;
	}

	public Set<Evaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(Set<Evaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public Set<Examen> getExamens() {
		return examens;
	}

	public void setExamens(Set<Examen> examens) {
		this.examens = examens;
	}

	public byte[] getFichierCours() {
		return fichierCours;
	}

	public void setFichierCours(byte[] fichierCours) {
		this.fichierCours = fichierCours;
	}

	@Override
	public String toString() {
		return "Cours [idCours=" + idCours + ", nomCours=" + nomCours + ", nomMatiere=" + nomMatiere + ", nbrHeure="
				+ nbrHeure + ", fichierCours=" + Arrays.toString(fichierCours) + ", evaluations=" + evaluations
				+ ", examens=" + examens + "]";
	}

	

}
/*
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long idCours;
 * private String chapitre; private Long nbrHeure;
 * 
 * @Lob private byte [] fichierCours;
 * 
 * @ManyToOne private Matiere matiere;
 * 
 * @OneToMany(mappedBy = "cours") private List<Evaluation> evaluation = new
 * ArrayList<>();
 * 
 * public Cours () {
 * 
 * }
 * 
 * public Cours(String chapitre, Long nbrHeure, byte[] fichierCours) {
 * this.chapitre = chapitre; this.nbrHeure = nbrHeure; this.fichierCours =
 * fichierCours; }
 * 
 * public Long getIdCours() { return idCours; }
 * 
 * public void setIdCours(Long idCours) { this.idCours = idCours; }
 * 
 * public String getChapitre() { return chapitre; }
 * 
 * public void setChapitre(String chapitre) { this.chapitre = chapitre; }
 * 
 * public Long getNbrHeure() { return nbrHeure; }
 * 
 * public void setNbrHeure(Long nbrHeure) { this.nbrHeure = nbrHeure; }
 * 
 * public byte[] getFichierCours() { return fichierCours; }
 * 
 * public void setFichierCours(byte[] fichierCours) { this.fichierCours =
 * fichierCours; }
 * 
 * public Matiere getMatiere() { return matiere; }
 * 
 * public void setMatiere(Matiere matiere) { this.matiere = matiere; }
 * 
 * @Override public String toString() { return "Cours [idCours=" + idCours +
 * ", chapitre=" + chapitre + ", nbrHeure=" + nbrHeure + ", fichierCours=" +
 * Arrays.toString(fichierCours) + "]"; }
 * 
 * 
 * 
 * }
 */