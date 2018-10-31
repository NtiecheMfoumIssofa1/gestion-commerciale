package org.gescom.web;

import java.util.List;

import org.gescom.entities.Devis;
import org.gescom.metier.DevisMetier;
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
public class DevisRestController {
	@Autowired
	private DevisMetier devisMetier;

	@PostMapping("/devis/{idClient}")
	public Devis saveDevis(@RequestBody Devis d, @PathVariable Long idClient) {
		return devisMetier.saveDevis(d, idClient);
	}
	@PutMapping("/devis/{idDevis}/{idClient}")
	public Devis updateDevis(
		@PathVariable Long idDevis, @RequestBody Devis d, @PathVariable Long idClient) {
		return devisMetier.updateDevis(idDevis, d, idClient);
	}
	@DeleteMapping("/devis/{idDevis}")
	public boolean deleteDevis(Long idDevis) {
		return devisMetier.deleteDevis(idDevis);
	}
	@GetMapping("/devisId/{idDevis}")
	public Devis getDevis(@PathVariable Long idDevis) {
		return devisMetier.getDevis(idDevis);
	}
	@GetMapping("/devis")
	public List<Devis> getAllDevis() {
		return devisMetier.getAllDevis();
	}
	@GetMapping("/devisMc")
	public Page<Devis> getAllParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return devisMetier.getAllParMc(mc, page, size);
	}
	
}
