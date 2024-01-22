package com.example.airplane.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AirbusDto {

    private String airplane;
    private String characteristic;
    private String seat;
    private LocalDate development;
    private LocalDate theFirst;
    private LocalDate firstShipment;
    private String status;
}
