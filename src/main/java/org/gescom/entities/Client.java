package org.gescom.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Client implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient;
	private String nomComplet;
	private String adrress;
	private String ville;
	private String boitePostale;
	private String telephone;
	private String email;
	private boolean etat;
	@ManyToOne
	@JoinColumn(name="idType")
	private TypeClient typeClient;
	@OneToMany(mappedBy="client")
	private Collection<Vente> ventes;
	@OneToMany(mappedBy="client")
	private Collection<Devis> devis;
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String nomComplet, String adrress, String ville, String boitePostale, String telephone,
			String email) {
		super();
		this.nomComplet = nomComplet;
		this.adrress = adrress;
		this.ville = ville;
		this.boitePostale = boitePostale;
		this.telephone = telephone;
		this.email = email;
	}
	public Long getIdClient() {
		return idClient;
	}
	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}
	public String getNomComplet() {
		return nomComplet;
	}
	public void setNomComplet(String nomComplet) {
		this.nomComplet = nomComplet;
	}
	public String getAdrress() {
		return adrress;
	}
	public void setAdrress(String adrress) {
		this.adrress = adrress;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getBoitePostale() {
		return boitePostale;
	}
	public void setBoitePostale(String boitePostale) {
		this.boitePostale = boitePostale;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public TypeClient getTypeClient() {
		return typeClient;
	}
	public void setTypeClient(TypeClient typeClient) {
		this.typeClient = typeClient;
	}
	public Collection<Vente> getVentes() {
		return ventes;
	}
	public void setVentes(Collection<Vente> ventes) {
		this.ventes = ventes;
	}
	public Collection<Devis> getDevis() {
		return devis;
	}
	public void setDevis(Collection<Devis> devis) {
		this.devis = devis;
	}
	

}
