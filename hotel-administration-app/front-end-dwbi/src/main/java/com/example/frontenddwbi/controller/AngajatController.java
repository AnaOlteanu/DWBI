package com.example.frontenddwbi.controller;

import com.example.frontenddwbi.model.Angajat;
import com.example.frontenddwbi.model.Discount;
import com.example.frontenddwbi.service.AngajatService;
import com.example.frontenddwbi.service.DiscountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@AllArgsConstructor
@Slf4j
public class AngajatController {

    private final AngajatService angajatService;

    @GetMapping({ "/angajat/list"})
    public ModelAndView discountList(@RequestParam("page") Optional<Integer> page,
                                     @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(15);
        ModelAndView modelAndView = new ModelAndView("angajati");
        Page<Angajat> angajatPage = angajatService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        modelAndView.addObject("angajatPage", angajatPage);
        return modelAndView;
    }
}
