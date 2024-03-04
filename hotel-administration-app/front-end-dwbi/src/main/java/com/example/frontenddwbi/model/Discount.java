package com.example.frontenddwbi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "discount")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_discount")
    private Long idDiscount;

    @Column(name = "denumire")
    private String denumire;

    @Column(name = "procent")
    private Integer procent;

    @Column(name = "data_start")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataStart;

    @Column(name = "data_final")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataFinal;

    @OneToMany(mappedBy = "discount")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<Rezervare> rezervari = new ArrayList<>();

    public String beautyDate(Date data) {
        SimpleDateFormat dayMonthYear = new SimpleDateFormat("dd-MM-yyyy");
        return dayMonthYear.format(data);
    }

}
