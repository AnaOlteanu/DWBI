package com.example.frontenddwbi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_hotel")
    private Long idHotel;

    private String nume;

    @Column(name = "nr_stele")
    private Integer nrStele;

    private Integer capacitate;

    @ManyToOne
    @JoinColumn(name = "id_tip_hotel", nullable = false)
    private TipHotel tipHotel;

    @ManyToOne
    @JoinColumn(name = "id_oras", nullable = false)
    private Oras oras;

    @OneToMany(mappedBy = "hotel")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<Camera> camere = new ArrayList<>();


}
