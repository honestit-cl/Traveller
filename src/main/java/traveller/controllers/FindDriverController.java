package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.UserDTO;
import traveller.services.DriverService;

@Controller
@RequestMapping("/find-driver")
public class FindDriverController {

    @Autowired
    DriverService driverService;

    @GetMapping("/all")
    public String findAllDrivers(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                 Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("allDrivers", driverService.findAllDrivers());
        return "all-drivers";
    }
    @GetMapping("/{dto}/{id}")
    public String findAllDriversByDtoId(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                         Model model, @PathVariable String dto, @PathVariable Long id) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        switch(dto) {
            case "tourDTO":
                model.addAttribute("allDrivers", driverService.findAllDriversByTourId(id));
                break;
            case "coachDTO":
                model.addAttribute("allDrivers", driverService.findAllDriversByCoachId(id));
                break;
        }
        return "all-drivers";
    }
}
