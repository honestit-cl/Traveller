package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import traveller.dtos.UserDTO;
import traveller.services.ShowAllToursService;

@Controller
@RequestMapping("/show-all-tours")
public class ShowAllToursController {

    @Autowired
    private ShowAllToursService showAllToursService;
    @GetMapping
    public String showAllTours(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                                 Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("allTours", showAllToursService.showAllTours());
        return "all-tours";
    }
}