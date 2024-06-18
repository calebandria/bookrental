package com.kaleba.bookrental.bookrental.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.validation.BindingResult;

import com.kaleba.bookrental.bookrental.dto.ExemplaireDto;
import com.kaleba.bookrental.bookrental.dto.LivreDto;
import com.kaleba.bookrental.bookrental.model.Exemplaire;
import com.kaleba.bookrental.bookrental.service.ExemplaireService;
import com.kaleba.bookrental.bookrental.service.LivreService;

import jakarta.validation.Valid;

@Controller
public class ExemplaireController {
    private ExemplaireService exemplaireService;
    private LivreService livreService;

    public ExemplaireController(ExemplaireService exemplaireService, LivreService livreService) {
        this.exemplaireService = exemplaireService;
        this.livreService = livreService;
    }

    /* @GetMapping("/exemplaires")
    public String listExemplaires(Model model) {
        List<ExemplaireDto> exemplaires = exemplaireService.findAll();
        return "exemplaires-list";
    } */

    @GetMapping("/exemplaires/{idLivre}/new")
    public String createExemplaireForm(@PathVariable("idLivre") int idLivre, Model model) {
        Exemplaire examplaire = new Exemplaire();
        model.addAttribute("exemplaire", examplaire);
        model.addAttribute("idLivre", idLivre);
        return "exemplaire-create";
    }

    @PostMapping("/exemplaires/{idLivre}/new")
    public String createExemplaire(@PathVariable("idLivre") int idLivre,@Valid @ModelAttribute("exemplaire") ExemplaireDto exemplaireDto, Model model, BindingResult result){
        if (result.hasErrors()){
            return "exemplaire-create";
        }

        exemplaireService.createExemplaire(idLivre, exemplaireDto);
        return "redirect:/livres";
    }

    @GetMapping("/exemplaires/{idLivre}/view")
    public String listExemplairePerIdLivre(@PathVariable("idLivre") int idLivre, Model model){
        List<ExemplaireDto> exemplaires = exemplaireService.findAllExemplaires(idLivre);
        LivreDto livreCorrespondant = livreService.findLivreById(idLivre);
        String title = livreCorrespondant.getTitre();

        model.addAttribute("exemplaires", exemplaires);
        model.addAttribute("titre", title);
        return "exemplaires-view";
    }

    @GetMapping("/exemplaires/{idExemplaire}/delete")
    public String deleteExemplaire(@PathVariable("idExemplaire") int idExemplaire){
        exemplaireService.deleteExemplaire(idExemplaire);
        return "redirect:/livres";
    }
}
