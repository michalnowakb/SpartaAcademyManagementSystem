package com.sparta.e44.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/indexPage")
    public String viewIndexPage() {
        return "indexPage";
    }

    //for the main page

    @GetMapping("/registerCoursePage")
    public String connectToRegisterCoursePage() {
        return "registerCoursePage";
    }

    //Trainer Page
    @GetMapping("/registerTrainerPage")
    public String connectToRegisterTrainerPage() {
        return "registerTrainerPage";
    }

    // Trainee Page
    @GetMapping("/registerTraineePage")
    public String connectToRegisterTraineePage() {
        return "registerTraineePage";
    }
    //Module Page

    @GetMapping("/registerModulePage")
    public String connectToRegisterModulePage() {
        return "registerModulePage";
    }
    //Classroom Page

    @GetMapping("/registerClassroomPage")
    public String connectToRegisterClassroomPage(){
        return "registerClassroomPage";
    }

    @GetMapping("/registerTeachingGroupPage")
    public String connectToRegisterTeachingGroupPage(){
        return "registerTeachingGroupPage";
    }
   }
