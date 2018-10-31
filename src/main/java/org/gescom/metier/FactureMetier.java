package org.gescom.metier;

import java.util.List;

import org.gescom.entities.Facture;
import org.springframework.data.domain.Page;

public interface FactureMetier {
	public Facture saveFacture(Facture f);
	public Facture updateFacture(String idFacture,Facture f);
	public boolean deleteFacture(String idFacture);
	public Facture getFacture(String idFacture);
	public List<Facture> getAllFacture();
	public Page<Facture> getParMc(String mc,int page,int size);

}
