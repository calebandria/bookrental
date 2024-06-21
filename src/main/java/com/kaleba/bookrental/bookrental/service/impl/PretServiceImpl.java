package com.kaleba.bookrental.bookrental.service.impl;

import org.springframework.stereotype.Service;

import com.kaleba.bookrental.bookrental.dto.PretDto;
import com.kaleba.bookrental.bookrental.model.Adherent;
import com.kaleba.bookrental.bookrental.model.Exemplaire;
import com.kaleba.bookrental.bookrental.model.Pret;
import com.kaleba.bookrental.bookrental.repository.AdherentRepository;
import com.kaleba.bookrental.bookrental.repository.ExemplaireRepository;
import com.kaleba.bookrental.bookrental.repository.PretRepository;
import com.kaleba.bookrental.bookrental.service.PretService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PretServiceImpl implements PretService{
    private PretRepository pretRepository;
    private AdherentRepository adherentRepository;
    private ExemplaireRepository exemplaireRepository;


    public PretServiceImpl(PretRepository pretRepository,AdherentRepository adherentRepository, ExemplaireRepository exemplaireRepository){
        this.pretRepository = pretRepository;
        this.adherentRepository = adherentRepository;
        this.exemplaireRepository = exemplaireRepository;
    }
    
    @Override
    public Pret savePret(PretDto pretDto, int idAdherent, int idExemplaire) {
        Pret pret = mapToPret(pretDto);
        Adherent adherent = adherentRepository.findById(idAdherent).get();
        Exemplaire exemplaire = exemplaireRepository.findById(idExemplaire).get();
        pret.setAdherent(adherent);
        pret.setExemplaire(exemplaire);
        pretRepository.save(pret);

        return pret;
    }

    private Pret mapToPret(PretDto pretDto) {
        Pret pret = new Pret();

        pret.setIdPret(pretDto.getIdPret());
        pret.setDatePret(pretDto.getDatePret());
        pret.setDateRemise(pretDto.getDateRemise());

        return pret;
    }

   /*  private PretDto mapToPretDto(Pret pret) {
        PretDto pretDto = new PretDto();

        pretDto.set


    } */

    @Override
    public List<Pret> findAllPrets(){
        List<Pret> prets = pretRepository.findAll();
        return prets;
    }

    @Override
    public List<PretDto>findAllPretsDto(){
        List<Pret> prets = pretRepository.findAll();
        return prets.stream().map(pret-> mapToPretDto(pret)).collect(Collectors.toList());

    }

    private PretDto mapToPretDto(Pret pret){
        PretDto pretDto = new PretDto();

        pretDto.setIdPret(pret.getIdPret());
        pretDto.setIdExemplaire(pret.getExemplaire().getIdExemplaire());
        pretDto.setDatePret(pret.getDatePret());
        pretDto.setDateRemise(pret.getDateRemise());
        pretDto.setExemplaireTitle(pret.getExemplaire().getLivre().getTitre());
        pretDto.setAdherentName(pret.getAdherent().getPrenom()+ " " +pret.getAdherent().getNom());

        return pretDto;
    }

    @Override
    public void delete(int idPret){
        pretRepository.deleteById(idPret);
    }

}   
