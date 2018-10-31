package org.gescom.web;

import java.util.List;

import org.gescom.dao.TaxeRepository;
import org.gescom.entities.Taxes;
import org.gescom.metier.TaxeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class TaxeRestController implements TaxeMetier{
	@Autowired
	private TaxeRepository taxeRepository;
	@Override
	public Taxes saveTaxes(Taxes s) {
		// TODO Auto-generated method stub
		return taxeRepository.save(s);
	}

	@Override
	public Taxes updateTaxes(Long idTaxes, Taxes s) {
		s.setIdTaxe(idTaxes);
		return taxeRepository.save(s);
	}

	@Override
	public boolean deleteTaxes(Long id) {
		if(getTaxes(id)!=null) return true;
		else return false;
	}

	@Override
	public Taxes getTaxes(Long idTaxes) {
		// TODO Auto-generated method stub
		return taxeRepository.getOne(idTaxes);
	}

	@Override
	public List<Taxes> getAllTaxes() {
		// TODO Auto-generated method stub
		return taxeRepository.findAll();
	}

	@Override
	public Page<Taxes> getParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
