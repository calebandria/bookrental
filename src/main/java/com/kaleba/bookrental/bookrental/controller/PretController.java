package com.kaleba.bookrental.bookrental.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation .BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kaleba.bookrental.bookrental.dto.AdherentDto;
import com.kaleba.bookrental.bookrental.dto.ExemplaireDto;
import com.kaleba.bookrental.bookrental.dto.PretDto;
import com.kaleba.bookrental.bookrental.model.Exemplaire;
import com.kaleba.bookrental.bookrental.model.Pret;
import com.kaleba.bookrental.bookrental.service.AdherentService;
import com.kaleba.bookrental.bookrental.service.ExemplaireService;

import com.kaleba.bookrental.bookrental.service.PretService;

import jakarta.validation.Valid;

@Controller
public class PretController {
    private PretService pretService;
    private AdherentService adherentService;
    private ExemplaireService exemplaireService;

    public PretController(PretService pretService, AdherentService adherentService, ExemplaireService exemplaireService) {
        this.pretService = pretService;
        this.adherentService = adherentService;
        this.exemplaireService = exemplaireService;
    }

    @GetMapping("/prets/new")
    public String savePretForm(Model model) {
        List<AdherentDto> adherents = adherentService.findAllAdherentDtos();
        
        model.addAttribute("adherents", adherents);
        return "pret-create-1";
    }

    @GetMapping("/prets/{idAdherent}/new")
    public String chooseExemplaire(@PathVariable int idAdherent, Model model){
        List<ExemplaireDto> exemplaires = exemplaireService.findExemplaireDtoDispo();
        model.addAttribute("exemplaires", exemplaires);
        return "pret-create-2";
    }

    @GetMapping("/prets/{idAdherent}/{idExemplaire}/new")
    public String chooseDates(@Valid @ModelAttribute("pret") PretDto pretDto,@PathVariable("idAdherent") int idAdherent, @PathVariable("idExemplaire") int idExemplaire, Model model, BindingResult result){
        Exemplaire exemplaireUpdate = exemplaireService.findExemplaireById(idExemplaire);
        exemplaireUpdate.setDisponible(false);
        exemplaireService.updateExemplaire(exemplaireUpdate);
        Pret pret = new Pret();
        model.addAttribute("pret", pret);

        return "pret-create";
    }

    @PostMapping("/prets/{idAdherent}/{idExemplaire}/new")
    public String savePret(@Valid @ModelAttribute("pret") PretDto pretDto,@PathVariable("idAdherent") int idAdherent, @PathVariable("idExemplaire") int idExemplaire, Model model, BindingResult result) {
        if(result.hasErrors()){
            return "pret-create-1";
        }
        
        pretService.savePret(pretDto, idAdherent, idExemplaire);
        return "redirect:/prets";
    }

    @GetMapping("/prets")
    public String listPrets(Model model) {
        List<PretDto> prets = pretService.findAllPretsDto();
        model.addAttribute("prets", prets);
        return "prets-list";
    }

    @GetMapping("/prets/{idPret}/{idExemplaire}/delete")
    public String deletePret(@PathVariable("idExemplaire") int idExemplaire, @PathVariable("idPret") int idPret){
        pretService.delete(idPret);
        exemplaireService.updateDisp(idExemplaire);
        
        return "redirect:/prets";
    }

}
