package com.kaleba.bookrental.bookrental.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaleba.bookrental.bookrental.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
