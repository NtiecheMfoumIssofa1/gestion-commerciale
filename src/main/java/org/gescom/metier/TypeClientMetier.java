package org.gescom.metier;

import java.util.List;

import org.gescom.entities.TypeClient;
import org.springframework.data.domain.Page;

public interface TypeClientMetier {

	public TypeClient saveTypeClient(TypeClient s);
	public TypeClient updateTypeClient(Long idTypeClient,TypeClient s);
	public boolean deleteTypeClient(Long idTypeClient);
	public TypeClient getTypeClient(Long idTypeClient);
	public List<TypeClient> getAllTypeClient();
	public Page<TypeClient> getParMc(String mc,int page,int size);
}
