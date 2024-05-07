package com.kaleba.bookrental.bookrental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaleba.bookrental.bookrental.model.Exemplaire;


public interface ExemplaireRepository extends JpaRepository<Exemplaire, Integer> {
    Exemplaire findByIdExemplaire(int idExemplaire);

}

