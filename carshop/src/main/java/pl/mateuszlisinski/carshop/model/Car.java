package pl.mateuszlisinski.carshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
public class Car {
    private int id;
    private String make;
    private String registration;
    private String description;
    private int year;
    private String color;
    private Date arriveDate;
    private boolean isFixed;

}
