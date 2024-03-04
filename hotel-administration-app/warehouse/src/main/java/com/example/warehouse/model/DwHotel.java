package com.example.warehouse.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dw_hotel")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DwHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_hotel")
    private Long idHotel;

    private String nume;

    @Column(name = "nr_stele")
    private Integer nrStele;

    private Integer capacitate;

    @Column(name = "tip_hotel")
    private String tipHotel;

    @OneToMany(mappedBy = "hotel")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<DwRezervare> rezervari = new ArrayList<>();


}
