package org.gescom.metierImpl;

import java.util.List;

import org.gescom.dao.FactureRepository;
import org.gescom.entities.Facture;
import org.gescom.metier.FactureMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class FactureMetierimpl implements FactureMetier{
	@Autowired
	private FactureRepository factureRepository;
	@Override
	public Facture saveFacture(Facture f) {
		// TODO Auto-generated method stub
		return factureRepository.save(f);
	}

	public Facture updateFacture(String idFacture, Facture f) {
		f.setIdFacture(idFacture);
		return factureRepository.save(f);
	}

	@Override
	public boolean deleteFacture(String idFacture) {
		if(getFacture(idFacture)!=null) return true;
		else return false;
	}

	@Override
	public Facture getFacture(String idFacture) {
		// TODO Auto-generated method stub
		return factureRepository.getOne(idFacture);
	}

	@Override
	public List<Facture> getAllFacture() {
		// TODO Auto-generated method stub
		return factureRepository.findAll();
	}

	@Override
	public Page<Facture> getParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
