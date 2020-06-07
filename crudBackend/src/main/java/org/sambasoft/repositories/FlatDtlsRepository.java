package org.sambasoft.repositories;

import org.sambasoft.entities.FlatDtls;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlatDtlsRepository extends JpaRepository<FlatDtls, Long>{

	FlatDtls findByownerName(String name);

}
