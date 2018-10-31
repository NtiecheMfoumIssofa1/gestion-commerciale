package org.gescom.web;

import java.util.List;

import org.gescom.dao.StatutRepository;
import org.gescom.entities.Statut;
import org.gescom.metier.StatutMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class StatutRestController implements StatutMetier{
	@Autowired
 private StatutRepository statutRepository;
	@Override
	public Statut saveStatut(Statut s) {
		// TODO Auto-generated method stub
		return statutRepository.save(s);
	}

	@Override
	public Statut updateStatut(Long idStatut, Statut s) {
		s.setIdStatut(idStatut);
		return statutRepository.save(s);
	}

	@Override
	public boolean deleteStatut(Long idStatut) {
		if(getStatut(idStatut)!=null) return true;
		else return false;
	}

	@Override
	public Statut getStatut(Long idStatut) {
		// TODO Auto-generated method stub
		return statutRepository.getOne(idStatut);
	}

	@Override
	public List<Statut> getAllStatut() {
		// TODO Auto-generated method stub
		return statutRepository.findAll();
	}

	@Override
	public Page<Statut> getParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
