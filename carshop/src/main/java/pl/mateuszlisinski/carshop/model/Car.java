package pl.mateuszlisinski.carshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
public class Car {
    private UUID id;
    private String make;
    private String registration;
    private String description;
    private int year;
    private String color;
    private Date arriveDate;
    private boolean isFixed;

    public Car(String make, String registration, String description, int year, String color, Date arriveDate) {
        this.id = UUID.randomUUID();
        this.make = make;
        this.registration = registration;
        this.description = description;
        this.year = year;
        this.color = color;
        this.arriveDate = arriveDate;
        this.isFixed = false;
    }
    public Car(){
        this.id = UUID.randomUUID();
        this.isFixed = false;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", registration='" + registration + '\'' +
                ", description='" + description + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", arriveDate=" + arriveDate +
                ", isFixed=" + isFixed +
                '}';
    }
}
