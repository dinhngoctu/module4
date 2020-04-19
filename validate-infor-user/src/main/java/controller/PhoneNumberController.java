package controller;

import model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ValidatePhoneNumber;



@Controller
public class PhoneNumberController {
    @GetMapping("/")
    public ModelAndView showForm(){
        ModelAndView mv = new ModelAndView("phone");
        mv.addObject("phonenumber", new PhoneNumber());
        return mv;
    }

    @PostMapping("/")
    public ModelAndView checkValidation(@ModelAttribute("phonenumber") PhoneNumber phoneNumber, BindingResult bindingResult) {
        new ValidatePhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            ModelAndView mv = new ModelAndView("phone");
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("result");
            return mv;
        }
    }
}
