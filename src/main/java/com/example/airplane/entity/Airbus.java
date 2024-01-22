package com.example.airplane.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Airbus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int no;
    private String airplane;
    private String characteristic;
    private String seat;
    private LocalDate development;
    private LocalDate theFirst;
    private LocalDate firstShipment;
    private String status;
}
