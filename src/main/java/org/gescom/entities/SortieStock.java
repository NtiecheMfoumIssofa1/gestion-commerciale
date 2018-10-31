package org.gescom.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("Sortie")
public class SortieStock extends Stock implements Serializable{
	
	private LocalDate dateSortie;

	public SortieStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SortieStock(String designationStock, int quantiteStock, LocalDate dateSortie) {
		super(designationStock, quantiteStock);
		this.dateSortie = dateSortie;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}
	

}
