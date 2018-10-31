package org.gescom.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("Entree")
public class EntrerStock extends Stock implements Serializable{
	
	private LocalDate dateEntree;

	public EntrerStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntrerStock(String designationStock, int quantiteStock, LocalDate dateEntree) {
		super(designationStock, quantiteStock);
		this.dateEntree = dateEntree;
	}

	public LocalDate getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(LocalDate dateEntree) {
		this.dateEntree = dateEntree;
	}
	
	

}
