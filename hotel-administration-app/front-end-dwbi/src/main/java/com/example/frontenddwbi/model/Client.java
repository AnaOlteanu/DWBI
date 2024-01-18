package com.example.frontenddwbi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_client")
    private Long idClient;

    private String nume;
    private String prenume;
    private String email;

    @Column(name = "nr_telefon")
    private String nrTelefon;

    @Column(name = "data_nastere")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNastere;

    @OneToMany(mappedBy = "client")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<Rezervare> rezervari = new ArrayList<>();

}
