package com.example.warehouse.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ThirdQueryDto {

    Integer id_angajat;
    Date id_data_rezervare;
    Integer venit;
    Integer medie_centrata_o_luna;

}
