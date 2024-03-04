package com.example.warehouse.service.impl;

import com.example.warehouse.dto.*;
import com.example.warehouse.model.DwRezervare;
import com.example.warehouse.repository.DwRezervareRepository;
import com.example.warehouse.service.DwRezervareService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("dwRezervareService")
@AllArgsConstructor
@Slf4j
public class DwRezervareServiceImpl implements DwRezervareService {

    private final DwRezervareRepository dwRezervareRepository;

    @Override
    public List<DwRezervare> findAll() {
        return dwRezervareRepository.findAll();
    }

    @Override
    public Page<DwRezervare> findPaginated(Pageable pageable) {
        List<DwRezervare> rezervari = findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<DwRezervare> list;
        if (rezervari.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, rezervari.size());
            list = rezervari.subList(startItem, toIndex);
        }
        return new PageImpl<>(list, PageRequest.of(currentPage,
                pageSize), rezervari.size());
    }

    @Override
    public List<FirstQueryDto> firstQuery() {
        List<Object[]> list = dwRezervareRepository.firstQuery();
        List<FirstQueryDto> firstQueryDtos = new ArrayList<>();
        for(Object[] item: list) {
            FirstQueryDto firstQueryDto = new FirstQueryDto();
            firstQueryDto.setD_rank_desc((int) Float.parseFloat(String.valueOf(item[0])));
            firstQueryDto.setOras(String.valueOf(item[1]));
            firstQueryDto.setNr_rezervari((int) Float.parseFloat(String.valueOf(item[2])));
            firstQueryDtos.add(firstQueryDto);
        }
        return firstQueryDtos;
    }

    @Override
    public List<SecondQueryDto> secondQuery() throws ParseException {
        List<Object[]> list = dwRezervareRepository.secondQuery();
        List<SecondQueryDto> secondQueryDtos = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        for(Object[] item: list) {
            SecondQueryDto secondQueryDto = new SecondQueryDto();
            secondQueryDto.setId_timp(format.parse(String.valueOf(item[0])));
            secondQueryDto.setVenit_zi((int) Float.parseFloat(String.valueOf(item[1])));
            secondQueryDto.setVenit_pana_la_ziua_curenta((int) Float.parseFloat(String.valueOf(item[2])));
            secondQueryDto.setVenit_in_ultima_saptamana((int) Float.parseFloat(String.valueOf(item[3])));
            secondQueryDtos.add(secondQueryDto);
        }
        return secondQueryDtos;
    }

    @Override
    public List<ThirdQueryDto> thirdQuery() throws ParseException {
        List<Object[]> list = dwRezervareRepository.thirdQuery();
        List<ThirdQueryDto> thirdQueryDtos = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        for(Object[] item: list) {
            ThirdQueryDto thirdQueryDto = new ThirdQueryDto();
            thirdQueryDto.setId_angajat((int) Float.parseFloat(String.valueOf(item[0])));
            thirdQueryDto.setId_data_rezervare(format.parse(String.valueOf(item[1])));
            thirdQueryDto.setVenit((int) Float.parseFloat(String.valueOf(item[2])));
            thirdQueryDto.setMedie_centrata_o_luna((int) Float.parseFloat(String.valueOf(item[3])));
            thirdQueryDtos.add(thirdQueryDto);
        }
        return thirdQueryDtos;
    }

    @Override
    public List<FourthQueryDto> fourthQuery() throws ParseException {
        List<Object[]> list = dwRezervareRepository.fourthQuery();
        List<FourthQueryDto> fourthQueryDtos = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        for(Object[] item: list) {
            FourthQueryDto fourthQueryDto = new FourthQueryDto();
            fourthQueryDto.setNume(String.valueOf(item[0]));
            fourthQueryDto.setData(format.parse(String.valueOf(item[1])));
            fourthQueryDto.setValoare((int) Float.parseFloat(String.valueOf(item[2])));
            fourthQueryDtos.add(fourthQueryDto);
        }
        return fourthQueryDtos;
    }

    @Override
    public List<FifthQueryDto> fifthQuery() {
        List<Object[]> list = dwRezervareRepository.fifthQuery();
        List<FifthQueryDto> fifthQueryDtos = new ArrayList<>();
        for(Object[] item: list) {
            FifthQueryDto fifthQueryDto = new FifthQueryDto();
            fifthQueryDto.setTip_hotel(String.valueOf(item[0]));
            fifthQueryDto.setRezervari((int) Float.parseFloat(String.valueOf(item[1])));
            fifthQueryDto.setTotal_rezervari((int) Float.parseFloat(String.valueOf(item[2])));
            fifthQueryDto.setRatio_rep(Double.parseDouble(String.valueOf(item[3])));
            fifthQueryDtos.add(fifthQueryDto);
        }
        return fifthQueryDtos;
    }

    @Override
    public void populateAdresa() {
        dwRezervareRepository.populate_adresa();
    }

    @Override
    public void populateHotel() {
        dwRezervareRepository.populate_hotel();
    }

    @Override
    public void populateCamera() {
        dwRezervareRepository.populate_camera();
    }

    @Override
    public void populateClient() {
        dwRezervareRepository.populate_client();
    }

    @Override
    public void populateAngajat() {
        dwRezervareRepository.populate_angajat();
    }

    @Override
    public void populateDiscount() {
        dwRezervareRepository.populate_discount();
    }

    @Override
    public void populateTimp(Date startTime, Date endTime) {
        dwRezervareRepository.populate_timp(startTime, endTime);
    }

    @Override
    public void populateRezervare(Date startTime, Date endTime) {
        dwRezervareRepository.populate_rezervare(startTime, endTime);
    }
}
