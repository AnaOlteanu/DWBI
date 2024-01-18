package com.proiectdwbi.hoteladministration.models.oltp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "clients", schema = "test2_local")
public class Client {
    @Id
    private Long id;
}
