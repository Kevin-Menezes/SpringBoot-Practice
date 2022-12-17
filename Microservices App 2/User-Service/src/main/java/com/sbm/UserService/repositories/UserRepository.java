package com.sbm.UserService.repositories;

import com.sbm.UserService.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {
    Users findByUserId(Long userId);
}
