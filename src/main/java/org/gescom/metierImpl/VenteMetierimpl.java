package org.gescom.metierImpl;

import java.util.List;

import org.gescom.dao.ClientRepository;
import org.gescom.dao.FactureRepository;
import org.gescom.dao.VenteRepository;
import org.gescom.entities.Client;
import org.gescom.entities.Facture;
import org.gescom.entities.Vente;
import org.gescom.metier.VenteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class VenteMetierimpl implements VenteMetier{
	@Autowired
	private VenteRepository venteRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private FactureRepository factureRepository;
	@Override
	public Vente saveVente(Vente v, Long idClient, String idFacture) {
		Client c =clientRepository.getOne(idClient);
		Facture f =factureRepository.getOne(idFacture);
		
		v.setClient(c);
		v.setFacture(f);
		return venteRepository.save(v);
	}

	@Override
	public Vente updateVente(String idVente, Vente v, Long idClient, String idFacture) {
		Client c =clientRepository.getOne(idClient);
		Facture f =factureRepository.getOne(idFacture);
		
		v.setNumVente(idVente);
		v.setClient(c);
		v.setFacture(f);
		return venteRepository.save(v);
	}

	@Override
	public List<Vente> getAllVente() {
		// TODO Auto-generated method stub
		return venteRepository.findAll();
	}

	@Override
	public Vente getVente(String idVente) {
		// TODO Auto-generated method stub
		return venteRepository.getOne(idVente);
	}

	@Override
	public Page<Vente> getVenteParMc(String mc, int page, int size) {
		
		return null;
	}

	@Override
	public boolean deleteVente(String idVente) {
		if(getVente(idVente)!=null) return true;
		else return false;
	}

}
