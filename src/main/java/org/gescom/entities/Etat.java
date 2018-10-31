package org.gescom.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class Etat implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idEtat;
	private String libelleEtat;
	private boolean etat;
	@ManyToMany
	@JoinTable(name="Etat_Commande",joinColumns=
	@JoinColumn(name="idEtat"),inverseJoinColumns=
	@JoinColumn(name="numCommande"))
	private Collection<Commande>commandes;
	@ManyToMany
	@JoinTable(name="Etat_Facture",joinColumns=
	@JoinColumn(name="idEtat"),inverseJoinColumns=
	@JoinColumn(name="idFacture"))
	private Collection<Facture>factures; 
	public Etat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Etat(String libelleEtat) {
		super();
		this.libelleEtat = libelleEtat;
	}
	public Long getIdEtat() {
		return idEtat;
	}
	public void setIdEtat(Long idEtat) {
		this.idEtat = idEtat;
	}
	public String getLibelleEtat() {
		return libelleEtat;
	}
	public void setLibelleEtat(String libelleEtat) {
		this.libelleEtat = libelleEtat;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Collection<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	public Collection<Facture> getFactures() {
		return factures;
	}
	public void setFactures(Collection<Facture> factures) {
		this.factures = factures;
	}
	
	

}
