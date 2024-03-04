package com.example.warehouse.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dw_camera")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DwCamera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_camera")
    private Long idCamera;

    private String nume;
    private Double pret;
    private Integer balcon;
    private String tipCamera;

    @OneToMany(mappedBy = "camera")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<DwRezervare> rezervari = new ArrayList<>();

}
