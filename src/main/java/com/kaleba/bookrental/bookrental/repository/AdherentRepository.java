package com.kaleba.bookrental.bookrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaleba.bookrental.bookrental.model.Adherent;


public interface AdherentRepository extends JpaRepository<Adherent, Integer> {  

}
