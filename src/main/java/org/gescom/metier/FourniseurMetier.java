package org.gescom.metier;

import java.util.List;

import org.gescom.entities.Fournisseur;
import org.springframework.data.domain.Page;

public interface FourniseurMetier {
	
	public Fournisseur saveFournisseur(Fournisseur f, Long idStatut,Long idCategorie);
	public Fournisseur updateFournisseur(Long idFournisseur,Fournisseur f, Long idStatut,Long idCategorie);
	public boolean deleteFournisseur(Long idFournisseur);
	public Fournisseur getFournisseur(Long idFournisseur);
	public List<Fournisseur> getAllFournisseur();
	public Page<Fournisseur> getParMc(String mc,int page,int size);
}
