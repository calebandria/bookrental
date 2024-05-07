package com.kaleba.bookrental.bookrental.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kaleba.bookrental.bookrental.dto.LivreDto;
import com.kaleba.bookrental.bookrental.model.Livre;

@Service
public interface LivreService {
    List<Livre> findAllLivres();

    List<LivreDto> findAllLivresDto();

    Livre saveLivre(LivreDto livreDto);

    LivreDto findLivreById(int idLivre);

    void updateLivre(LivreDto livre);

    void delete(int idLivre);

}
