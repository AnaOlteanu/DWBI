package com.example.warehouse.controller;

import com.example.warehouse.dto.*;
import com.example.warehouse.model.DwRezervare;
import com.example.warehouse.service.DwRezervareService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@Slf4j
public class DwRezervareController {

    private final DwRezervareService dwRezervareService;

    @GetMapping({"/", "/index", "/rezervare/list"})
    public ModelAndView rezervareList(@RequestParam("page") Optional<Integer> page,
                                      @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(15);
        ModelAndView modelAndView = new ModelAndView("rezervari");
        Page<DwRezervare> rezervarePage = dwRezervareService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
        modelAndView.addObject("rezervarePage", rezervarePage);
        return modelAndView;
    }

    @GetMapping("/populareDate")
    public String populareDate(Model model) {
        model.addAttribute("formularTimp", new DataDto());
        model.addAttribute("formularRezervare", new DataDto());
        return "populare";
    }

    @PostMapping("/populareTimp")
    public String saveTimp(@ModelAttribute("formularTimp") DataDto dataDto) {
        dwRezervareService.populateTimp(dataDto.getDataStart(), dataDto.getDataFinal());
        log.info("Successfully populated timp with startDate: {} and endDate: {}", dataDto.getDataStart(), dataDto.getDataFinal());
        return "redirect:/index" ;
    }

    @PostMapping("/populareRezervare")
    public String saveRezervare(@ModelAttribute("formularRezervare") DataDto dataDto) {
        dwRezervareService.populateRezervare(dataDto.getDataStart(), dataDto.getDataFinal());
        log.info("Successfully populated rezervari with startDate: {} and endDate: {}", dataDto.getDataStart(), dataDto.getDataFinal());
        return "redirect:/index" ;
    }

    @PostMapping("/populareAdrese")
    public String saveAdrese() {
        dwRezervareService.populateAdresa();
        log.info("Successfully populated adresa");
        return "redirect:/index" ;
    }

    @PostMapping("/populareHoteluri")
    public String saveHoteluri() {
        dwRezervareService.populateHotel();
        log.info("Successfully populated Hotel");
        return "redirect:/index" ;
    }

    @PostMapping("/populareCamere")
    public String saveCamere() {
        dwRezervareService.populateCamera();
        log.info("Successfully populated Camera");
        return "redirect:/index" ;
    }

    @PostMapping("/populareClienti")
    public String saveClienti() {
        dwRezervareService.populateClient();
        log.info("Successfully populated Client");
        return "redirect:/index" ;
    }

    @PostMapping("/populareAngajati")
    public String saveAngajati() {
        dwRezervareService.populateAngajat();
        log.info("Successfully populated angajat");
        return "redirect:/index" ;
    }

    @PostMapping("/populareDiscount")
    public String saveDiscount() {
        dwRezervareService.populateDiscount();
        log.info("Successfully populated Discount");
        return "redirect:/index" ;
    }

    @GetMapping("/query1")
    public String query1(Model model) {
        Map<String, Integer> graphData = new TreeMap<>();
        List<FirstQueryDto> list = dwRezervareService.firstQuery();
        for (FirstQueryDto item: list) {
            graphData.put(item.getOras(), item.getNr_rezervari());
        }
        model.addAttribute("chartData", graphData);
        return "stats-query1";
    }

    @GetMapping("/query2")
    public String query2(Model model) throws ParseException {
        List<SecondQueryDto> list = dwRezervareService.secondQuery();
        List<List<Object>> dataArray = new ArrayList<>();

        dataArray.add(Arrays.asList("Zi", "Venit zi", "Venit pana la ziua curenta", "Venit in ultima saptamana"));
        for (SecondQueryDto scd:list) {
            dataArray.add(Arrays.asList(beautyDate(scd.getId_timp()), scd.getVenit_zi(), scd.getVenit_pana_la_ziua_curenta(),scd.getVenit_in_ultima_saptamana()));
        }
        model.addAttribute("chartData", dataArray);
        return "stats-query2";
    }

    @GetMapping("/query3")
    public String query3(Model model) throws ParseException {
        List<ThirdQueryDto> list = dwRezervareService.thirdQuery();
        List<List<Object>> dataArray = new ArrayList<>();
        dataArray.add(Arrays.asList("Data", "Venit", "Medie centrata pe o luna"));
        for (ThirdQueryDto tcd:list) {
            dataArray.add(Arrays.asList(beautyDate(tcd.getId_data_rezervare()), tcd.getVenit(),tcd.getMedie_centrata_o_luna()));
        }
        model.addAttribute("chartData", dataArray);
        return "stats-query3";
    }

    @GetMapping("/query4")
    public String query4(Model model) throws ParseException {
        List<FourthQueryDto> list = dwRezervareService.fourthQuery();
        List<List<Object>> dataArray = new ArrayList<>();
        dataArray.add(Arrays.asList("Hotel", "Data", "Incasari"));
        for (FourthQueryDto fcd:list) {
            dataArray.add(Arrays.asList(fcd.getNume(), beautyDate(fcd.getData()),fcd.getValoare()));
        }
        model.addAttribute("chartData", dataArray);
        return "stats-query4";
    }

    @GetMapping("/query5")
    public String query5(Model model) throws ParseException {
        Map<String, Double> graphData = new TreeMap<>();
        List<FifthQueryDto> list = dwRezervareService.fifthQuery();
        for (FifthQueryDto item: list) {
            graphData.put(item.getTip_hotel(), item.getRatio_rep());
        }
        model.addAttribute("chartData", graphData);
        return "stats-query5";
    }

    private String beautyDate(Date data) {
        SimpleDateFormat dayMonthYear = new SimpleDateFormat("dd-MM-yyyy");
        return dayMonthYear.format(data);
    }
}
