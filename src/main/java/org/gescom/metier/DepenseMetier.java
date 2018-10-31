package org.gescom.metier;

import java.util.List;

import org.gescom.entities.Depense;
import org.springframework.data.domain.Page;

public interface DepenseMetier {
	
	public Depense saveDepense(Depense d, Long idCategorie);
	public Depense updateDepense(Long idDepense,Depense d,Long idCategorie);
	public boolean deleteDepense(Long idDepense);
	public List<Depense> getAllDepense();
	public Depense getDepense(Long idDepense);
	public Page<Depense> getParMc(String mc,int page,int size);

}
