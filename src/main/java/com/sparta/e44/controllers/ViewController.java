package com.sparta.e44.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/trainerPage")
    public String connectToTrainerPage(){
        return "trainerPage";
    }

    @RequestMapping("/registerCoursePage")
    public String connectToRegisterCoursePage(){
        return "registerCoursePage";
    }

}
