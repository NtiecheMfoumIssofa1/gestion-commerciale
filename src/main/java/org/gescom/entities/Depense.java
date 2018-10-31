package org.gescom.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Depense implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numeroDepense;
	private String libelleDepnse;
	private String destinataire;
	private LocalDate dateDepanse;
	private double montant;
	private boolean etat;
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private CategorieFournisseur categorieFournisseur;
	public Depense() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Depense(String libelleDepnse, String destinataire, LocalDate dateDepanse,double montant) {
		super();
		this.libelleDepnse = libelleDepnse;
		this.destinataire = destinataire;
		this.dateDepanse = dateDepanse;
		this.montant = montant;
	}
	public Long getNumeroDepense() {
		return numeroDepense;
	}
	public void setNumeroDepense(Long numeroDepense) {
		this.numeroDepense = numeroDepense;
	}
	public String getLibelleDepnse() {
		return libelleDepnse;
	}
	public void setLibelleDepnse(String libelleDepnse) {
		this.libelleDepnse = libelleDepnse;
	}
	public String getDestinataire() {
		return destinataire;
	}
	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}
	public LocalDate getDateDepanse() {
		return dateDepanse;
	}
	public void setDateDepanse(LocalDate dateDepanse) {
		this.dateDepanse = dateDepanse;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public CategorieFournisseur getCategorieFournisseur() {
		return categorieFournisseur;
	}
	public void setCategorieFournisseur(CategorieFournisseur categorieFournisseur) {
		this.categorieFournisseur = categorieFournisseur;
	}
	
	

}
