package pl.mateuszlisinski.carshop.service;

import pl.mateuszlisinski.carshop.model.Car;

import java.util.Collections;
import java.util.List;

public class Sort {

    public List<Car> sortDate(List<Car> cars){
        Collections.sort(cars);
        return cars;
    }
}
