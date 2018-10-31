package org.gescom.metierImpl;


import org.gescom.dao.FonctionRepository;
import org.gescom.dao.RoleRepository;
import org.gescom.dao.UserRepository;
import org.gescom.entities.AppRole;
import org.gescom.entities.AppUser;
import org.gescom.entities.Fonction;
import org.gescom.metier.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class AccountServiceImpl  implements AccountService{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository  roleRepository; 
	@Autowired
	private FonctionRepository  fonctionRepository;
	@Override
	public AppUser saveUser(AppUser user) {
		
		//crypter le pass avant l'insertion
		String hashPW= bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		
		
		return userRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		
		AppRole role= roleRepository.findByRoleName(roleName);
		AppUser user= userRepository.findByUsername(username);
		
		user.getRoles().add(role);
		
	}

	@Override
	public AppUser findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

	@Override
	public boolean activeUser(Long idUser) {
		if( userRepository.trouveid(idUser)==null 
				||  userRepository.getOne(idUser)!=null) {
			
			AppUser a =userRepository.getOne(idUser);
			a.setAction("ACTIF");
			return true;
		}else
		return false;
	}

	@Override
	public AppUser updateUser(AppUser user, Long iduser, Long idFonction) {
		if( userRepository.trouveid(iduser)==null 
				||  userRepository.getOne(iduser)!=null) {
			
			Fonction f = fonctionRepository.getOne(idFonction);
			user.setFonction(f);
			
			//crypter le pass avant l'insertion
			String hashPW= bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(hashPW);
				
			return userRepository.save(user);
		}
		else
		return null;
	}

	@Override
	public boolean DesactiveUser(Long idUser) {
		if( userRepository.trouveid(idUser)==null 
				||  userRepository.getOne(idUser)!=null) {
			
			AppUser a =userRepository.getOne(idUser);
			a.setAction("INACTIF");
			return true;
		}else
		return false;
	}

	@Override
	public void addFonctionToUser(Long idUser, Long idFonction) {
		Fonction f=fonctionRepository.getOne(idFonction);
		AppUser u =userRepository.getOne(idUser);
		f.getAppUsers().add(u);
		
	}

}
