package traveller.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import traveller.dtos.CustomerDTO;
import traveller.dtos.UserDTO;
import traveller.services.CustomerService;
import javax.validation.Valid;

@Controller
@RequestMapping("/add-customer")
public class AddCustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public String addCustomer(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser, Model model) {

        if(loggedUser == null) {
            return "redirect:/home";
        }
        model.addAttribute("customerForm", new CustomerDTO());
        return "add-customer";
    }
    @PostMapping
    public String addCustomer(@SessionAttribute(value = "loggedUser", required = false) UserDTO loggedUser,
                              @ModelAttribute("customerForm") @Valid CustomerDTO form, BindingResult result) {
        if(loggedUser == null) {
            return "redirect:/home";
        }
        if(result.hasErrors()) {
            return "add-customer";
        }
        customerService.addCustomer(form);
        return "redirect:/home";
    }
}
