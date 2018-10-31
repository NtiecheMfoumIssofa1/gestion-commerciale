package org.gescom.metierImpl;

import java.util.ArrayList;
import java.util.Collection;

import org.gescom.entities.AppUser;
import org.gescom.metier.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private AccountService  accountService; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user=accountService.findUserByUsername(username);
	   if (user==null) throw new UsernameNotFoundException(username);
		//cette collection permet de retourner les users et leurs roles
	   Collection<GrantedAuthority> authorities= new ArrayList<>();
	   user.getRoles().forEach(r->{
		   authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
	   });
	   
	   return new User(user.getUsername(),user.getPassword(), authorities);
	}

}
