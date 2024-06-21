package com.kaleba.bookrental.bookrental.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class PretDto {

    private int idPret;

    private int idExemplaire;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime datePret;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateRemise;

    private String adherentName;

    private String exemplaireTitle;

    public int getIdPret() {
        return idPret;
    }

    public void setIdPret(int idPret) {
        this.idPret = idPret;
    }

    public int getIdExemplaire() {
        return idExemplaire;
    }

    public void setIdExemplaire(int idExemplaire) {
        this.idExemplaire = idExemplaire;
    }

    public LocalDateTime getDatePret() {
        return datePret;
    }

    public void setDatePret(LocalDateTime datePret) {
        this.datePret = datePret;
    }

    public LocalDateTime getDateRemise() {
        return dateRemise;
    }

    public void setDateRemise(LocalDateTime dateRemise) {
        this.dateRemise = dateRemise;
    }

    public void setAdherentName(String adherentName){
        this.adherentName = adherentName;
    }

    public void setExemplaireTitle(String exemplaireTitle){
        this.exemplaireTitle = exemplaireTitle;
    }

    public String getAdherentName(){
        return this.adherentName;
    }

    public String getExemplaireTitle(){
        return this.exemplaireTitle;
    }

}
