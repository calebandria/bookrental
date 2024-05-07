package com.kaleba.bookrental.bookrental.service.impl;

import com.kaleba.bookrental.bookrental.dto.ExemplaireDto;
import com.kaleba.bookrental.bookrental.model.Exemplaire;
import com.kaleba.bookrental.bookrental.model.Livre;
import com.kaleba.bookrental.bookrental.repository.ExemplaireRepository;
import com.kaleba.bookrental.bookrental.repository.LivreRepository;
import com.kaleba.bookrental.bookrental.service.ExempalireService;

public class ExemplaireServiceImpl implements ExempalireService {
    private ExemplaireRepository exemplaireRepository;
    private LivreRepository livreRepository;

    public ExemplaireServiceImpl(ExemplaireRepository exemplaireRepository, LivreRepository livreRepository){
        this.exemplaireRepository = exemplaireRepository;
        this.livreRepository = livreRepository;
    }

    public void createExemplaire(int idLivre, ExemplaireDto exemplaireDto){
        Livre livre = livreRepository.findById(idLivre).get();
        Exemplaire exemplaire = mapToExemplaire(exemplaireDto);
        exemplaire.setLivre(livre);
        exemplaireRepository.save(exemplaire);

    }

    private Exemplaire mapToExemplaire(ExemplaireDto exemplaireDto) {
        Exemplaire exemplaire = new Exemplaire();

        exemplaire.setIdExemplaire(exemplaireDto.getIdExemplaire());
        exemplaire.setDisponible(exemplaireDto.getDisponible());

        return exemplaire;
    }
}
