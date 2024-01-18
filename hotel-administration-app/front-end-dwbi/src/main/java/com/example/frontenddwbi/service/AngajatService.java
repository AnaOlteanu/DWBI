package com.example.frontenddwbi.service;

import com.example.frontenddwbi.model.Angajat;
import com.example.frontenddwbi.model.Discount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AngajatService {

    List<Angajat> findAll();
    Page<Angajat> findPaginated(Pageable pageable);
}
