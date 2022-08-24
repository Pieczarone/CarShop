package pl.mateuszlisinski.carshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarController {

    @GetMapping(value = "/")
    public String getIndex(Model model){
        return "index";
    }
}
