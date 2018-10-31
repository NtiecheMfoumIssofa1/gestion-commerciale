package org.gescom.metierImpl;

import java.util.List;

import org.gescom.dao.ClientRepository;
import org.gescom.dao.DevisRepository;
import org.gescom.entities.Client;
import org.gescom.entities.Devis;
import org.gescom.metier.DevisMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class DevisMetierimpl implements DevisMetier{
	@Autowired
	private DevisRepository devisRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Override
	public Devis saveDevis(Devis d, Long idClient) {
		Client c =clientRepository.getOne(idClient);
		d.setClient(c);
		return devisRepository.save(d);
	}

	@Override
	public Devis updateDevis(Long idDevis, Devis d, Long idClient) {
		Client c =clientRepository.getOne(idClient);
		d.setClient(c);
		d.setNumeroDevis(idDevis);
		return devisRepository.save(d);
	}

	@Override
	public boolean deleteDevis(Long idDevis) {
       if(getDevis(idDevis)!=null)return true;
       else return false;
	}

	@Override
	public Devis getDevis(Long idDevis) {
		// TODO Auto-generated method stub
		return devisRepository.getOne(idDevis);
	}

	@Override
	public List<Devis> getAllDevis() {
		// TODO Auto-generated method stub
		return devisRepository.findAll();
	}

	@Override
	public Page<Devis> getAllParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
