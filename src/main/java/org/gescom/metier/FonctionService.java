package org.gescom.metier;

import java.util.List;

import org.gescom.entities.AppUser;
import org.gescom.entities.Fonction;
import org.springframework.data.domain.Page;

public interface FonctionService {
	
	public Fonction saveFonction(Fonction f);
	public Fonction updateFonction(Fonction f,Long idFonction);
	public boolean deleteFonction(Long idFonction);
	public Page<Fonction> chercherParMc(String mc,int page,int size); 
	public Page<AppUser> getUserParFonction(Long idFonction,int page,int size);
	public Fonction getFonction(Long id); 
	public List<Fonction> getALLFonction(); 

}
