package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

@Controller
public class ConvertMoneyController {
    @GetMapping("convert")
    public String getConvert() {

        return "convert";
    }

    @PostMapping("convert")
//    public ModelAndView postConvert(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) {
    public ModelAndView postConvert(@ModelAttribute("sotien") int money) {
        ModelAndView modelAndView = new ModelAndView("convert");
        //        String money1 = request.getParameter("sotien");
        //        modelAndView.addObject("money",Integer.parseInt(money1)*23000);
        if (money >= 0) {
            int money1 = money * 23000;
            modelAndView.addObject("money",money1);
        }
        return modelAndView;
    }

}
