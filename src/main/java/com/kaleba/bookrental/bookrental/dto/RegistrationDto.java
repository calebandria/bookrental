package com.kaleba.bookrental.bookrental.dto;

import jakarta.validation.constraints.NotBlank;

public class RegistrationDto {


    private int idAdherent;

    @NotBlank(message = "Firstname is required")
    private String prenom;

    @NotBlank(message = "Familyname is required")
    private String nom;

    @NotBlank(message ="username is required")
    private String username;

    @NotBlank(message ="Password is required")
    private String password;

    public String getPrenom(){
        return prenom;
    }

    public void setIdAdherent(int idAdherent){
        this.idAdherent = idAdherent;
    }

    public int getIdAdherent(){
        return idAdherent;
    }
    public void setPrenom(String prenom){
        this.prenom = prenom; 
    }

    public String getNom(){
        return nom;
    }

    public void setNom(String nom){
        this.nom = nom; 
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password; 
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username; 
    }


    
}
