package com.sparta.e44.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ViewController {

    @RequestMapping("/trainerPage")
    public String connectToTrainerPage(){
        return "trainerPage";
    }

    @RequestMapping("/coursePage")
    public String connectToCoursePage(){
        return "coursePage";
    }

    @RequestMapping("/traineePage")
    public String connectToTraineePage(){
        return "traineePage";
    }
    @RequestMapping("/registerCoursePage")
    public String connectToRegisterCoursePage(){
        return "registerCoursePage";
    }



}
