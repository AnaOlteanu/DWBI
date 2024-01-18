package com.example.frontenddwbi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tip_camera")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipCamera {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tip_camera")
    private Long idTipCamera;

    @Column(name = "nume_tip_camera")
    private String numeTipCamera;

    private Integer capacitate;
}
