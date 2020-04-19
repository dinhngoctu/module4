package app.controller;

import app.model.User;
//import app.model.UserRole;
//import app.service.serviceInterface.IUserRolesService;
import app.service.serviceInterface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Login {
    @Autowired
    IUserService userService;
//    @Autowired
//    IUserRolesService userRolesService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/createuser")
    public ModelAndView getCreateUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult){
            if (!bindingResult.hasFieldErrors()) {
                User user1 = userService.findByName(user.getName());
                if (user1 != null) {
                    ModelAndView modelAndView = new ModelAndView("createuser");
                    modelAndView.addObject("message", "Tên này đã được sử dụng");
                    return modelAndView;
                }
                userService.add(user);
//                userRolesService.add(new UserRole(user,"ROLE_USER"));
                ModelAndView modelAndView = new ModelAndView("login");
                modelAndView.addObject("user", user);
                return modelAndView;
            } else {
                ModelAndView modelAndView = new ModelAndView("createuser");
                return modelAndView;
            }
        }
    @GetMapping("/createuser")
    public String getCreateUser(Model model) {
        model.addAttribute("user", new User());
        return "createuser";
    }
}
