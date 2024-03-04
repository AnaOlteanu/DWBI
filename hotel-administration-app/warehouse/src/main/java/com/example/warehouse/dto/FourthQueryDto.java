package com.example.warehouse.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FourthQueryDto {

    private String nume;
    private Date data;
    private Integer valoare;
}
