package epmaapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import epmaapi.models.courses_model;

@RestController
public class CourseController {

    @GetMapping("/courses")
    public String getCourses(){
           courses_model model = new courses_model();

        return model.check_api_key_exist("");

    }

}