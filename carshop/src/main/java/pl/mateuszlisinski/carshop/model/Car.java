package pl.mateuszlisinski.carshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
public class Car implements Comparable<Car>{

    private UUID id;
    @Size(min = 3,max = 50, message = "Make must be between 3 and 50 characters!")
    private String make;
    @Size(min = 5, max = 8, message = "Registration must be between 5 and 8 characters!")
    private String registration;
    @Size(min = 5, max = 200, message = "Description must be between 5 and 200 characters!")
    private String description;
    private int year;
    @Size(min = 2, max = 30, message = "Color must be between 2 and 30 characters!")
    private String color;
    @NotNull(message = "Date can't be empty!")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && isFixed == car.isFixed && Objects.equals(id, car.id) && Objects.equals(make, car.make) && Objects.equals(registration, car.registration) && Objects.equals(description, car.description) && Objects.equals(color, car.color) && Objects.equals(arriveDate, car.arriveDate);
    }

    @Override
    public int compareTo(Car car){
        return arriveDate.compareTo(car.arriveDate);
    }

}
