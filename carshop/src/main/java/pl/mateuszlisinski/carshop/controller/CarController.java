package pl.mateuszlisinski.carshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.mateuszlisinski.carshop.model.Car;
import pl.mateuszlisinski.carshop.service.DatabaseOperations;
import pl.mateuszlisinski.carshop.service.JsonFileOperations;
import pl.mateuszlisinski.carshop.service.Sort;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Calendar;

@Controller
public class CarController {
    private static DatabaseOperations db = new DatabaseOperations();
    private static JsonFileOperations json = new JsonFileOperations();
    private static Sort sort = new Sort();

    @GetMapping("/carform")
    public String carForm(Model model){
        model.addAttribute("currentDate", LocalDate.now());
        model.addAttribute("currentYear", Calendar.getInstance().get(Calendar.YEAR));
        model.addAttribute("car", new Car());
        return "carform";
    }

    @PostMapping("/carform")
    public String carSubmit(@Valid @ModelAttribute("car") Car car, BindingResult result , Model model) {
        if (result.hasErrors()) {
            return "carform";
        }
        model.addAttribute("car", car);
        db.addCar(car);
        return "result";
    }

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String listCars (Model model){
        model.addAttribute("cars", sort.sortDate(db.getCars()));
        return "cars";
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public String carFix(@ModelAttribute Car car, Model model) {
        model.addAttribute("car", car);
        db.fixCar(car.getId());
        return "success";
    }

    @RequestMapping(value = "/carsdelete", method = RequestMethod.POST)
    public String carDelete(@ModelAttribute Car car, Model model) {
        model.addAttribute("car", car);
        db.deleteCar(car.getId());
        return "success";
    }

    @RequestMapping("/carsnotfixed")
    public String listNonFixedCars (Model model){
        model.addAttribute("cars", sort.sortDate(db.getNotFixedCars()));
        return "carsnotfixed";
    }

    @PostMapping("search")
    public String search(@RequestParam("keyword")String keyword, Model model){
        model.addAttribute("cars", db.searchCars(keyword));
        return "cars";
    }
}
