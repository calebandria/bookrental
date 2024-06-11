package com.kaleba.bookrental.bookrental.dto;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class PretDto {

    private int idPret;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime datePret;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateRemise;

    public int getIdPret() {
        return idPret;
    }

    public void setIdPret(int idPret) {
        this.idPret = idPret;
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

}
