package org.gescom.metierImpl;

import java.util.List;

import org.gescom.dao.FonctionRepository;
import org.gescom.entities.AppUser;
import org.gescom.entities.Fonction;
import org.gescom.metier.FonctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class FonctionServiceImpl implements FonctionService{
    
	@Autowired
	private FonctionRepository  fonctionRepository;
	@Override
	public Fonction saveFonction(Fonction f) {
		// TODO Auto-generated method stub 
		return fonctionRepository.save(f);
	}

	@Override
	public Fonction updateFonction(Fonction f, Long idFonction) {
		f.setIdFonction(idFonction);
		return fonctionRepository.save(f);
	}

	@Override
	public boolean deleteFonction(Long idFonction) {
		fonctionRepository.deleteFonction(idFonction);
		return true;
	}

	@Override
	public Page<Fonction> chercherParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return fonctionRepository.chercherParMc("%"+mc+"%",new PageRequest(page, size));
	}

	@Override
	public Page<AppUser> getUserParFonction(Long idFonction,int page,int size) {
		// TODO Auto-generated method stub
		return fonctionRepository.getUserParFonction(idFonction, new PageRequest(page, size));
	}

	@Override
	public Fonction getFonction(Long id) {
		// TODO Auto-generated method stub
		return fonctionRepository.getOne(id);
	}

	@Override
	public List<Fonction> getALLFonction() {
		// TODO Auto-generated method stub
		return fonctionRepository.getAllFonction();
	}
	
	
	

}
