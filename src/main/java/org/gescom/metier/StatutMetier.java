package org.gescom.metier;

import java.util.List;

import org.gescom.entities.Statut;
import org.springframework.data.domain.Page;

public interface StatutMetier {
	
	public Statut saveStatut(Statut s);
	public Statut updateStatut(Long idStatut,Statut s);
	public boolean deleteStatut(Long idStatut);
	public Statut getStatut(Long idStatut);
	public List<Statut> getAllStatut();
	public Page<Statut> getParMc(String mc,int page,int size);

}
