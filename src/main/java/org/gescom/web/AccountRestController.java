package org.gescom.web;


import org.gescom.entities.AppRole;
import org.gescom.entities.AppUser;
import org.gescom.entities.Fonction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management")
public class AccountRestController {
	@Autowired
	private org.gescom.metier.AccountService accountService;
	 
	
	@PostMapping("/register")  
	public AppUser register(@RequestBody RegisterForm userForm){
		if(!userForm.getPassword().equals(userForm.getRepassword()))
				throw new RuntimeException(" you must confirm your password");
		
		AppUser user=accountService.findUserByUsername(userForm.getUsername());
		
		if(user!=null) throw new RuntimeException(" this user already exist");
		AppUser appUser = new AppUser();
		appUser.setUsername(userForm.getUsername());
		appUser.setPassword(userForm.getPassword());
			accountService.saveUser(appUser);
		//ajout un role par defaut a un user
			accountService.addRoleToUser(userForm.getUsername(), "USER");
			return appUser;
	}
    @PostMapping("/account")
	public AppUser saveUser(@RequestBody AppUser user) {
		return accountService.saveUser(user);
	}
    @PostMapping("/role")
	public AppRole saveRole( @RequestBody AppRole role) {
		return accountService.saveRole(role);
	}
    @PostMapping("/addRoleToUser/{username}/{roleName}")
	public void addRoleToUser(@PathVariable String username,@PathVariable String roleName) {
		accountService.addRoleToUser(username, roleName);
	}
    @PatchMapping("/activeUser/{idUser}")
	public boolean activeUser(@PathVariable Long idUser) {
		return accountService.activeUser(idUser);
	}
    @PutMapping("/account/{iduser}/{idFonction}")
	public AppUser updateUser(@RequestBody AppUser user,@PathVariable  Long iduser, @PathVariable  Long idFonction) {
		return accountService.updateUser(user, iduser, idFonction);
	}
    @PatchMapping("/DesactiveUser/{idUser}")
	public boolean DesactiveUser( @PathVariable Long idUser) {
		return accountService.DesactiveUser(idUser);
	}

	
	
	

}
