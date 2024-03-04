package com.example.warehouse.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FifthQueryDto {

    private String tip_hotel;
    private Integer rezervari;
    private Integer total_rezervari;
    private Double ratio_rep;
}
