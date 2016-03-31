package com.sprsec.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tablechat")
public class Chat implements Serializable{

	/**contient la liste des getter et setter 
	 * necessaire pour faire le lien avec la bdd
	 **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_chat", unique = true, nullable = false)
	private Integer idChat;
	
	@Column(name = "NOM", length = 50)
	private String nom;
	@Column(name = "NOM_JAPONAIS", length = 50)
	private String nomJaponais;
	@Column(name = "DESCRIPTION", length = 50)
	private String description;
	@Column(name = "PERSONNALITE", length = 50)
	private String personnalite;
	@Column(name = "NIVEAU")
	private Integer niveau;
	@Column(name = "RARE")
	private Integer rare;
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tablechat")
//	private Set<Astuce> astuces = new HashSet<Astuce>(0);

	public Chat() {
	}

	public Chat(String nom, String nomJaponais, String description, String personnalite, Integer niveau,
			Integer rare/*, Set<Astuce> astuces*/) {
		this.nom = nom;
		this.nomJaponais = nomJaponais;
		this.description = description;
		this.personnalite = personnalite;
		this.niveau = niveau;
		this.rare = rare;
	//	this.astuces = astuces;
	}


	public Integer getIdChat() {
		return this.idChat;
	}

	public void setIdChat(Integer idChat) {
		this.idChat = idChat;
	}

	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public String getNomJaponais() {
		return this.nomJaponais;
	}

	public void setNomJaponais(String nomJaponais) {
		this.nomJaponais = nomJaponais;
	}

	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public String getPersonnalite() {
		return this.personnalite;
	}

	public void setPersonnalite(String personnalite) {
		this.personnalite = personnalite;
	}

	
	public Integer getNiveau() {
		return this.niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}

	
	public Integer getRare() {
		return this.rare;
	}

	public void setRare(Integer rare) {
		this.rare = rare;
	}

	
//	public Set<Astuce> getAstuces() {
//		return this.astuces;
//	}
//
//	public void setAstuces(Set<Astuce> astuces) {
//		this.astuces = astuces;
//	}
	
	
}

