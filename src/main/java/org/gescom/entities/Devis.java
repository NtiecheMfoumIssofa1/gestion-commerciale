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
public class Devis implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numeroDevis;
	private LocalDate dateDebutDebit;
	private LocalDate dateEcheanceDevis;
	private int nombre;
	private boolean etat;
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client;
	private double montantTTC;
	public Devis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Devis(Long numeroDevis, LocalDate dateDebutDebit, LocalDate dateEcheanceDevis, int nombre,
			double montantTTC) {
		super();
		this.numeroDevis = numeroDevis;
		this.dateDebutDebit = dateDebutDebit;
		this.dateEcheanceDevis = dateEcheanceDevis;
		this.nombre = nombre;
		this.montantTTC = montantTTC;
	}
	public Long getNumeroDevis() {
		return numeroDevis;
	}
	public void setNumeroDevis(Long numeroDevis) {
		this.numeroDevis = numeroDevis;
	}
	public LocalDate getDateDebutDebit() {
		return dateDebutDebit;
	}
	public void setDateDebutDebit(LocalDate dateDebutDebit) {
		this.dateDebutDebit = dateDebutDebit;
	}
	public LocalDate getDateEcheanceDevis() {
		return dateEcheanceDevis;
	}
	public void setDateEcheanceDevis(LocalDate dateEcheanceDevis) {
		this.dateEcheanceDevis = dateEcheanceDevis;
	}
	public int getNombre() {
		return nombre;
	}
	public void setNombre(int nombre) {
		this.nombre = nombre;
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
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	

}
