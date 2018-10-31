package org.gescom.metierImpl;

import java.util.List;

import org.gescom.dao.FamilleAricleRepository;
import org.gescom.entities.FamilleArticle;
import org.gescom.metier.FamilleArticleMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class FamilleMetierimpl implements FamilleArticleMetier{

	@Autowired
	private FamilleAricleRepository famillerepository;
	@Override
	public FamilleArticle saveFamille(FamilleArticle f) {
		// TODO Auto-generated method stub
		return famillerepository.save(f);
	}

	@Override
	public FamilleArticle updateFamille(Long idFamille, FamilleArticle f) {
		f.setIdFamille(idFamille);
		return famillerepository.save(f);
	}

	@Override
	public boolean deleteFamilleArticle(Long idFamille) {
		if (getFamille(idFamille)!=null) return true;
		else return false;
	}

	@Override
	public FamilleArticle getFamille(Long idFamille) {
		// TODO Auto-generated method stub
		return famillerepository.getOne(idFamille);
	}

	@Override
	public List<FamilleArticle> getAllFamille() {
		// TODO Auto-generated method stub
		return famillerepository.findAll();
	}

	@Override
	public Page<FamilleArticle> getParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
