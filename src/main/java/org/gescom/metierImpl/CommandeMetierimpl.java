package org.gescom.metierImpl;

import java.util.List;

import org.gescom.dao.CommandeRepository;
import org.gescom.dao.FournisseurRepository;
import org.gescom.entities.Commande;
import org.gescom.entities.Fournisseur;
import org.gescom.metier.CommandeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class CommandeMetierimpl implements CommandeMetier{
		@Autowired
		private CommandeRepository cmdRepository;
		@Autowired
		private FournisseurRepository fsseurRepository;
	@Override
	public Commande saveCommande(Commande c, Long idFournisseur) {
		Fournisseur f=fsseurRepository.getOne(idFournisseur);
		c.setFournisseur(f);
		return cmdRepository.save(c);
	}

	@Override
	public Commande updateCommande(Long idCde, Commande c, Long idFournisseur) {
		Fournisseur f=fsseurRepository.getOne(idFournisseur);
		c.setNumCommande(idCde);
		c.setFournisseur(f);
		return cmdRepository.save(c);
	}

	@Override
	public boolean deleteCommande(Long idCde) {
		if (getCommande(idCde)!=null) return true;
		else	return false;
	}

	@Override
	public List<Commande> getAllCommande() {
		// TODO Auto-generated method stub
		return cmdRepository.findAll();
	}

	@Override
	public Commande getCommande(Long idCde) {
		// TODO Auto-generated method stub
		return cmdRepository.getOne(idCde);
	}

	@Override
	public Page<Commande> getParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
