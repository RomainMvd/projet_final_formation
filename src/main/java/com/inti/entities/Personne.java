package com.inti.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "personne_type", discriminatorType = DiscriminatorType.STRING) 
public class Personne implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPersonne;
	private String nomPersonne;
	private String prenomPersonne;
	@Temporal(TemporalType.DATE)
	private Date dateNaissancePersonne;
	@Column(unique = true)
	private String username;
	private String password;
	@Column(unique = true)
	private String email;
	private boolean enabled = true;
	@Lob
	private byte[] photoProfil; // A RETIRER ?
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "profil", joinColumns = @JoinColumn(name = "id_personne", referencedColumnName = "idPersonne"), inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole"))
	private Set<Role> roles = new HashSet<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "lecture", joinColumns = @JoinColumn(name="id_personne", referencedColumnName = "idPersonne"), inverseJoinColumns = @JoinColumn(name="id_cours", referencedColumnName = "idCours"))
	private Set<Cours> courss = new HashSet<>();

	public Personne(String nomPersonne, String prenomPersonne, Date dateNaissancePersonne, String username,
			String password, String email, boolean enabled, byte[] photoProfil, Set<Role> roles, Set<Cours> courss) {
		
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.dateNaissancePersonne = dateNaissancePersonne;
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.photoProfil = photoProfil;
		this.roles = roles;
		this.courss = courss;
	}

	public Personne(String nomPersonne, String prenomPersonne, Date dateNaissancePersonne, String username,
			String password, String email, boolean enabled, byte[] photoProfil) {
		
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.dateNaissancePersonne = dateNaissancePersonne;
		this.username = username;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.photoProfil = photoProfil;
	}

	public Personne() {
		
	}

	public Long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getPrenomPersonne() {
		return prenomPersonne;
	}

	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}

	public Date getDateNaissancePersonne() {
		return dateNaissancePersonne;
	}

	public void setDateNaissancePersonne(Date dateNaissancePersonne) {
		this.dateNaissancePersonne = dateNaissancePersonne;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public byte[] getPhotoProfil() {
		return photoProfil;
	}

	public void setPhotoProfil(byte[] photoProfil) {
		this.photoProfil = photoProfil;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Cours> getCourss() {
		return courss;
	}

	public void setCourss(Set<Cours> courss) {
		this.courss = courss;
	}

	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nomPersonne=" + nomPersonne + ", prenomPersonne="
				+ prenomPersonne + ", dateNaissancePersonne=" + dateNaissancePersonne + ", username=" + username
				+ ", password=" + password + ", email=" + email + ", enabled=" + enabled + ", photoProfil="
				+ Arrays.toString(photoProfil) + "]";
	}
	
	
}
/*
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersonne;
	private String nomPersonne;
	private String prenomPersonne;
	private Date dateNaissance;
	@Column(unique = true)
	private String username;
	private String password;
	private String email;
	private boolean enabled = true;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Lecture", joinColumns = @JoinColumn(name = "id_personne", referencedColumnName = "idPersonne"), inverseJoinColumns = @JoinColumn(name = "id_matiere", referencedColumnName = "idMatiere"))
	private Set<Cours> courss = new HashSet<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Profil", joinColumns = @JoinColumn(name = "id_personnee", referencedColumnName = "idPersonne"), inverseJoinColumns = @JoinColumn(name = "id_rolee", referencedColumnName = "idRole"))
	private Set<Role> roles = new HashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_classe")
	private Classe classe;

	public Personne(String nomPersonne, String prenomPersonne, Date dateNaissance, String username, String password,
			String email) {
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.dateNaissance = dateNaissance;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Personne() {
	}

	public Personne(String nomPersonne, String prenomPersonne, Date dateNaissance, String username, String password,
			String email, Set<Cours> courss, Set<Role> roles) {
		super();
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.dateNaissance = dateNaissance;
		this.username = username;
		this.password = password;
		this.email = email;
		this.courss = courss;
		this.roles = roles;
	}

	public Long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNomPersonne() {
		return nomPersonne;
	}

	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}

	public String getPrenomPersonne() {
		return prenomPersonne;
	}

	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Cours> getCourss() {
		return courss;
	}

	public void setCourss(Set<Cours> courss) {
		this.courss = courss;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nomPersonne=" + nomPersonne + ", prenomPersonne="
				+ prenomPersonne + ", dateNaissance=" + dateNaissance + ", username=" + username + ", password="
				+ password + ", email=" + email + ", classe=" + classe + "]";
	}

}
*/
