package com.santt4naweb.workshop01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.santt4naweb.workshop01.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
