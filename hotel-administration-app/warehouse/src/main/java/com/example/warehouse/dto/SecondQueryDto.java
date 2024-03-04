package com.example.warehouse.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecondQueryDto {

    private Date id_timp;
    private Integer venit_zi;
    private Integer venit_pana_la_ziua_curenta;
    private Integer venit_in_ultima_saptamana;
}
