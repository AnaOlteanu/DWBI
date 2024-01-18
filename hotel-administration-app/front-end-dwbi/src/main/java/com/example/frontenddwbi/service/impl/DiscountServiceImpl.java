package com.example.frontenddwbi.service.impl;

import com.example.frontenddwbi.model.Discount;
import com.example.frontenddwbi.model.Rezervare;
import com.example.frontenddwbi.repository.DiscountRepository;
import com.example.frontenddwbi.service.DiscountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service("discountService")
@AllArgsConstructor
@Slf4j
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;

    @Override
    public List<Discount> findAll() {
        List<Discount> discounts = new LinkedList<>();
        discountRepository.findAll(Sort.by("idDiscount")).iterator().forEachRemaining(discounts::add);
        return discounts;
    }

    @Override
    public Page<Discount> findPaginated(Pageable pageable) {
        List<Discount> discounts = findAll();
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Discount> list;
        if (discounts.size() < startItem) {
            list = Collections.emptyList();
        } else {
            int toIndex = Math.min(startItem + pageSize, discounts.size());
            list = discounts.subList(startItem, toIndex);
        }
        Page<Discount> discountPage = new PageImpl<>(list, PageRequest.of(currentPage,
                pageSize), discounts.size());
        return discountPage;
    }

    @Override
    public Discount save(Discount rezervare) {
        return discountRepository.save(rezervare);
    }
}
