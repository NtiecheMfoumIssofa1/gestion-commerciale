package org.gescom.web;

import java.util.List;

import org.gescom.entities.Depense;
import org.gescom.metier.DepenseMetier;
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
public class DepenseRestController {
	@Autowired
	private DepenseMetier depenseMetier;
	@PostMapping("/depense/{idCategorie}")
	public Depense saveDepense(@RequestBody Depense d, @PathVariable Long idCategorie) {
		return depenseMetier.saveDepense(d, idCategorie);
	}
	@PutMapping("/depense/{idDepense}/{idCategorie}")
	public Depense updateDepense(
			@PathVariable Long idDepense, @RequestBody Depense d, @PathVariable Long idCategorie) {
		return depenseMetier.updateDepense(idDepense, d, idCategorie);
	}
	@DeleteMapping("/depense/{idDepense}")
	public boolean deleteDepense(@PathVariable Long idDepense) {
		return depenseMetier.deleteDepense(idDepense);
	}
	@GetMapping("/depense")
	public List<Depense> getAllDepense() {
		return depenseMetier.getAllDepense();
	}
	@GetMapping("/depenseId/{idDepense}")
	public Depense getDepense(@PathVariable Long idDepense) {
		return depenseMetier.getDepense(idDepense);
	}
	@GetMapping("/depenseMc")
	public Page<Depense> getParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam (name="page",defaultValue="size")int page, int size) {
		return depenseMetier.getParMc(mc, page, size);
	}
	

}
