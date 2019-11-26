package com.sparta.e44.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CourseController {
    @GetMapping("/courses")
    public String viewCoursePage(){
        return "course/coursePage";
    }

    @GetMapping("/courses/add")
    public String addCoursePage(){
        return "course/registerCoursePage";
    }

}
