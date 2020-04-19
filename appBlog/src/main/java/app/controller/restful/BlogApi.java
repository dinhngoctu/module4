package app.controller.restful;

import app.model.Blog;
import app.model.Category;
import app.service.IBLogService;
import app.service.ICateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = {"/api"})
public class BlogApi {
    @Autowired
    ICateService cateService;
    @Autowired
    IBLogService bLogService;

    @GetMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Category>> listCategory() {
        List<Category> categories = cateService.findAll();
        if (categories == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Category>>(categories, HttpStatus.FOUND);
        }
    }

    @GetMapping(value = "/blogs", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Blog>> listBlog() {
        List<Blog> blogs = bLogService.findAll();
        if (blogs == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogs, HttpStatus.FOUND);
        }
    }

    @GetMapping(value = "/blogsbycategory/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Blog>> listBlogByCategory(@PathVariable int id) {

        List<Blog> blogs = bLogService.findByCategory(id);
        if (blogs == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(blogs, HttpStatus.FOUND);
        }
    }

    @PostMapping(value = "/category/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Category postCategory(@RequestBody List<Category> categories, UriComponentsBuilder ucBuilder) {
//    public ResponseEntity<Void> postCategory(@RequestBody List<HashMap<String,String>> mess, UriComponentsBuilder ucBuilder) {
//        String name = mess.get(0).get("name");
//        System.out.println("name");
        cateService.add(categories.get(0));
        System.out.println("success");
        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/customers/{id}").buildAndExpand(category.getId()).toUri());
        return categories.get(0);
    }
}
