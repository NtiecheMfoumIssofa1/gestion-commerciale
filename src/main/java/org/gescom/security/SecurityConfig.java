package org.gescom.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity //permet d'activer la securité web
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	//ce service se charge de charger et de rechercher les users
	@Autowired
	private UserDetailsService userDetailsService;
	
	//cryptage par excellence des mots de passe.
	@Autowired
	private BCryptPasswordEncoder  bCryptPasswordEncoder;
	

	//cette methode est definie pour montrer a spring securite comment il va chercher les users et les roles
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*// cas les users sont save en memoire pour les petites applications
		 
		auth.inMemoryAuthentication()
			.withUser("admin").password("1234").roles("ADMIN","USER")
			  .and()
			   .withUser("user").password("1234").roles("USER");*/  
	//cas avec la bd
		
			auth.userDetailsService(userDetailsService)
				.passwordEncoder(bCryptPasswordEncoder); 
		
	}
	
	//cette methode definie les droits d'accès
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();// desactive le csrf afin de permettre a plusieurs application de se connecter au backend
		//http.formLogin();//indique a spring qu'on a besoin de son form d'authentification permet d'indiquer le form d'authentification
		 
		 http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);// indique a spring de ne pas générer la session
		http.authorizeRequests().antMatchers("/login/**","/management/register/**").permitAll() // qu'on soit connecter ou pas on doit pouvoir avoir acces a ces formulaires
		.antMatchers("/api/**").authenticated();
		http.authorizeRequests().antMatchers( "/management/**").hasAuthority("ADMIN") ;//indique a spring security que la personne qui a le droit d'ajout doit avoir le role ADMIN
		  http.authorizeRequests().anyRequest().authenticated(); //indique que tout les ressources de l'application ont besoin d'être authentifiées
		 
		  http.addFilter(new JWTAuthenticationFilter(authenticationManager()));//ajout du filtre
		  http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);//permet a chaque fois de filtrer l'entete de chaque requete avant d'autoriser ue ressource
		  
	}

}
