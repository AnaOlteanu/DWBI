package com.example.frontenddwbi.controller;

import com.example.frontenddwbi.model.*;
import com.example.frontenddwbi.repository.DiscountRepository;
import com.example.frontenddwbi.service.DiscountService;
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
public class DiscountController {

    private final DiscountService discountService;

    @GetMapping({ "/discount/list"})
    public ModelAndView discountList(@RequestParam("page") Optional<Integer> page,
                                      @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(15);
        ModelAndView modelAndView = new ModelAndView("discounturi");
        Page<Discount> discountPage = discountService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        modelAndView.addObject("discountPage", discountPage);
        return modelAndView;
    }

    @GetMapping("/discount/add")
    public String newDiscount(Model model) {
        model.addAttribute("discount", new Discount());
        return "discount-form";
    }

    @PostMapping("/discount")
    @Transactional
    public String save(@Valid @ModelAttribute("discount") Discount discount,
                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "discount-form";
        }
        Discount savedDiscount = discountService.save(discount);

        log.info("Successfully added blog with id {} by user {}", savedDiscount.getIdDiscount());
        return "redirect:/discount/list" ;
    }

}
