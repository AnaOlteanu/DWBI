package com.example.frontenddwbi.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "tip_hotel")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tip_hotel")
    private Long idTipHotel;

    @Column(name = "nume_tip")
    private String numeTip;

}
