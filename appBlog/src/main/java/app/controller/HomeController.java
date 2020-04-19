package app.controller;

import app.model.Category;
import app.model.User;
import app.service.IBLogService;
import app.service.ICateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    ICateService cateService;
    @Autowired
    IBLogService blogService;

    @GetMapping("/")
    public String getHome(Model model, Pageable pageable) {
        Sort sort = Sort.by("dateCreated").descending();
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), 3, sort);
        model.addAttribute("blogs", blogService.findAllPage(pageable1));
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
    @GetMapping("/user")
    public String user(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @GetMapping("/categorycreate")
    public ModelAndView getFormCategory() {
        ModelAndView modelAndView = new ModelAndView("CreateCategory");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }
}
