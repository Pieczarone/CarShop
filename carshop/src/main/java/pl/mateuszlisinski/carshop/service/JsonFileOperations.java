package pl.mateuszlisinski.carshop.service;
package org.codehaus.janino

import ch.qos.logback.core.subst.Token;
import com.google.gson.Gson;
import pl.mateuszlisinski.carshop.model.Car;

import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonFileOperations {
    private static ArrayList<Car> cars = new ArrayList<Car>();
    private static Gson gson = new Gson();

    public static ArrayList<Car> read(){
        try{
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/static/car.json"));
            cars.add(gson.fromJson(reader, new <List<Car>>() {}.getType()));
            System.out.println(cars);
            reader.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return cars;
    }

    public static void write(Car car){
        JsonFileOperations json = new JsonFileOperations();
        cars = json.read();
        cars.add(car);
        try {
            FileWriter writer = new FileWriter("src/main/resources/static/car.json");
            gson.toJson(cars, writer);
            writer.flush();
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
