package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.IUserService;

@Controller
public class HomeController {

    private IUserService userService;

    public HomeController(IUserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("users", userService.findAll());
        return "home";
    }
}
