package app.controller.restful;


import app.model.QuizForm;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = {"/api"})
public class CreateQuizResFul {
    @ResponseBody
    @PostMapping(value = "/quiz/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public QuizForm postQuizForm(@RequestBody QuizForm quizForm, UriComponentsBuilder ucBuilder) {
        System.out.println(quizForm.getAnswer().get(0));
        return quizForm;
    }
}
