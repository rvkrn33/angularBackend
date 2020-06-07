package org.sambasoft.repositories;

import org.sambasoft.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository  extends JpaRepository<User, Long>{

	
	
	
	@Query("SELECT u FROM User u WHERE u.userId = :userId and u.pass = :pass and u.userType = :uType")
	User findUserByParams(@Param("userId") String userId, @Param("pass") String pass,@Param("uType") String uType);
}
