package org.gescom.web;

import java.util.List;

import org.gescom.entities.AppUser;
import org.gescom.entities.Fonction;
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
public class FonctionRestController {
	@Autowired
	private org.gescom.metier.FonctionService fonctionService;

	@PostMapping("/fonction")
	public Fonction saveFonction(@RequestBody Fonction f) {
		return fonctionService.saveFonction(f);
	}
    @PutMapping("/fonction/{idFonction}")
	public Fonction updateFonction(@RequestBody Fonction f, @PathVariable Long idFonction) {
		return fonctionService.updateFonction(f, idFonction);
	}
    @DeleteMapping("/fonction/{idFonction}")
	public boolean deleteFonction(Long idFonction) {
		return fonctionService.deleteFonction(idFonction);
	}
    @GetMapping("/fonctionParMc")
	public Page<Fonction> chercherParMc(
			@RequestParam(name="mc",defaultValue="") String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return fonctionService.chercherParMc(mc, page, size);
	}
    @GetMapping("/fonction")
    public List<Fonction> getALLFonction() {
		return fonctionService.getALLFonction();
	}
	@GetMapping("/UserParFonction/{idFonction}")
	public Page<AppUser> getUserParFonction(@PathVariable Long idFonction,int page,int size) {
		return fonctionService.getUserParFonction(idFonction, page,size);
	}
    @GetMapping("/getFonction/{id}")
	public Fonction getFonction(@PathVariable Long id) {
		return fonctionService.getFonction(id);
	}

}
