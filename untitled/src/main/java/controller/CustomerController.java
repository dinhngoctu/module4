package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.CustomerService;
import service.CustomerServiceImpl;

import java.util.List;

@Controller
public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();
    @GetMapping("/")
    public String home(Model model) {
        List customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/home";
    }

    @GetMapping("/customer/create")
    public String createView() {
        return "create";
    }
}
