package app.controller;

import app.model.Blog;
import app.model.Category;
import app.model.User;
import app.myutil.MyUtil;
import app.service.IBLogService;
import app.service.ICateService;
import app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
public class CreateController {
    @Autowired
    IUserService userService;
    @Autowired
    IBLogService bLogService;
    @Autowired
    ICateService cateService;

    @GetMapping("/create")
    public String getCreateBlog(Model model) {
        model.addAttribute("blog", new Blog());
        List<Category> categories = cateService.findAll();
        model.addAttribute("categories",categories);
        return "create";
    }
    @GetMapping("/test")
    public String getTest(Model model) {
//        model.addAttribute("blog", new Blog());
        return "index";
    }

    @PostMapping("/create")
    public String postCreatBlog(@ModelAttribute("blog") Blog blog, Model model) {
        blog.setDateCreated(MyUtil.getCurrentDateTime());
        bLogService.add(blog);
        model.addAttribute("blog", blog);
        return "view";
    }

    @GetMapping("/createuser")
    public String getCreateUser(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }

    @PostMapping("/createuser")
    public ModelAndView getCreateUser(@Validated @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (!bindingResult.hasFieldErrors()) {
            User user1 = userService.findByName(user.getName());
            if (user1 != null) {
                ModelAndView modelAndView = new ModelAndView("create-user");
                modelAndView.addObject("message", "Tên này đã được sử dụng");
                return modelAndView;
            }
            userService.add(user);
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("user", user);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("create-user");
            return modelAndView;
        }
    }
}
