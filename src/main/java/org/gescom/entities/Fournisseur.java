package org.gescom.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Fournisseur implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFournisseur;
	private String nomComplet;
	private String ville;
	private String boitePostale;
	private String adresse;
	private String telephone;
	private String email;
	private boolean etat;
	@OneToMany(mappedBy="fournisseur")
	private Collection<Article> articles;
	@ManyToOne
	@JoinColumn(name="idStatut")
	private Statut statut;
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private CategorieFournisseur categorieFournisseur;
	@OneToMany(mappedBy="fournisseur")
	private Collection<Commande>commandes;
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(Long idFournisseur, String nomComplet, String ville, String boitePostale, String adresse,
			String telephone, String email) {
		super();
		this.idFournisseur = idFournisseur;
		this.nomComplet = nomComplet;
		this.ville = ville;
		this.boitePostale = boitePostale;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}
	public Long getIdFournisseur() {
		return idFournisseur;
	}
	public void setIdFournisseur(Long idFournisseur) {
		this.idFournisseur = idFournisseur;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getBoitePostale() {
		return boitePostale;
	}
	public void setBoitePostale(String boitePostale) {
		this.boitePostale = boitePostale;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Collection<Article> getArticles() {
		return articles;
	}
	public void setArticles(Collection<Article> articles) {
		this.articles = articles;
	}
	public Statut getStatut() {
		return statut;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	public CategorieFournisseur getCategorieFournisseur() {
		return categorieFournisseur;
	}
	public void setCategorieFournisseur(CategorieFournisseur categorieFournisseur) {
		this.categorieFournisseur = categorieFournisseur;
	}
	public Collection<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
	

}
