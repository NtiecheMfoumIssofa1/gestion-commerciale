package org.gescom.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
public class Facture implements Serializable{
	@Id
	private String idFacture;
	private LocalDate dateDebutFacture;
	private LocalDate dateEcheanceFacture;
	private double montantTTC;
	private boolean etat;
	@ManyToMany(mappedBy="factures")
	private Collection<Etat> etatFacture;
	@OneToMany(mappedBy="facture")
	private Collection<Vente>ventes;
	@ManyToMany(mappedBy="factures")
	private Collection<ModeReglement> modeReglements;
	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facture(String idFacture, LocalDate dateDebutFacture, LocalDate dateEcheanceFacture, double montantTTC) {
		super();
		this.idFacture = idFacture;
		this.dateDebutFacture = dateDebutFacture;
		this.dateEcheanceFacture = dateEcheanceFacture;
		this.montantTTC = montantTTC;
	}
	public String getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(String idFacture) {
		this.idFacture = idFacture;
	}
	public LocalDate getDateDebutFacture() {
		return dateDebutFacture;
	}
	public void setDateDebutFacture(LocalDate dateDebutFacture) {
		this.dateDebutFacture = dateDebutFacture;
	}
	public LocalDate getDateEcheanceFacture() {
		return dateEcheanceFacture;
	}
	public void setDateEcheanceFacture(LocalDate dateEcheanceFacture) {
		this.dateEcheanceFacture = dateEcheanceFacture;
	}
	public double getMontantTTC() {
		return montantTTC;
	}
	public void setMontantTTC(double montantTTC) {
		this.montantTTC = montantTTC;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public Collection<Etat> getEtatFacture() {
		return etatFacture;
	}
	public void setEtatFacture(Collection<Etat> etatFacture) {
		this.etatFacture = etatFacture;
	}
	public Collection<Vente> getVentes() {
		return ventes;
	}
	public void setVentes(Collection<Vente> ventes) {
		this.ventes = ventes;
	}
	public Collection<ModeReglement> getModeReglements() {
		return modeReglements;
	}
	public void setModeReglements(Collection<ModeReglement> modeReglements) {
		this.modeReglements = modeReglements;
	}
	
	
	

}
