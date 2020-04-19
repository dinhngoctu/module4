package app.controller;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class HomeController {
    @GetMapping("/")
    public String getHome(Model model, Pageable pageable) {
        Sort sort = Sort.by("dateCreated").descending();
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(), 3, sort);
        return "home";
    }

}
