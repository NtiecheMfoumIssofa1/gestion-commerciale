package org.gescom.metierImpl;

import java.util.List;

import org.gescom.dao.ClientRepository;
import org.gescom.dao.TypeClientRepository;
import org.gescom.entities.Client;
import org.gescom.entities.TypeClient;
import org.gescom.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class ClientMetierimpl implements ClientMetier{
	@Autowired
	private TypeClientRepository typeRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Override
	public Client saveClient(Client c, Long idType) {
	TypeClient t=	typeRepository.getOne(idType);
	c.setTypeClient(t);
		return clientRepository.save(c);
	}

	@Override
	public Client updateClient(Long idClient, Client c, Long idtype) {
		TypeClient t=	typeRepository.getOne(idtype);
		c.setIdClient(idClient);
			c.setTypeClient(t);
			return clientRepository.save(c);
		}
	@Override
	public boolean deleteClient(Long idClient) {
		if (getClient(idClient)!=null) return true;
		else return false;
	}

	@Override
	public List<Client> getAllClient() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Client getClient(Long idClient) {
		// TODO Auto-generated method stub
		return clientRepository.getOne(idClient);
	}

	@Override
	public Page<Client> getParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
