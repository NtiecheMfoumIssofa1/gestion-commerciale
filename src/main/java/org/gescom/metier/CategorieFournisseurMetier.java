package org.gescom.metier;

import java.util.List;

import org.gescom.entities.CategorieFournisseur;
import org.springframework.data.domain.Page;

public interface CategorieFournisseurMetier {
	
	public CategorieFournisseur saveCategorie(CategorieFournisseur categorieFournisseur);
	public CategorieFournisseur updateCategorie(Long idCat, CategorieFournisseur categorieFournisseur);
	public List<CategorieFournisseur> getAllCategorie();
	public CategorieFournisseur getCategorie(Long idCategorie);
	public Page<CategorieFournisseur> getParMc(String mc,int page,int size);
	public boolean deleteCategorie(Long idCat);
	

}
