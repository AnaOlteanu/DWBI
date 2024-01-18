package com.example.frontenddwbi.service;

import com.example.frontenddwbi.model.Hotel;
import com.example.frontenddwbi.model.Oras;
import com.example.frontenddwbi.model.TipHotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HotelService {

    List<Hotel> findAll();

    Page<Hotel> findPaginated(Pageable pageable);

    Hotel save(Hotel hotel);

    List<TipHotel> findAllTipHotel();

    List<Oras> findAllOrase();

}
