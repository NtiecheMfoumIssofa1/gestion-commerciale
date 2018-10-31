package org.gescom.web;

import java.util.List;

import org.gescom.dao.CategorieFournisseurRepository;
import org.gescom.dao.FournisseurRepository;
import org.gescom.dao.StatutRepository;
import org.gescom.entities.CategorieFournisseur;
import org.gescom.entities.Fournisseur;
import org.gescom.entities.Statut;
import org.gescom.metier.FourniseurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class FourniseurRestController implements FourniseurMetier{
	@Autowired
	private CategorieFournisseurRepository catRepository;
	@Autowired
	private StatutRepository statusRepository;
	@Autowired
	private FournisseurRepository fsseurRepository;
	@Override
	public Fournisseur saveFournisseur(Fournisseur f, Long idStatut, Long idCategorie) {
		Statut s = statusRepository.getOne(idStatut);
		CategorieFournisseur c=catRepository.getOne(idCategorie);
		
		f.setStatut(s);
		f.setCategorieFournisseur(c);
		return fsseurRepository.save(f);
	}

	@Override
	public Fournisseur updateFournisseur(Long idFournisseur, Fournisseur f, Long idStatut, Long idCategorie) {
		Statut s = statusRepository.getOne(idStatut);
		CategorieFournisseur c=catRepository.getOne(idCategorie);
		
		f.setIdFournisseur(idFournisseur);
		f.setStatut(s);
		f.setCategorieFournisseur(c);
		return fsseurRepository.save(f);
	}

	@Override
	public boolean deleteFournisseur(Long idFournisseur) {
		if(getFournisseur(idFournisseur)!=null)return true;
		else return false;
	}

	@Override
	public Fournisseur getFournisseur(Long idFournisseur) {
		// TODO Auto-generated method stub
		return fsseurRepository.getOne(idFournisseur);
	}

	@Override
	public List<Fournisseur> getAllFournisseur() {
		// TODO Auto-generated method stub
		return fsseurRepository.findAll();
	}

	@Override
	public Page<Fournisseur> getParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
