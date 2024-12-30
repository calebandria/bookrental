package com.kaleba.bookrental.bookrental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import com.kaleba.bookrental.bookrental.dto.AdherentDto;
import com.kaleba.bookrental.bookrental.model.Adherent;
import com.kaleba.bookrental.bookrental.service.AdherentService;

import jakarta.validation.Valid;

@Controller
public class AdherentController {
    private AdherentService adherentService;

    public AdherentController(AdherentService adherentService) {
        this.adherentService = adherentService;
    }

    @GetMapping("/admin/adherents")
    public String listAdherents(Model model) {
        List<AdherentDto> adherents = adherentService.findAllAdherentDtos();
        model.addAttribute("adherents", adherents);
        return "adherents-list";
    }

    @GetMapping("/admin/adherents/new")
    public String createAdherentForm(Model model) {
        Adherent adherent = new Adherent();
        model.addAttribute("adherent", adherent);
        return "adherents-create";
    }

    @PostMapping("/admin/adherents/new")
    public String saveAdherent(@Valid @ModelAttribute("adherent") AdherentDto adherentDto, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "adherents-create";
        }

        adherentService.saveAdherent(adherentDto);
        return "redirect:/adherents";
    }

    @GetMapping("/admin/adherents/{idAdherent}/edit")
    public String editAdherentForm(@PathVariable("idAdherent") int idAdherent, Model model) {
        AdherentDto adherent = adherentService.findAdherentById(idAdherent);
        model.addAttribute("adherent", adherent);
        return "adherents-edit";
    }

    @PostMapping("/admin/adherents/{idAdherent}/edit")
    public String updateLivre(@PathVariable("idAdherent") int idAdherent,
                              @Valid @ModelAttribute("adherent") AdherentDto adherent,
                              BindingResult result, Model model) {
        if(result.hasErrors()){
            return "adherents-edit";
        }                     
        adherent.setIdAdherent(idAdherent);
        adherentService.updateAdherent(adherent);

        return "redirect:/adherents";
    }

    @GetMapping("/admin/adherents/{idAdherent}/delete")
    public String deleteLivre(@PathVariable("idAdherent") int idAdherent){
        adherentService.delete(idAdherent);
        return "redirect:/adherents";
    }


}
