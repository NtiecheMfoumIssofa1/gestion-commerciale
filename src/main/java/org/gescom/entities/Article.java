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
public class Article implements Serializable{
	@Id 
	private String refArticle;
	private String designation;
	private double prixUnitaire;
	private double tva;
	private int quantiteArticle;
	private  int quantiteSeuil;
	private LocalDate dateLivraison;
	@ManyToOne
	@JoinColumn(name="idFamille")
	private FamilleArticle familleArticle;
	@ManyToOne
	@JoinColumn(name="idTaxe")
	private Taxes taxes;
	private boolean etat;
	@ManyToOne
	@JoinColumn(name="idFournisseur")
	private Fournisseur fournisseur;
	@ManyToOne
	@JoinColumn(name="refStock")
	private Stock stock;
	private LocalDate dateMiseAjour;
	@ManyToMany(mappedBy="articles")
	private Collection<Vente> ventes; 

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(String refArticle, String designation, double prixUnitaire, double tva, int quantiteArticle,
			int quantiteSeuil, LocalDate dateLivraison) {
		super();
		this.refArticle = refArticle;
		this.designation = designation;
		this.prixUnitaire = prixUnitaire;
		this.tva = tva;
		this.quantiteArticle = quantiteArticle;
		this.quantiteSeuil = quantiteSeuil;
		this.dateLivraison = dateLivraison;
	}
	public String getRefArticle() {
		return refArticle;
	}
	public void setRefArticle(String refArticle) {
		this.refArticle = refArticle;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrixUnitaire() {
		return prixUnitaire;
	}
	public void setPrixUnitaire(double prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	public double getTva() {
		return tva;
	}
	public void setTva(double tva) {
		this.tva = tva;
	}
	public int getQuantiteArticle() {
		return quantiteArticle;
	}
	public void setQuantiteArticle(int quantiteArticle) {
		this.quantiteArticle = quantiteArticle;
	}
	public int getQuantiteSeuil() {
		return quantiteSeuil;
	}
	public void setQuantiteSeuil(int quantiteSeuil) {
		this.quantiteSeuil = quantiteSeuil;
	}
	public LocalDate getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(LocalDate dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	public FamilleArticle getFamilleArticle() {
		return familleArticle;
	}
	public void setFamilleArticle(FamilleArticle familleArticle) {
		this.familleArticle = familleArticle;
	}
	public Taxes getTaxes() {
		return taxes;
	}
	public void setTaxes(Taxes taxes) {
		this.taxes = taxes;
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
	public LocalDate getDateMiseAjour() {
		return dateMiseAjour;
	}
	public void setDateMiseAjour(LocalDate dateMiseAjour) {
		this.dateMiseAjour = dateMiseAjour;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Collection<Vente> getVentes() {
		return ventes;
	}
	public void setVentes(Collection<Vente> ventes) {
		this.ventes = ventes;
	}

}
