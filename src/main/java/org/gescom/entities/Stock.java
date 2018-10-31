package org.gescom.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.SignStyle;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="Mouvement",discriminatorType=DiscriminatorType.STRING,length=7)
public abstract class Stock implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long refStock;
	private String designationStock;
	private int quantiteStock;
	@OneToMany(mappedBy="stock")
	private Collection<Article> articles;
	private boolean etat;
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stock(String designationStock, int quantiteStock) {
		super();
		this.designationStock = designationStock;
		this.quantiteStock = quantiteStock;
	}
	public Long getRefStock() {
		return refStock;
	}
	public void setRefStock(Long refStock) {
		this.refStock = refStock;
	}
	public String getDesignationStock() {
		return designationStock;
	}
	public void setDesignationStock(String designationStock) {
		this.designationStock = designationStock;
	}
	public int getQuantiteStock() {
		return quantiteStock;
	}
	public void setQuantiteStock(int quantiteStock) {
		this.quantiteStock = quantiteStock;
	}
	

}
