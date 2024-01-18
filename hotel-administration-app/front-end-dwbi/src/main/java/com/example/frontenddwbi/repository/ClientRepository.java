package com.example.frontenddwbi.repository;

import com.example.frontenddwbi.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
