package org.gescom.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Fonction {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFonction;
	private String libelleFonction;
	@OneToMany(mappedBy="fonction")
	private Collection<AppUser> appUsers;
	
	private String action ="DESACTIVEE";
	
	public Fonction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fonction(String libelleFonction) {
		super();
		this.libelleFonction = libelleFonction;
	}

	public Long getIdFonction() {
		return idFonction;
	}

	public void setIdFonction(Long idFonction) {
		this.idFonction = idFonction;
	}

	public String getLibelleFonction() {
		return libelleFonction;
	}

	public void setLibelleFonction(String libelleFonction) {
		this.libelleFonction = libelleFonction;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Fonction(String libelleFonction, String action) {
		super();
		this.libelleFonction = libelleFonction;
		this.action = action;
	}

	public Collection<AppUser> getAppUsers() {
		return appUsers;
	}

	public void setAppUsers(Collection<AppUser> appUsers) {
		this.appUsers = appUsers;
	}
	
	

}
