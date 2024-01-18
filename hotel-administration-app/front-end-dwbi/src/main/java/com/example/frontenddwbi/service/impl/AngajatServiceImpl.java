package com.example.frontenddwbi.service.impl;

import com.example.frontenddwbi.model.Angajat;
import com.example.frontenddwbi.model.Discount;
import com.example.frontenddwbi.repository.AngajatRepository;
import com.example.frontenddwbi.service.AngajatService;
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
public class AngajatServiceImpl implements AngajatService {

    private final AngajatRepository angajatRepository;


    @Override
    public List<Angajat> findAll() {
        List<Angajat> angajats = new LinkedList<>();
        angajatRepository.findAll(Sort.by("idAngajat")).iterator().forEachRemaining(angajats::add);
        return angajats;
    }

    @Override
    public Page<Angajat> findPaginated(Pageable pageable) {
        List<Angajat> discounts = findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Angajat> list;
        if (discounts.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, discounts.size());
            list = discounts.subList(startItem, toIndex);
        }
        Page<Angajat> discountPage = new PageImpl<>(list, PageRequest.of(currentPage,
                pageSize), discounts.size());
        return discountPage;
    }
}
