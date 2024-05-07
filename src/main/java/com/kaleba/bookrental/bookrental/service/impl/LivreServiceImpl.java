package com.kaleba.bookrental.bookrental.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import com.kaleba.bookrental.bookrental.dto.LivreDto;
import com.kaleba.bookrental.bookrental.model.Livre;
import com.kaleba.bookrental.bookrental.repository.LivreRepository;
import com.kaleba.bookrental.bookrental.service.LivreService;

@Service
public class LivreServiceImpl implements LivreService {

    private LivreRepository livreRepository;

    public LivreServiceImpl(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    @Override
    public List<Livre> findAllLivres() {
        return livreRepository.findAll();
    }

    @Override
    public List<LivreDto> findAllLivresDto() {
        List<Livre> livres = livreRepository.findAll();
        return livres.stream().map(livre -> mapToLivreDto(livre)).collect(Collectors.toList());
    }

    private LivreDto mapToLivreDto(Livre livre) {
        LivreDto livreDto = new LivreDto();

        livreDto.setIdLivre((livre.getIdLivre()));
        livreDto.setTitre(livre.getTitre());
        livreDto.setAuteur(livre.getAuteur());
        livreDto.setEdition(livre.getEdition());

        return livreDto;
    }

    @Override
    public Livre saveLivre(LivreDto livreDto){
        Livre livre = mapToLivre(livreDto);
        return livreRepository.save(livre);
    }

    @Override
    public LivreDto findLivreById(int idLivre) {
        Livre livre = livreRepository.findById(idLivre).get();
        return mapToLivreDto(livre);

    }

    @Override
    public void updateLivre(LivreDto livreDto) {
        Livre livre = mapToLivre(livreDto);
        livreRepository.save(livre);
    }

    private Livre mapToLivre(LivreDto livreDto) {
        Livre livre = new Livre();

        livre.setIdLivre((livreDto.getIdLivre()));
        livre.setTitre(livreDto.getTitre());
        livre.setAuteur(livreDto.getAuteur());
        livre.setEdition(livreDto.getEdition());

        return livre;
    }

    @Override
    public void delete(int idLivre) {
        livreRepository.deleteById(idLivre);
    }
}
