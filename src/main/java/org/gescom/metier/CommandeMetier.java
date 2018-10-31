package org.gescom.metier;

import java.util.List;

import org.gescom.entities.Commande;
import org.springframework.data.domain.Page;

public interface CommandeMetier {
	
	public Commande saveCommande(Commande c,Long idFournisseur);
	public Commande updateCommande(Long idCde,Commande c, Long idFournisseur);
	public boolean deleteCommande (Long idCde);
	public List<Commande> getAllCommande();
	public Commande getCommande(Long idCde);
	public Page<Commande> getParMc(String mc,int page,int size);

}
