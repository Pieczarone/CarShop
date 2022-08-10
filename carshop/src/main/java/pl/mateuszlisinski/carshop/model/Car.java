package pl.mateuszlisinski.carshop.model;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class Car {
    private String make;
    private int year;
    private String color;
    private Date arriveDate;
    private boolean isFixed;
}
