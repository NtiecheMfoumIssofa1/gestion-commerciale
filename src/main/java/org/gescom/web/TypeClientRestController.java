package org.gescom.web;

import java.util.List;

import org.gescom.dao.TypeClientRepository;
import org.gescom.entities.TypeClient;
import org.gescom.metier.TypeClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
@Service
public class TypeClientRestController implements TypeClientMetier{
	@Autowired
	private TypeClientRepository typeRepository;
	@Override
	public TypeClient saveTypeClient(TypeClient s) {
		// TODO Auto-generated method stub
		return typeRepository.save(s);
	}

	@Override
	public TypeClient updateTypeClient(Long id, TypeClient s) {
		s.setIdType(id);
		return typeRepository.save(s);
	}

	@Override
	public boolean deleteTypeClient(Long idTypeClient) {
		if(getTypeClient(idTypeClient)!=null) return true;
		else return false;
	}

	@Override
	public TypeClient getTypeClient(Long idTypeClient) {
		// TODO Auto-generated method stub
		return typeRepository.getOne(idTypeClient);
	}

	@Override
	public List<TypeClient> getAllTypeClient() {
		// TODO Auto-generated method stub
		return typeRepository.findAll();
	}

	@Override
	public Page<TypeClient> getParMc(String mc, int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
