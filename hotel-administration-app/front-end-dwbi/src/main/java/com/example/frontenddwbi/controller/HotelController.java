package com.example.frontenddwbi.controller;

import com.example.frontenddwbi.model.Hotel;
import com.example.frontenddwbi.model.Hotel;
import com.example.frontenddwbi.service.HotelService;
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

import java.util.Optional;

@Controller
@AllArgsConstructor
@Slf4j
public class HotelController {

    private final HotelService hotelService;

    @GetMapping({ "/hotel/list"})
    public ModelAndView hotelList(@RequestParam("page") Optional<Integer> page,
                                     @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(15);
        ModelAndView modelAndView = new ModelAndView("hoteluri");
        Page<Hotel> hotelPage = hotelService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        modelAndView.addObject("hotelPage", hotelPage);
        return modelAndView;
    }

    @GetMapping("/hotel/add")
    public String newHotel(Model model) {
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("tipuriHotel", hotelService.findAllTipHotel());
        model.addAttribute("orase", hotelService.findAllOrase());
        return "hotel-form";
    }

    @PostMapping("/hotel")
    @Transactional
    public String save(@Valid @ModelAttribute("hotel") Hotel hotel,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "hotel-form";
        }
        Hotel savedHotel = hotelService.save(hotel);

        log.info("Successfully added blog with id {} by user {}", savedHotel.getIdHotel());
        return "redirect:/hotel/list" ;
    }
}
