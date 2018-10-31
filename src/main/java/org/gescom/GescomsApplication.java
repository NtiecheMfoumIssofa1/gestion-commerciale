package org.gescom;



import java.time.Instant;
import java.util.stream.Stream;

import org.gescom.dao.FonctionRepository;
import org.gescom.entities.AppRole;
import org.gescom.entities.AppUser;
import org.gescom.entities.Fonction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@SpringBootApplication
public class GescomsApplication implements CommandLineRunner{
	
	@Autowired
	private org.gescom.metier.AccountService accountService;
	@Autowired
	private FonctionRepository fonctionRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GescomsApplication.class, args);
	}
	
	//cette instanciation est impérative sini la fonction de hashage dans securityConfig  ne fonctionnera pas
	@Bean
	public BCryptPasswordEncoder getPE(){
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		//Service Fonction
		
		Fonction f1=fonctionRepository.save(new Fonction("Comptable", "ACTIVEE"));
		Fonction f2=fonctionRepository.save(new Fonction("Gerant"));
		Fonction f3=fonctionRepository.save(new Fonction("proprietaire", "ACTIVEE"));
		//save utilisateur
		AppUser u1=	accountService.saveUser( new AppUser(null,"admin","admin","ACTIF"));
		AppUser u2=		accountService.saveUser( new AppUser(null,"user","user","ACTIF"));
		AppUser u3=		accountService.saveUser( new AppUser(null,"comptable","comptable"));
		//save Role
		accountService.saveRole(new AppRole(null, "ADMIN"));
		accountService.saveRole(new AppRole(null, "USER"));
		accountService.saveRole(new AppRole(null, "COMPTABLE"));
		//addroleToUser
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "COMPTABLE");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "USER");
		accountService.addRoleToUser("comptable", "COMPTABLE");
		//addfonctionToUser
		accountService.addFonctionToUser(u1.getId(), f3.getIdFonction());
		accountService.addFonctionToUser(u2.getId(), f2.getIdFonction());
		accountService.addFonctionToUser(u3.getId(), f1.getIdFonction());
		
		
		
		
		
	}

}
