package org.gescom.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JWTAuthorizationFilter  extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//resolution probleme de CORS partie front office
		response.addHeader("Access-Control-Allow-Origin", "*");
		response.addHeader("Access-Control-Allow-Headers",
						"Origin, Accept, X-Requested-With, Content-Type, "
						+ "Access-Control-Request-Method, "
						+ "Access-Control-Request-Headers, "
						+ "Authorization");
		
		//permet d'envoyer le token au front de l'application a mettre quand on est coté front
		response.addHeader("Access-Control-Expose-Headers",
												"Access-Control-Allow-Origin, "
												+ "Access-Control-Allow-Credentials, Authorization");
		
		//permet de pallier au pb d'enregistrement des pages avec la methode options erreur 403
		
		if(request.getMethod().equals("OPTIONS")){
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else{ //si cette methode ne contient pas l'entete options ce a ce moment là qu'on teste le jwt
			
			//permet de regarder si la methode a une entete
			String jwt=request.getHeader(SecurityConstants.HEADER_STRING);
			System.out.println("*********************************");
			System.out.println(jwt);
		  if(jwt==null ||  !jwt.startsWith(SecurityConstants.TOKEN_PREFIX)){
			  filterChain.doFilter(request, response); 
			  return;
		  }
		  Claims claims=Jwts.parser()
				    .setSigningKey(SecurityConstants.SECRET)
				    .parseClaimsJws(jwt.replace(SecurityConstants.TOKEN_PREFIX, ""))
				    .getBody();
		  String username=claims.getSubject();//recupere le user
		  ArrayList<Map<String, String>> roles=(ArrayList<Map<String,String>>)
				  claims.get("roles"); //recuper le role de type clé /valeur
		  Collection<GrantedAuthority> authorities=new ArrayList<>();
		  roles.forEach(r->{
			  authorities.add(new SimpleGrantedAuthority(r.get("authority")));
		  });
		  //création d'un object de type user role authentication token
		  UsernamePasswordAuthenticationToken authenticatedUser=
				  new UsernamePasswordAuthenticationToken(username,null,authorities);
		  			SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
		  			filterChain.doFilter(request, response);
		}
		
		
	}

}
