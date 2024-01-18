package com.example.frontenddwbi.repository;

import com.example.frontenddwbi.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
