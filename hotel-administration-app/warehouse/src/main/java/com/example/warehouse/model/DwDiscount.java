package com.example.warehouse.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dw_discount")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DwDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_discount")
    private Long idDiscount;

    @Column(name = "denumire")
    private String denumire;

    @Column(name = "procent")
    private Integer procent;

    @Column(name = "data_start")
    @DateTimeFormat(pattern = "DD-MON-YYYY")
    private Date dataStart;

    @Column(name = "data_final")
    @DateTimeFormat(pattern = "DD-MON-YYYY")
    private Date dataFinal;

    @OneToMany(mappedBy = "discount")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<DwRezervare> rezervari = new ArrayList<>();


}
