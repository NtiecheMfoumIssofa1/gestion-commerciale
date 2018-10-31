package org.gescom.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class CategorieFournisseur implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCategorie;
	private String libelleCategorie;
	private boolean etat;
	@OneToMany(mappedBy="categorieFournisseur")
	private Collection<Fournisseur> fournisseurs;
	@OneToMany(mappedBy="categorieFournisseur")
	private Collection<Depense> depenses;
	public CategorieFournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategorieFournisseur(String libelleCategorie) {
		super();
		this.libelleCategorie = libelleCategorie;
	}
	public Long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getLibelleCategorie() {
		return libelleCategorie;
	}
	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
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
