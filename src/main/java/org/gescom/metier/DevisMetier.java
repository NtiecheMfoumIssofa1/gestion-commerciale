package org.gescom.metier;

import java.util.List;

import org.gescom.entities.Devis;
import org.springframework.data.domain.Page;

public interface DevisMetier {
	
	public Devis saveDevis (Devis d, Long idClient);
	public Devis updateDevis(Long idDevis,Devis d, Long idClient);
	public boolean deleteDevis(Long idDevis);
	public Devis getDevis(Long idDevis);
	public List<Devis> getAllDevis();
	public Page<Devis> getAllParMc(String mc,int page,int size);

}
