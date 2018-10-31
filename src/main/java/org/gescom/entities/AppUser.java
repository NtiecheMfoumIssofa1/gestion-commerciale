package org.gescom.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class AppUser implements Serializable{
	@Id @GeneratedValue
	private Long id;
	@Column(unique=true)//permet de rendre un champ unique dans la bd
	private String username;

	private String password;
	@ManyToMany(fetch=FetchType.EAGER) //EAGER en chargeant les users on charge les roles aussi
	private Collection<AppRole> roles = new ArrayList<>();
	@ManyToOne
	@JoinColumn(name="idFonction")
	private Fonction fonction;
	
	private String 	action = "INACTIF";
	private String photo;
	private String email;
	private String telephone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<AppRole> getRoles() {
		return roles;
	}
	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}
	public Fonction getFonction() {
		return fonction;
	}
	public void setFonction(Fonction fonction) {
		this.fonction = fonction;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public AppUser(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AppUser(Long id, String username, String password, String action) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.action = action;
	}
	

}
