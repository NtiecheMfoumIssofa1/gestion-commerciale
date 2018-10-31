package org.gescom.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vente implements Serializable {
	@Id
	private String numVente;
	private LocalDate dateVente;
	private int nombreArctivle;
	private boolean etat;
	@ManyToMany
	@JoinTable(name="Vente_Article",joinColumns=
	@JoinColumn(name="numVente"), inverseJoinColumns=
	@JoinColumn(name="refArticle"))
	private Collection<Article> articles;
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	@ManyToOne
	@JoinColumn(name="idFacture")
	private Facture facture;
	public Vente() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vente(String numVente, LocalDate dateVente, int nombreArctivle) {
		super();
		this.numVente = numVente;
		this.dateVente = dateVente;
		this.nombreArctivle = nombreArctivle;
	}
	public String getNumVente() {
		return numVente;
	}
	public void setNumVente(String numVente) {
		this.numVente = numVente;
	}
	public LocalDate getDateVente() {
		return dateVente;
	}
	public void setDateVente(LocalDate dateVente) {
		this.dateVente = dateVente;
	}
	public int getNombreArctivle() {
		return nombreArctivle;
	}
	public void setNombreArctivle(int nombreArctivle) {
		this.nombreArctivle = nombreArctivle;
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	

}
