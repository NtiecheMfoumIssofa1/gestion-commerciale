package org.gescom.web;

import java.util.List;

import org.gescom.dao.ModeReglementRepository;
import org.gescom.entities.ModeReglement;
import org.gescom.metier.ModeReglementMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class ModeReglementRestController implements ModeReglementMetier{
	@Autowired
	private ModeReglementRepository modeRepository;
	@Override
	public ModeReglement saveMode(ModeReglement m) {
		// TODO Auto-generated method stub
		return modeRepository.save(m);
	}

	@Override
	public ModeReglement updateMode(String id, ModeReglement m) {
		m.setLibelleReglement(id);
		return null;
	}

	@Override
	public boolean deleteMode(String id) {
		if(getMode(id)!=null) return true;
		else return false;
	}

	@Override
	public ModeReglement getMode(String idMode) {
		// TODO Auto-generated method stub
		return modeRepository.getOne(idMode);
	}

	@Override
	public List<ModeReglement> getAll() {
		// TODO Auto-generated method stub
		return modeRepository.findAll();
	}

	@Override
	public Page<ModeReglement> getParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
