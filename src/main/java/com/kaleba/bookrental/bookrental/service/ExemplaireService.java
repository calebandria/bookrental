package com.kaleba.bookrental.bookrental.service;

import java.util.List;

import com.kaleba.bookrental.bookrental.dto.ExemplaireDto;


public interface ExemplaireService {
    void createExemplaire(int idLivre, ExemplaireDto exemplaireDto);
    public List<ExemplaireDto>  findAllExemplaires(int idLivre);
    public List<ExemplaireDto> findAllExemplairesDto();
    public List<ExemplaireDto> findExemplaireDtoDispo();
}
