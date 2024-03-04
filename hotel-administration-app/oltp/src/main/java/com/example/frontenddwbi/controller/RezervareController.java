package com.example.frontenddwbi.controller;

import com.example.frontenddwbi.model.*;
import com.example.frontenddwbi.service.RezervareService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@Slf4j
public class RezervareController {

    private final RezervareService rezervareService;


    @GetMapping({"/", "/index", "/rezervare/list"})
    public ModelAndView rezervareList(@RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(15);
        ModelAndView modelAndView = new ModelAndView("rezervari");
        Page<Rezervare> rezervarePage = rezervareService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        modelAndView.addObject("rezervarePage", rezervarePage);
        return modelAndView;
    }

    @GetMapping("/rezervare/add")
    public String newRezervare(Model model) {
        model.addAttribute("rezervare", new Rezervare());
        List<Angajat> totiAngajatii = rezervareService.findAllAngajati();
        List<Discount> toateDiscounturile = rezervareService.findAllDiscount();
        List<Camera> toateCamerele = rezervareService.findAllCamera();
        List<Client> totiClientii = rezervareService.findAllClient();
        model.addAttribute("angajati", totiAngajatii );
        model.addAttribute("discounturi", toateDiscounturile );
        model.addAttribute("camere", toateCamerele );
        model.addAttribute("clienti", totiClientii );
        return "rezervare-form";
    }

    @PostMapping("/rezervare")
    @Transactional
    public String save(@Valid @ModelAttribute("rezervare") Rezervare rezervare,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "rezervare-form";
        }
        rezervare.setDataRezervare(new Date());
        rezervare.setNrCamere(rezervare.getCamereRezervare().size());
        rezervare.setPretTotal(rezervare.getCamereRezervare().stream().map(Camera::getPret).reduce((double) 0, Double::sum));
        Rezervare savedRezervare = rezervareService.save(rezervare);
        rezervareService.updateCameraRezervare(savedRezervare.getIdRezervare());
        log.info("Successfully added blog with id {} by user {}", savedRezervare.getIdRezervare());
        return "redirect:/rezervare/list" ;
    }

}
