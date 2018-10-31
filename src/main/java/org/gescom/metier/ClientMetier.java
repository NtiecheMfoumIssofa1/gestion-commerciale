package org.gescom.metier;

import java.util.List;

import org.gescom.entities.Client;
import org.springframework.data.domain.Page;

public interface ClientMetier {
	
	public Client saveClient(Client c, Long idType);
	public Client updateClient(Long idClient,Client c, Long idtype);
	public boolean deleteClient(Long idClient);
	public List<Client> getAllClient();
	public Client getClient(Long idClient);
	public Page<Client> getParMc(String mc,int page,int size);

}
