package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.DriverDTO;
import traveller.dtos.UserDTO;
import traveller.services.DriverService;
import javax.validation.Valid;

@Controller
@RequestMapping("/add-driver")
public class AddDriverController {

    @Autowired
    DriverService driverService;

    @GetMapping
    public String addCoach(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("driverForm", new DriverDTO());
        return "add-driver";
    }
    @PostMapping
    public String addCoach(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUSer,
                                @ModelAttribute("driverForm") @Valid DriverDTO form, BindingResult result) {

        if(loggedUSer == null) {
            return "redirect:/home";
        }
        if(result.hasErrors()) {
            return "add-driver";
        }
        driverService.addDriver(form);
        return "redirect:/home";
    }
}
