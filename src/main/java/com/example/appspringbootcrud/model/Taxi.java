package com.example.appspringbootcrud.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Taxi {

    private Integer id;
    private String carName;
    private String carNumber;
    private String driverName;
    private String driverNumber;
}
