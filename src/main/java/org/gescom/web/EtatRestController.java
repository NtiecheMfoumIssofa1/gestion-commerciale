package org.gescom.web;

import java.util.List;

import org.gescom.entities.Etat;
import org.gescom.metier.EtatMetier;
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
public class EtatRestController {
	@Autowired
	private EtatMetier etatMetier;
	@PostMapping("/etat")
	public Etat saveEtat(@RequestBody Etat e) {
		return etatMetier.saveEtat(e);
	}
	@PutMapping("/etat/{idEtat}")
	public Etat updateEtat(@PathVariable Long idEtat, @RequestBody Etat e) {
		return etatMetier.updateEtat(idEtat, e);
	}
	@DeleteMapping("/eata/{idEtat}")
	public boolean deleteEtat(@PathVariable Long idEtat) {
		return etatMetier.deleteEtat(idEtat);
	}
	@GetMapping("/etatid/{idEtat}")
	public Etat getEtat(@PathVariable Long idEtat) {
		return etatMetier.getEtat(idEtat);
	}
	@GetMapping("/etat")
	public List<Etat> getAllEtat() {
		return etatMetier.getAllEtat();
	}
	@GetMapping("/etatMc")
	public Page<Etat> getParMc(
			@RequestParam(name="mc",defaultValue="")String mc,
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return etatMetier.getParMc(mc, page, size);
	}
	

}
