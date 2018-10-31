package org.gescom.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Statut implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStatut;
	private String libelleStatut;
	private boolean etat;
	@OneToMany(mappedBy="statut")
	private Collection<Fournisseur> fournisseurs;
	public Statut() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Statut(String libelleStatut) {
		super();
		this.libelleStatut = libelleStatut;
	}
	public Long getIdStatut() {
		return idStatut;
	}
	public void setIdStatut(Long idStatut) {
		this.idStatut = idStatut;
	}
	public String getLibelleStatut() {
		return libelleStatut;
	}
	public void setLibelleStatut(String libelleStatut) {
		this.libelleStatut = libelleStatut;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Collection<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(Collection<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}
	
	

}
