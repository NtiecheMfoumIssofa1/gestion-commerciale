package org.gescom.web;

import java.util.List;

import org.gescom.entities.ModeReglement;
import org.gescom.metier.ModeReglementMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ModeReglementRestController{
	@Autowired
	private ModeReglementMetier modeReglementMetier;
	
	@PostMapping("/reglement")
	public ModeReglement saveMode(@RequestBody ModeReglement m) {
		return modeReglementMetier.saveMode(m);
	}
	@PutMapping("/reglement/{id}")
	public ModeReglement updateMode(@PathVariable String id, @RequestBody ModeReglement m) {
		return modeReglementMetier.updateMode(id, m);
	}
	@DeleteMapping("/reglement/{id}")
	public boolean deleteMode(@PathVariable String id) {
		return modeReglementMetier.deleteMode(id);
	}
	@GetMapping("/reglementId/{idMode}")
	public ModeReglement getMode(String idMode) {
		return modeReglementMetier.getMode(idMode);
	}
	@GetMapping("/reglement")
	public List<ModeReglement> getAll() {
		return modeReglementMetier.getAll();
	}
	@GetMapping("/reglementMc")
	public Page<ModeReglement> getParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return modeReglementMetier.getParMc(mc, page, size);
	}
	

}
