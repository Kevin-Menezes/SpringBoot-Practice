package com.sa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sa.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
