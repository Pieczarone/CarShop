package pl.mateuszlisinski.carshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.mateuszlisinski.carshop.model.Car;
import pl.mateuszlisinski.carshop.service.JsonFileOperations;

import java.util.UUID;

@Controller
public class CarController {
    private static JsonFileOperations json = new JsonFileOperations();
    @GetMapping(value = "/")
    public String getIndex(Model model){
        return "index";
    }

    @GetMapping("/carform")
    public String carForm(Model model){
        model.addAttribute("car", new Car());
        return "carform";
    }

    @PostMapping("/carform")
    public String carSubmit(@ModelAttribute Car car, Model model) {
        model.addAttribute("car", car);
//        car.setId(UUID.randomUUID());
        json.write(car);
        return "result";
    }
}
