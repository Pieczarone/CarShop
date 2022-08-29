package pl.mateuszlisinski.carshop.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import pl.mateuszlisinski.carshop.model.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonFileOperations {


    private static File path = new File("src/main/resources/static/car.json");
    private static ObjectMapper mapper = new ObjectMapper();
    private static TypeReference<List<Car>> typeReference = new TypeReference<List<Car>>() {};

    public JsonFileOperations() {
    }

    public List<Car> readIntoList() {
        List<Car> cars = new ArrayList<Car>();
        try {
            InputStream inputStream = new FileInputStream(path);
            cars = mapper.readValue(inputStream, typeReference);
            inputStream.close();
            return cars;

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (JsonParseException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return cars;
    }
    public void write(Car car){
        try {
            InputStream inputStream = new FileInputStream(path);
            List<Car> cars = mapper.readValue(inputStream, typeReference);
            cars.add(car);
            mapper.writeValue(path, cars);
            inputStream.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (JsonParseException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

