package org.gescom.web;

import java.util.List;

import org.gescom.entities.Statut;
import org.gescom.metier.StatutMetier;
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
public class StatutRestController {
	@Autowired
	private StatutMetier statutMetier;

	@PostMapping("/statut")
	public Statut saveStatut(@RequestBody Statut s) {
		return statutMetier.saveStatut(s);
	}
	@PutMapping("/statut/{idStatut}")
	public Statut updateStatut(@PathVariable Long idStatut, @RequestBody Statut s) {
		return statutMetier.updateStatut(idStatut, s);
	}
	@DeleteMapping("/statut/{idStatut}")
	public boolean deleteStatut(@PathVariable Long idStatut) {
		return statutMetier.deleteStatut(idStatut);
	}
	@GetMapping("/statutId/{idStatut}")
	public Statut getStatut(@PathVariable Long idStatut) {
		return statutMetier.getStatut(idStatut);
	}
	@GetMapping("/statut")
	public List<Statut> getAllStatut() {
		return statutMetier.getAllStatut();
	}
	@GetMapping("/statutMc")
	public Page<Statut> getParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return statutMetier.getParMc(mc, page, size);
	}
	
}
