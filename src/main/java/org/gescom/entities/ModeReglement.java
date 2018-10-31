package org.gescom.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
@Entity
public class ModeReglement implements Serializable{
	@Id
	private String libelleReglement;
	private boolean etat;
	@ManyToMany
	@JoinTable(name="Reglement_Facture",joinColumns=
	@JoinColumn(name="libelleReglement"),inverseJoinColumns=
	@JoinColumn(name="idFacture"))
	private Collection<Facture>factures;
	public ModeReglement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModeReglement(String libelleReglement) {
		super();
		this.libelleReglement = libelleReglement;
	}
	
	public String getLibelleReglement() {
		return libelleReglement;
	}
	public void setLibelleReglement(String libelleReglement) {
		this.libelleReglement = libelleReglement;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Collection<Facture> getFactures() {
		return factures;
	}
	public void setFactures(Collection<Facture> factures) {
		this.factures = factures;
	}
	
	

}
