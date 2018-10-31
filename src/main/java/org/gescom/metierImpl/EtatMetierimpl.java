package org.gescom.metierImpl;

import java.util.List;

import org.gescom.dao.EtatRepository;
import org.gescom.entities.Etat;
import org.gescom.metier.EtatMetier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class EtatMetierimpl implements EtatMetier{
	private EtatRepository etatrepository;
	@Override
	public Etat saveEtat(Etat e) {
		// TODO Auto-generated method stub
		return etatrepository.save(e);
	}

	@Override
	public Etat updateEtat(Long idEtat, Etat e) {
		e.setIdEtat(idEtat);
		return etatrepository.save(e);
	}

	@Override
	public boolean deleteEtat(Long idEtat) {
		if(getEtat(idEtat)!=null) return true;
		else return false;
	}

	@Override
	public Etat getEtat(Long idEtat) {
		// TODO Auto-generated method stub
		return etatrepository.getOne(idEtat);
	}

	@Override
	public List<Etat> getAllEtat() {
		// TODO Auto-generated method stub
		return etatrepository.findAll();
	}

	@Override
	public Page<Etat> getParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
