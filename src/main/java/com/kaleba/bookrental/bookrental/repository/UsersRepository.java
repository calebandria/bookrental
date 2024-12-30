package com.kaleba.bookrental.bookrental.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaleba.bookrental.bookrental.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    
    Optional<Users> findByUsername(String username);
}