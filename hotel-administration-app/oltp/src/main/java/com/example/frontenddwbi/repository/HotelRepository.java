package com.example.frontenddwbi.repository;

import com.example.frontenddwbi.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
