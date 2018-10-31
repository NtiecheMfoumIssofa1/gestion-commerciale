package org.gescom.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class TypeClient implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idType;
	private String libelleType;
	@OneToMany(mappedBy="typeClient")
	private Collection<Client> clients;
	private boolean etat;
	public TypeClient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TypeClient(String libelleType, boolean etat) {
		super();
		this.libelleType = libelleType;
		this.etat = etat;
	}
	public Long getIdType() {
		return idType;
	}
	public void setIdType(Long idType) {
		this.idType = idType;
	}
	public String getLibelleType() {
		return libelleType;
	}
	public void setLibelleType(String libelleType) {
		this.libelleType = libelleType;
	}
	public Collection<Client> getClients() {
		return clients;
	}
	public void setClients(Collection<Client> clients) {
		this.clients = clients;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	
	

}
