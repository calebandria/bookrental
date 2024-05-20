package com.kaleba.bookrental.bookrental.dto;

public class ExemplaireDto {

    private int idExemplaire;
    private boolean disponible;
    private String viewValue;
    private String title;

    public ExemplaireDto() {
        disponible = true;
    }

    public int getIdExemplaire() {
        return idExemplaire;
    }

    public void setIdExemplaire(int idExemplaire) {
        this.idExemplaire = idExemplaire;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setViewValue(String viewValue){
        this.viewValue = viewValue;
    }

    public String getViewValue(){
        return viewValue;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    
}
