package com.kaleba.bookrental.bookrental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kaleba.bookrental.bookrental.model.Exemplaire;


public interface ExemplaireRepository extends JpaRepository<Exemplaire, Integer> {
    Exemplaire findByIdExemplaire(int idExemplaire);
    @Query("SELECT c FROM Exemplaire c WHERE c.livre.idLivre = :idLivre")
    List <Exemplaire> findByIdLivre(int idLivre);

}

