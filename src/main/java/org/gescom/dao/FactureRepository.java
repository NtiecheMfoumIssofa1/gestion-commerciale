package org.gescom.dao;

import org.gescom.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, String>{

}
