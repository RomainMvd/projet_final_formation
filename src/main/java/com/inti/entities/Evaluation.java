package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Evaluation implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEvaluation;
	private String commentaire;
	private Double noteCours;
	
	
	@ManyToOne
	@JoinColumn(name="id_cours")
	private Cours cours;

	public Evaluation(String commentaire, Cours cours) {
		
		this.commentaire = commentaire;
		
		this.cours = cours;
	}
	
	

	public Evaluation(String commentaire, Double noteCours, Cours cours) {
		super();
		this.commentaire = commentaire;
		this.noteCours = noteCours;
		this.cours = cours;
	}



	public Evaluation(String commentaire) {
		
		this.commentaire = commentaire;
		
	}

	public Evaluation() {
		
	}

	public Long getIdEvaluation() {
		return idEvaluation;
	}

	public void setIdEvaluation(Long idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	

	public Double getNoteCours() {
		return noteCours;
	}

	public void setNoteCours(Double noteCours) {
		this.noteCours = noteCours;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}



	@Override
	public String toString() {
		return "Evaluation [commentaire=" + commentaire + ", noteCours=" + noteCours + ", cours=" + cours + "]";
	}

	
	
	
}
/*
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long
 * idEvaluation; private Long noteCours; private String commentaire; private
 * String nomCours;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name = "id_cours") private Cours cours;
 * 
 * public Evaluation() {
 * 
 * }
 * 
 * public Evaluation(Long idEvaluation, Long noteCours, String commentaire,
 * String nomCours) { this.idEvaluation = idEvaluation; this.noteCours =
 * noteCours; this.commentaire = commentaire; this.nomCours = nomCours; }
 * 
 * public Long getIdEvaluation() { return idEvaluation; }
 * 
 * public void setIdEvaluation(Long idEvaluation) { this.idEvaluation =
 * idEvaluation; }
 * 
 * public Long getNoteCours() { return noteCours; }
 * 
 * public void setNoteCours(Long noteCours) { this.noteCours = noteCours; }
 * 
 * public String getCommentaire() { return commentaire; }
 * 
 * public void setCommentaire(String commentaire) { this.commentaire =
 * commentaire; }
 * 
 * public String getNomCours() { return nomCours; }
 * 
 * public void setNomCours(String nomCours) { this.nomCours = nomCours; }
 * 
 * public Cours getCours() { return cours; }
 * 
 * public void setCours(Cours cours) { this.cours = cours; }
 * 
 * }
 */
