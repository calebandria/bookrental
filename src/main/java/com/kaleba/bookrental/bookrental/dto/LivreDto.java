package com.kaleba.bookrental.bookrental.dto;

import jakarta.validation.constraints.NotEmpty;

public class LivreDto {

    private int idLivre;
    @NotEmpty(message="Titre ne doit pas être vide")
    private String titre;
    @NotEmpty(message="Auteur ne doit pas être vide")
    private String auteur;
    @NotEmpty(message="Edition ne doit pas être vide")
    private String edition;

    public int getIdLivre() {
        return idLivre;
    }

    public void setIdLivre(int idLivre) {
        this.idLivre = idLivre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

}
