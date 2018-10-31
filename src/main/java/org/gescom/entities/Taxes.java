package org.gescom.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Taxes implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idTaxe;
	private double tauxtaxe;
	@OneToMany(mappedBy="taxes")
	private Collection<Article> articles;
	private boolean etat;
	public Taxes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Taxes(double tauxtaxe) {
		super();
		this.tauxtaxe = tauxtaxe;
	}
	public Long getIdTaxe() {
		return idTaxe;
	}
	public void setIdTaxe(Long idTaxe) {
		this.idTaxe = idTaxe;
	}
	public double getTauxtaxe() {
		return tauxtaxe;
	}
	public void setTauxtaxe(double tauxtaxe) {
		this.tauxtaxe = tauxtaxe;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	

}
