package com.kaleba.bookrental.bookrental.service;

import java.util.List;

import com.kaleba.bookrental.bookrental.dto.ExemplaireDto;
import com.kaleba.bookrental.bookrental.model.Exemplaire;


public interface ExemplaireService {
    void createExemplaire(int idLivre, ExemplaireDto exemplaireDto);
    List<ExemplaireDto>  findAllExemplaires(int idLivre);
    List<ExemplaireDto> findAllExemplairesDto();
    List<ExemplaireDto> findExemplaireDtoDispo();
    void updateExemplaire(Exemplaire exemplaire);
    Exemplaire findExemplaireById(int idExemplaire);
    void deleteExemplaire(int idExemplaire);
    void updateDisp(int idExemplaire);
}
