package com.abm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.abm.entity.Users;

@Repository
public interface UsersRepository  extends JpaRepository<Users, Long>{

	@Query("select c from Users c where c.userName=?1 and c.password=?1")
	Users findByUserNameAndPassword(String userName, String password);
      
	@Query("select count(c) from Users c where c.userName = ?1")
	Long findIfUserExists(String userName);
    
	Users findByuserId(Long UserId);
}
