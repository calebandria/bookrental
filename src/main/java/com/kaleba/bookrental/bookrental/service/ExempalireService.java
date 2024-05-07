package com.kaleba.bookrental.bookrental.service;

import com.kaleba.bookrental.bookrental.dto.ExemplaireDto;

public interface ExempalireService {
    void createExemplaire(int idLivre, ExemplaireDto exemplaireDto);
}
