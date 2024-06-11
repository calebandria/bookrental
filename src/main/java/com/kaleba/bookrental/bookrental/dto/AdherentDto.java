package com.kaleba.bookrental.bookrental.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.kaleba.bookrental.bookrental.model.Role;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class AdherentDto {

    private int idAdherent;
    @NotEmpty(message = "Nom ne doit pas être vide")
    private String nom;
    @NotEmpty(message= "Prénom ne doit pas être vide")
    private String prenom;
    @NotNull(message = "Date d'adhésion ne doit pas être vide")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateAdhesion;
    @NotNull(message= "Rôle ne doit pas être vide")
    private Role role;

    public LocalDateTime getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(LocalDateTime date_adhesion) {
        this.dateAdhesion = date_adhesion;
    }

    public int getIdAdherent() {
        return idAdherent;
    }

    public void setIdAdherent(int idAdherent) {
        this.idAdherent = idAdherent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
