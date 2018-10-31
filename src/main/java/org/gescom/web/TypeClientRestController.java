package org.gescom.web;

import java.util.List;

import org.gescom.entities.TypeClient;
import org.gescom.metier.TypeClientMetier;
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
public class TypeClientRestController {
	@Autowired
	private TypeClientMetier typeClientMetier;

	@PostMapping("/typeClient")
	public TypeClient saveTypeClient(@RequestBody TypeClient s) {
		return typeClientMetier.saveTypeClient(s);
	}
	@PutMapping("/typeClient/{idTypeClient}")
	public TypeClient updateTypeClient(@PathVariable Long idTypeClient, @RequestBody TypeClient s) {
		return typeClientMetier.updateTypeClient(idTypeClient, s);
	}
	@DeleteMapping("/typeClient/{idTypeClient}")
	public boolean deleteTypeClient(@PathVariable Long idTypeClient) {
		return typeClientMetier.deleteTypeClient(idTypeClient);
	}
	@GetMapping("/typeClient/{idTypeClient}")
	public TypeClient getTypeClient(@PathVariable Long idTypeClient) {
		return typeClientMetier.getTypeClient(idTypeClient);
	}
	@GetMapping("/typeClient")
	public List<TypeClient> getAllTypeClient() {
		return typeClientMetier.getAllTypeClient();
	}
	@GetMapping("/typeClientMc")
	public Page<TypeClient> getParMc(
			@RequestParam(name="mc",defaultValue="")String mc, 
			@RequestParam(name="page",defaultValue="0")int page, 
			@RequestParam(name="size",defaultValue="5")int size) {
		return typeClientMetier.getParMc(mc, page, size);
	}
	
}
