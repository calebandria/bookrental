package com.kaleba.bookrental.bookrental.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.kaleba.bookrental.bookrental.dto.LivreDto;
import com.kaleba.bookrental.bookrental.model.Livre;
import com.kaleba.bookrental.bookrental.service.LivreService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LivreController {
    private LivreService livreService;

    public LivreController(LivreService livreService){
        this.livreService = livreService;
    }

    @GetMapping("/livres")
    public String listLivres(Model model) {
        List<LivreDto> livres = livreService.findAllLivresDto();
        model.addAttribute("livres", livres);
        return "livres-list";

    }
    
    @GetMapping("/livres/new")
    public String createLivreForm(Model model) {
        Livre livre = new Livre();
        model.addAttribute("livre", livre);
        return "livres-create";
        
    }

    @PostMapping("/livres/new")
    public String saveLivre(@Valid @ModelAttribute("livre") LivreDto livreDto, BindingResult result, Model model) {
        if (result.hasErrors()){
            /* model.addAttribute("livre", livreDto); */
            return "livres-create";
        }

        livreService.saveLivre(livreDto);
        return "redirect:/livres";
    }
    
    @GetMapping("/livres/{idLivre}/edit")
    public String editLivreForm(@PathVariable("idLivre") int idLivre, Model model) {
        LivreDto livre = livreService.findLivreById(idLivre);
        model.addAttribute("livre", livre);
        return "livres-edit";
    }

    @PostMapping("/livres/{idLivre}/edit")
    public String updateLivre(@PathVariable("idLivre") int idLivre,
                              @Valid @ModelAttribute("livre") LivreDto livre,
                              BindingResult result ) {
        if(result.hasErrors()){
            return "livres-edit";
        }                     
        livre.setIdLivre(idLivre);
        livreService.updateLivre(livre);

        return "redirect:/livres";
    }

    @GetMapping("/livres/{idLivre}/delete")
    public String deleteLivre(@PathVariable("idLivre") int idLivre){
        livreService.delete(idLivre);
        return "redirect:/livres";
    }
    
}
