package org.gescom.dao;

import java.util.List;

import org.gescom.entities.AppUser;
import org.gescom.entities.Fonction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface FonctionRepository extends JpaRepository<Fonction, Long>{
	@Modifying
	@Transactional
	@Query("update Fonction f set f.action=ACTIVEE where f.idFonction=:x")
	public boolean deleteFonction(@Param("x")Long id);
	@Query("select f from Fonction f where f.libelleFonction like :x")
	public Page<Fonction> chercherParMc(@Param("x")String mc,Pageable pageable);
	
	@Query("select u from AppUser u where u.fonction.idFonction = :x")
	public Page<AppUser> getUserParFonction(@Param("x")Long id,Pageable pageable);
	
	@Query("select f from Fonction f")
	public List<Fonction> getAllFonction();

}
