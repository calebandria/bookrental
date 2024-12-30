package com.kaleba.bookrental.bookrental.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import com.kaleba.bookrental.bookrental.util.*;

@Entity
@Table(name = "adherent")
public class Adherent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_adherent")
    private int idAdherent;

    @Column(name = "nom")
    private String nom;

    @PrePersist
    @PreUpdate
    public void convertToUpperCase() {
        if (this.nom != null) {
            this.nom = this.nom.toUpperCase();
        }
    }

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_adhesion", columnDefinition = "TIMESTAMP")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateAdhesion;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy="adherent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pret> prets = new ArrayList<>();

    @OneToOne(mappedBy = "adherent", cascade = CascadeType.ALL, optional = true)
    private Users user;

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
        this.prenom = FirstNameUtil.capitalizeFirstLetters(prenom);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
