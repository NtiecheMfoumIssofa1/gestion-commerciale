package org.gescom.metier;

import java.util.List;

import org.gescom.entities.ModeReglement;
import org.springframework.data.domain.Page;

public interface ModeReglementMetier {
	public ModeReglement saveMode(ModeReglement m);
	public ModeReglement updateMode(String id, ModeReglement m);
	public boolean deleteMode(String id);
	public ModeReglement getMode(String idMode);
	public List<ModeReglement> getAll();
	public Page<ModeReglement> getParMc(String mc,int page,int size);

}
