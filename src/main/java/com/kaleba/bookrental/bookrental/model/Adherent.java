package com.kaleba.bookrental.bookrental.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "data_adhesion", columnDefinition = "DATETIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateAdhesion;

    @OneToMany(mappedBy="adherent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pret> prets = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id_adherent"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName="id_role"))
    private List<Role> roles = new ArrayList<>();

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username; 
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles){
        this.roles = roles;
    }
}
