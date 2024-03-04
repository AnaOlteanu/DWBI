package com.example.warehouse.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dw_adresa")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DwAdresa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_adresa")
    private Long idAdresa;

    private String tara;
    private String oras;

    @OneToMany(mappedBy = "adresa")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<DwRezervare> rezervari = new ArrayList<>();


}
