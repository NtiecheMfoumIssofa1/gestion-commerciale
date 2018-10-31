package org.gescom.metierImpl;

import java.util.List;

import org.gescom.dao.CategorieFournisseurRepository;
import org.gescom.entities.CategorieFournisseur;
import org.gescom.metier.CategorieFournisseurMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class CategorieFournisseurMetierimpl implements CategorieFournisseurMetier{
	@Autowired
	private CategorieFournisseurRepository catRepository;
	@Override
	public CategorieFournisseur saveCategorie(CategorieFournisseur c) {
		// TODO Auto-generated method stub
		return catRepository.save(c);
	}

	@Override
	public CategorieFournisseur updateCategorie(Long idCat, CategorieFournisseur c) {
		c.setIdCategorie(idCat);
		return catRepository.save(c);
	}

	@Override
	public List<CategorieFournisseur> getAllCategorie() {
		// TODO Auto-generated method stub
		return catRepository.findAll();
	}

	@Override
	public CategorieFournisseur getCategorie(Long idCategorie) {
		// TODO Auto-generated method stub
		return catRepository.getOne(idCategorie);
	}

	@Override
	public Page<CategorieFournisseur> getParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCategorie(Long idCat) {
		if(getCategorie(idCat)!=null) return true;
		else return false;
	}

}
