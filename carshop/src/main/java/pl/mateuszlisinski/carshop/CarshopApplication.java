package pl.mateuszlisinski.carshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.mateuszlisinski.carshop.model.Car;
import pl.mateuszlisinski.carshop.service.JsonFileOperations;

import java.util.Date;

@SpringBootApplication
public class CarshopApplication {

	public static void main(String[] args) {
//		Car car = new Car(1,"Renault","123","opis",2001,"black",new Date(System.currentTimeMillis()), false);
//		JsonFileOperations.write(car);
		JsonFileOperations.read();
		SpringApplication.run(CarshopApplication.class, args);
	}

}
