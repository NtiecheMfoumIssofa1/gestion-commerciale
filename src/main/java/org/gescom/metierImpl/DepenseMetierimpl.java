package org.gescom.metierImpl;

import java.util.List;

import org.gescom.dao.CategorieFournisseurRepository;
import org.gescom.dao.DepenseRepository;
import org.gescom.entities.CategorieFournisseur;
import org.gescom.entities.Depense;
import org.gescom.metier.DepenseMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class DepenseMetierimpl implements DepenseMetier{
	@Autowired
	private DepenseRepository depenseRepository;
	@Autowired
	private CategorieFournisseurRepository categorieRepository;
	@Override
	public Depense saveDepense(Depense d, Long idCategorie) {
		CategorieFournisseur c= categorieRepository.getOne(idCategorie);
		d.setCategorieFournisseur(c);
		return depenseRepository.save(d);
	}

	@Override
	public Depense updateDepense(Long idDepense, Depense d, Long idCategorie) {
		CategorieFournisseur c= categorieRepository.getOne(idCategorie);
		d.setCategorieFournisseur(c);
		d.setNumeroDepense(idDepense);
		return depenseRepository.save(d);
	}

	@Override
	public boolean deleteDepense(Long idDepense) {
		if(getDepense(idDepense)!=null) return true;
		else return false;
	}

	@Override
	public List<Depense> getAllDepense() {
		// TODO Auto-generated method stub
		return depenseRepository.findAll();
	}

	@Override
	public Depense getDepense(Long idDepense) {
		// TODO Auto-generated method stub
		return depenseRepository.getOne(idDepense);
	}

	@Override
	public Page<Depense> getParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
