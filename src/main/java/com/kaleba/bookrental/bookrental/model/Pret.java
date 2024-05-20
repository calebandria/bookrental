package com.kaleba.bookrental.bookrental.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pret")
public class Pret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_pret")
    private int idPret;

    @Column(name = "date_pret")
    private LocalDate datePret;

    @Column(name = "date_remise")
    private LocalDate dateRemise;

    @ManyToOne
    @JoinColumn(name = "adherent_id")
    Adherent adherent;

    @ManyToOne
    @JoinColumn(name = "examplaire_id")
    Exemplaire exemplaire;

    public int getIdPret() {
        return idPret;
    }

    public void setIdPret(int idPret) {
        this.idPret = idPret;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

    public Exemplaire getExemplaire() {
        return exemplaire;
    }

    public void setExemplaire(Exemplaire exemplaire) {
        this.exemplaire = exemplaire;
    }

    public LocalDate getDatePret() {
        return datePret;
    }

    public void setDatePret(LocalDate datePret) {
        this.datePret = datePret;
    }

    public LocalDate getDateRemise() {
        return dateRemise;
    }

    public void setDateRemise(LocalDate dateRemise) {
        this.dateRemise = dateRemise;
    }

}
