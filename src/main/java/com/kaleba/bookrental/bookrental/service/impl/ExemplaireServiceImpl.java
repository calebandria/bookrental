package com.kaleba.bookrental.bookrental.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kaleba.bookrental.bookrental.dto.ExemplaireDto;
import com.kaleba.bookrental.bookrental.model.Exemplaire;
import com.kaleba.bookrental.bookrental.model.Livre;
import com.kaleba.bookrental.bookrental.repository.ExemplaireRepository;
import com.kaleba.bookrental.bookrental.repository.LivreRepository;
import com.kaleba.bookrental.bookrental.service.ExemplaireService;

@Service
public class ExemplaireServiceImpl implements ExemplaireService {
    private ExemplaireRepository exemplaireRepository;
    private LivreRepository livreRepository;

    public ExemplaireServiceImpl(ExemplaireRepository exemplaireRepository, LivreRepository livreRepository) {
        this.exemplaireRepository = exemplaireRepository;
        this.livreRepository = livreRepository;
    }

    @Override
    public void createExemplaire(int idLivre, ExemplaireDto exemplaireDto) {
        Livre livre = livreRepository.findById(idLivre).get();
        Exemplaire exemplaire = mapToExemplaire(exemplaireDto);
        exemplaire.setLivre(livre);
        exemplaireRepository.save(exemplaire);

    }

    @Override
    public List<ExemplaireDto> findAllExemplairesDto() {
        List<Exemplaire> exemplaires = exemplaireRepository.findAll();
        return exemplaires.stream().map(exemplaire -> mapToExemplaireDto(exemplaire)).collect(Collectors.toList());
    }

    @Override
    public List<ExemplaireDto> findExemplaireDtoDispo() {
        List<ExemplaireDto> exemplaires = findAllExemplairesDto();

        return exemplaires.stream().filter(exemplaire -> exemplaire.getDisponible() == true)
                .collect(Collectors.toList());
    }

    private Exemplaire mapToExemplaire(ExemplaireDto exemplaireDto) {
        Exemplaire exemplaire = new Exemplaire();

        exemplaire.setIdExemplaire(exemplaireDto.getIdExemplaire());
        exemplaire.setDisponible(exemplaireDto.getDisponible());

        return exemplaire;
    }

    @Override
    public List<ExemplaireDto> findAllExemplaires(int idLivre) {
        List<Exemplaire> exemplaires = exemplaireRepository.findByIdLivre(idLivre);

        return exemplaires.stream().map(exemplaire -> mapToExemplaireDto(exemplaire)).collect(Collectors.toList());

    }

    private ExemplaireDto mapToExemplaireDto(Exemplaire exemplaire) {
        ExemplaireDto exemplaireDto = new ExemplaireDto();

        exemplaireDto.setIdExemplaire(exemplaire.getIdExemplaire());
        exemplaireDto.setDisponible(exemplaire.getDisponible());

        if (exemplaire.getDisponible())
            exemplaireDto.setViewValue("Oui");
        else
            exemplaireDto.setViewValue("Non");

        exemplaireDto.setTitle(exemplaire.getLivre().getTitre());

        return exemplaireDto;
    }

    @Override
    public void updateExemplaire(Exemplaire exemplaire) {
        exemplaireRepository.save(exemplaire);
    }

    @Override
    public Exemplaire findExemplaireById(int idExemplaire) {
        Exemplaire exemplaire = exemplaireRepository.findByIdExemplaire(idExemplaire);
        return exemplaire;
    }

    @Override
    public void deleteExemplaire(int idExemplaire){
        exemplaireRepository.deleteById(idExemplaire);
    }

    @Override
    public void updateDisp(int idExemplaire){
        Exemplaire exemplaire = exemplaireRepository.findByIdExemplaire(idExemplaire);

        if(exemplaire.getDisponible() == false){
            exemplaire.setDisponible(true);
        }
        else exemplaire.setDisponible(false);

        exemplaireRepository.save(exemplaire);
    }
}
