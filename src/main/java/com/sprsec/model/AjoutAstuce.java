package com.sprsec.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ajoutastuce")
public class AjoutAstuce implements Serializable{
	
	/**contient la liste des getter et setter 
	 * necessaire pour faire le lien avec la bdd
	 **/
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_ajout")
	private Integer idajout;
	
	@Column(name = "nom_chat", length = 50)
	private String chatnom;
	@Column(name = "nom_user", length = 50)
	private String nameuser;
	@Column(name = "commentaire")
	private String commentaire;
	
	public AjoutAstuce() {
	}

	public AjoutAstuce(String chatnom, String nameuser, String commentaire) {
		super();
		this.chatnom = chatnom;
		this.nameuser = nameuser;
		this.commentaire = commentaire;
	}

	public String getchatnom() {
		return chatnom;
	}

	public void setchatnom(String chatnom) {
		this.chatnom = chatnom;
	}

	public String getnameuser() {
		return nameuser;
	}

	public void setnameuser(String nameuser) {
		this.nameuser = nameuser;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}	
}
