package org.gescom.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class FamilleArticle implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFamille;
	private String libelleFamille;
	private boolean etat;  
	@OneToMany(mappedBy="familleArticle")
	private Collection<Article> articles;
	public FamilleArticle() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FamilleArticle(String libelleFamille) {
		super();
		this.libelleFamille = libelleFamille;
	}
	public Long getIdFamille() {
		return idFamille;
	}
	public void setIdFamille(Long idFamille) {
		this.idFamille = idFamille;
	}
	public String getLibelleFamille() {
		return libelleFamille;
	}
	public void setLibelleFamille(String libelleFamille) {
		this.libelleFamille = libelleFamille;
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
	
	
	

}
