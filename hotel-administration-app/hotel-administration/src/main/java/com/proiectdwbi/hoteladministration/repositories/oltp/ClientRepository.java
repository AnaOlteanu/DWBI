package com.proiectdwbi.hoteladministration.repositories.oltp;

import com.proiectdwbi.hoteladministration.models.oltp.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
