package com.kaleba.bookrental.bookrental.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaleba.bookrental.bookrental.model.Adherent;


public interface AdherentRepository extends JpaRepository<Adherent, Integer> {  

    Optional<Adherent> findByUsername(String username);
    Boolean existsByUsername(String username);
}
