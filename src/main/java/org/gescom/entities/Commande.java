package org.gescom.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Commande implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numCommande;
	private String libelleCommande;
	private LocalDate date;
	private boolean etat;
	@ManyToOne
	@JoinColumn(name="idFournisseur")
	private Fournisseur fournisseur;
	@ManyToMany(mappedBy="commandes")
	private Collection<Etat> etatCommandes;
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Commande(Long numCommande,String libelleCommande, LocalDate date) {
		super();
		this.numCommande = numCommande;
		this.date = date;
		this.libelleCommande = libelleCommande;
	}
	public Long getNumCommande() {
		return numCommande;
	}
	public void setNumCommande(Long numCommande) {
		this.numCommande = numCommande;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getLibelleCommande() {
		return libelleCommande;
	}
	public void setLibelleCommande(String libelleCommande) {
		this.libelleCommande = libelleCommande;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	public Collection<Etat> getEtatCommandes() {
		return etatCommandes;
	}
	public void setEtatCommandes(Collection<Etat> etatCommandes) {
		this.etatCommandes = etatCommandes;
	}
	

}
