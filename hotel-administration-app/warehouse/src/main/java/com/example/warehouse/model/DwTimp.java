package com.example.warehouse.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "dw_timp")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DwTimp {

    @Id
    @DateTimeFormat(pattern = "DD-MON-YYYY")
    @Column(name = "id_timp")
    private Date idTimp;

    private Integer an;
    private String trimestru;
    private String luna;
    private String saptamana;
    private String zi;

}
