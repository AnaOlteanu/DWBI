package com.example.frontenddwbi.service;

import com.example.frontenddwbi.model.Discount;
import com.example.frontenddwbi.model.Rezervare;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DiscountService {

    List<Discount> findAll();
    Page<Discount> findPaginated(Pageable pageable);
    Discount save(Discount rezervare);
}
