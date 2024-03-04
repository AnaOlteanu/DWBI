package com.example.warehouse.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataDto {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataFinal;

}
