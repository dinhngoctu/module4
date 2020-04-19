package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class UserController {
    @GetMapping("/user")
    public ModelAndView showForm() {
        ModelAndView modelAndView = new ModelAndView("formuser");
        modelAndView.addObject("user",new User());
        modelAndView.addObject("message","Kiểm tra tiếng việt");
        return modelAndView;
    }
    @PostMapping("/validateUser")
    public ModelAndView checkValidation(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            ModelAndView modelAndView = new ModelAndView("formuser");
            System.out.println("thu lai");
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("result");
        System.out.println("thanh cong");
        return modelAndView;
    }

}
