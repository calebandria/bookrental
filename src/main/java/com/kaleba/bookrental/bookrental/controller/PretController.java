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
        Pret pret = new Pret();
        List<ExemplaireDto> exemplaires = exemplaireService.findExemplaireDtoDispo();
        model.addAttribute("pret", pret);
        model.addAttribute("adherents", adherents);
        model.addAttribute("exemplaires", exemplaires);
        return "pret-create";
    }

    @PostMapping("/prets/{idAdherent}/{idExemplaire}/new")
    public String savePret(@Valid @ModelAttribute("pret") PretDto pretDto,@PathVariable("idAdherent") int idAdherent, @PathVariable("idExemplaire") int idExemplaire, Model model, BindingResult result) {
        if(result.hasErrors()){
            return "pret-create";
        }
        
        pretService.savePret(pretDto, idAdherent, idExemplaire);
        return "redirect:/adherents";
    }

}
