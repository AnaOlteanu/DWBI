package com.example.frontenddwbi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "camera_ro")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Camera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_camera")
    private Long idCamera;

    private String nume;
    private Double pret;
    private Integer balcon;

    @ManyToOne
    @JoinColumn(name = "id_tip_camera", nullable = false)
    private TipCamera tipCamera;

    @ManyToOne
    @JoinColumn(name = "id_hotel", nullable = false)
    @ToString.Exclude
    private Hotel hotel;

    @ManyToMany(mappedBy = "camereRezervare", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @ToString.Exclude
    private Set<Rezervare> rezervari = new LinkedHashSet<>();
}
