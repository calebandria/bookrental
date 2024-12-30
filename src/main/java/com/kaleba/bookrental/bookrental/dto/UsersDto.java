package com.kaleba.bookrental.bookrental.dto;

public class UsersDto {
    
    private int idUser;
    private String username;
    private String password;

    public int getIdUser(){
        return idUser;
    }

    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }

    public void setIdUser(int idUser){
        this.idUser = idUser;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }


}
