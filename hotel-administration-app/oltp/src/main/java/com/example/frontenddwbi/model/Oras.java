package com.example.frontenddwbi.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "oras")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Oras {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_oras")
    private Long idOras;

    @Column(name = "nume_oras")
    private String numeOras;

    @ManyToOne
    @JoinColumn(name = "id_tara", nullable = false)
    private Tara tara;

    @OneToMany(mappedBy = "oras")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ToString.Exclude
    private List<Hotel> hoteluri = new ArrayList<>();

}
