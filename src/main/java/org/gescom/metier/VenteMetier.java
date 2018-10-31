package org.gescom.metier;

import java.util.List;

import org.gescom.entities.Vente;
import org.springframework.data.domain.Page;

public interface VenteMetier {
	
	public Vente saveVente(Vente v, Long idClient,String idFacture);
	public Vente updateVente(String idVente,Vente a, Long idClient,String idFacture);
	public List<Vente> getAllVente();
	public Vente getVente(String idVente);
	public Page<Vente> getVenteParMc(String mc, int page,int size);
	public boolean deleteVente(String idVente);

}
