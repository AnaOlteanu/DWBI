package com.example.warehouse.service;

import com.example.warehouse.dto.*;
import com.example.warehouse.model.DwRezervare;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.text.Format;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface DwRezervareService {

    List<DwRezervare> findAll();
    Page<DwRezervare> findPaginated(Pageable pageable);
    List<FirstQueryDto> firstQuery();
    List<SecondQueryDto> secondQuery() throws ParseException;
    List<ThirdQueryDto> thirdQuery() throws ParseException;
    List<FourthQueryDto> fourthQuery() throws ParseException;
    List<FifthQueryDto> fifthQuery() throws ParseException;
    void populateAdresa();
    void populateHotel();
    void populateCamera();
    void populateClient();
    void populateAngajat();
    void populateDiscount();
    void populateTimp(Date startTime, Date endTime);
    void populateRezervare(Date startTime, Date endTime);


}
