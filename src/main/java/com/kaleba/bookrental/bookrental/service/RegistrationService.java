package com.kaleba.bookrental.bookrental.service;
import com.kaleba.bookrental.bookrental.dto.RegistrationDto;

public interface RegistrationService{

    boolean registerUser(RegistrationDto form);

}