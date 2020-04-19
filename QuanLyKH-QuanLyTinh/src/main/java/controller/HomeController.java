package controller;

import model.Product;
import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ProductServiceInterFace;
import service.ProvinceServiceInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Controller
public class HomeController {
    @Autowired
    ProductServiceInterFace productService;
    @Autowired
    ProvinceServiceInterface provinceService;

    @ModelAttribute("provinces")
    List<Province> provinces() {
      return provinceService.findAll();
    }
    @GetMapping("/")
    public String getHome(@RequestParam("s") Optional<String> s, Model model, Pageable pageable) {
        Sort sort = Sort.by("name").ascending();
        Pageable pageable1 = PageRequest.of(pageable.getPageNumber(),3,sort);
        if(s.isPresent()){
            model.addAttribute("products", productService.findAllByProvince(new Province(s.get())));
        }else{
        model.addAttribute("products", productService.findAll(pageable1));
    }
        return "home";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        model.addAttribute("product", new Product());
        List<Province> provinces = new ArrayList<>();
        provinces.add(new Province("Ha Noi"));
        provinces.add(new Province("Ho Chi Minh"));
        provinces.add(new Province("Da Nang"));
        model.addAttribute("provinces", provinces);
        return "create";
    }

    @PostMapping("/create")
    public String postCreate(@ModelAttribute("product") Product product, Model model) {
        if (product != null) {
            provinceService.save(product.getProvince());
            productService.save(product);
          model.addAttribute("message", "thềm thành công ");
        }
        return "create";
    }
}
