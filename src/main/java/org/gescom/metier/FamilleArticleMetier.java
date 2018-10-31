package org.gescom.metier;

import java.util.List;

import org.gescom.entities.FamilleArticle;
import org.springframework.data.domain.Page;

public interface FamilleArticleMetier {
	
	public FamilleArticle saveFamille(FamilleArticle f);
	public FamilleArticle updateFamille(Long idFamille,FamilleArticle f);
	public boolean deleteFamilleArticle(Long idFamille);
	public FamilleArticle getFamille(Long idFamille);
	public List<FamilleArticle> getAllFamille();
	public Page<FamilleArticle> getParMc(String mc,int page,int size);

}
