package org.gescom.metier;

import java.util.List;

import org.gescom.entities.Taxes;
import org.springframework.data.domain.Page;

public interface TaxeMetier {
	public Taxes saveTaxes(Taxes s);
	public Taxes updateTaxes(Long idTaxes,Taxes s);
	public boolean deleteTaxes(Long idStatut);
	public Taxes getTaxes(Long idTaxes);
	public List<Taxes> getAllTaxes();
	public Page<Taxes> getParMc(String mc,int page,int size);

}
