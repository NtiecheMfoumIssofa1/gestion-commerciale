package org.gescom.metier;

import java.util.List;

import org.gescom.entities.Etat;
import org.springframework.data.domain.Page;

public interface EtatMetier {
	
	public Etat saveEtat (Etat e);
	public Etat updateEtat(Long idEtat,Etat e);
	public boolean deleteEtat(Long idEtat);
	public Etat getEtat(Long idEtat);
	public List<Etat> getAllEtat();
	public Page<Etat> getParMc(String mc,int page,int size);

}
