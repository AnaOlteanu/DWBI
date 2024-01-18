package com.example.frontenddwbi.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "plata")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Plata {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_plata")
    private Long idPlata;

    @Column(name = "tip_plata")
    private String tipPlata;

    @Column(name = "suma")
    private Double suma;

    @Column(name = "data")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data;

    @ManyToOne
    @JoinColumn(name = "id_rezervare", nullable = false)
    @ToString.Exclude
    private Rezervare rezervare;


}
