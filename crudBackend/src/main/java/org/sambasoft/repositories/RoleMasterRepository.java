package org.sambasoft.repositories;

import org.sambasoft.entities.RoleMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleMasterRepository extends JpaRepository<RoleMaster, Long>{
	
	
	
	
	@Query("SELECT r FROM RoleMaster r WHERE r.roleUserType = :roleUserType")
	RoleMaster findRoleMasterByRoleUserType(@Param("roleUserType") String roleUserType);
}