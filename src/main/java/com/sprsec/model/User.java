package com.sprsec.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable{
	/**contient la liste des getter et setter 
	 * necessaire pour faire le lien avec la bdd
	 **/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="login", unique=true)
	private String login;
	
	@Column(name="password")
	private String password;
        
        @Column(name="adresse_mail", unique=true)
	private String adresse_mail;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="user_roles",
			joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
			inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")})
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
        
        public String getadresse_mail() {
		return adresse_mail;
	}

	public void setadresse_mail(String adresse_mail) {
		this.adresse_mail = adresse_mail;
	}	
}
