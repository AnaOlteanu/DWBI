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
@Table(name = "dw_angajat")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DwAngajat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_angajat")
    private Long idAngajat;

    private String nume;
    private String prenume;

    @Column(name = "nr_telefon")
    private String nrTelefon;

    @Column(name = "data_angajare")
    @DateTimeFormat(pattern = "DD-MON-YYYY")
    private Date dataAngajare;

    private Integer salariu;

    @OneToMany(mappedBy = "angajat")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<DwRezervare> rezervari = new ArrayList<>();

}
