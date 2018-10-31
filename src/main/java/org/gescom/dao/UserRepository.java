package org.gescom.dao;

import org.gescom.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository  extends JpaRepository<AppUser, Long>{

	public AppUser findByUsername(String username);
	
	/*@Modifying
	@Transactional
	@Query("update AppUser a set a.action=ACTIF where a.id= :x")
	public void activerUser(@Param("x")Long idUser);
	
	@Modifying
	@Transactional
	@Query("update AppUser a set a.action=INACTIF where a.id= :x")
	public AppUser desactiverUser(@Param("x")Long idUser);
	*/
	@Query("select u from AppUser u where u.id=:x ")
	public AppUser trouveid(@Param("x")Long idUser);
	
	
}
