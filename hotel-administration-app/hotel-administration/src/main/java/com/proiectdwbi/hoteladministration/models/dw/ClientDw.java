package com.proiectdwbi.hoteladministration.models.dw;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients_dw", schema = "dwbi_dw_hotel")
public class ClientDw {
    @Id
    private Long id;
}
