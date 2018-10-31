package org.gescom.dao;

import org.gescom.entities.Taxes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxeRepository extends JpaRepository<Taxes, Long>{

}
