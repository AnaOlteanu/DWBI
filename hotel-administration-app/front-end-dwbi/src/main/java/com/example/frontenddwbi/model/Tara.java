package com.example.frontenddwbi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tara")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tara {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tara")
    private Long idTara;

    @Column(name = "nume_tara")
    private String numeTara;
}
