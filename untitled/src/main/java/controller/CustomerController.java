package controller;


import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public String createView(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/customer/save")
    public String saveCustomer(Customer customer, RedirectAttributes redirect) {
        customer.setId((int) (Math.random() * 1000));
        customerService.save(customer);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}/edit")
    public String editCustomer(@PathVariable int id, Model model) {
        model.addAttribute(customerService.findById(id));
        return "edit";
    }
}
