package com.example.frontenddwbi.service.impl;

import com.example.frontenddwbi.model.Hotel;
import com.example.frontenddwbi.model.Hotel;
import com.example.frontenddwbi.model.Oras;
import com.example.frontenddwbi.model.TipHotel;
import com.example.frontenddwbi.repository.HotelRepository;
import com.example.frontenddwbi.repository.OrasRepository;
import com.example.frontenddwbi.repository.TipHotelRepository;
import com.example.frontenddwbi.service.HotelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    private final TipHotelRepository tipHotelRepository;

    private final OrasRepository orasRepository;

    @Override
    public List<Hotel> findAll() {
        List<Hotel> hotels = new LinkedList<>();
        hotelRepository.findAll(Sort.by("idHotel")).iterator().forEachRemaining(hotels::add);
        return hotels;
    }

    @Override
    public Page<Hotel> findPaginated(Pageable pageable) {
        List<Hotel> hotels = findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Hotel> list;
        if (hotels.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, hotels.size());
            list = hotels.subList(startItem, toIndex);
        }
        Page<Hotel> hotelPage = new PageImpl<>(list, PageRequest.of(currentPage,
                pageSize), hotels.size());
        return hotelPage;
    }

    @Override
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<TipHotel> findAllTipHotel() {
        return tipHotelRepository.findAll();
    }

    @Override
    public List<Oras> findAllOrase() {
        return orasRepository.findAll();
    }
}
