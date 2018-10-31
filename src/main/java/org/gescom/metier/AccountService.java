package org.gescom.metier;

import org.gescom.entities.AppRole;
import org.gescom.entities.AppUser;

public interface AccountService {
	
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username, String roleName);
    public AppUser findUserByUsername(String username);
    public boolean activeUser(Long idUser);
    public AppUser updateUser(AppUser user,Long iduser,Long idFonction);
    public boolean DesactiveUser(Long idUser);
    
    public void addFonctionToUser(Long idUser, Long idFonction);
}
