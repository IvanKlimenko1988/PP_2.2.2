package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.dao.CarDAO;

@Controller
public class CarsController {
    private final CarDAO carDAO;

    @Autowired
    public CarsController(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    @GetMapping("/cars")
    public String showCars(@RequestParam(value = "count", defaultValue = "5")
                           int count, Model model) {
        model.addAttribute("cars", carDAO.showCountCars(count));
        return "cars";
    }

}
