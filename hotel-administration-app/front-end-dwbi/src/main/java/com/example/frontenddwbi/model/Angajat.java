package com.example.frontenddwbi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "angajat_ro")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Angajat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_angajat")
    private Long idAngajat;

    private String nume;
    private String prenume;

    @OneToMany(mappedBy = "angajat")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<Rezervare> rezervari = new ArrayList<>();
}
