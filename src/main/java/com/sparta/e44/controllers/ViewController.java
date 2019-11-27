package com.sparta.e44.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ViewController {

    //for the main page
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
    //Course page
    @RequestMapping("/registerCoursePage")
    public String connectToRegisterCoursePage(){
        return "registerCoursePage";
    }
    @RequestMapping("/viewCoursePage")
    public String connectToViewCoursePage(){
        return "viewCoursePage";
    }
    @RequestMapping("/updateCoursePage")
    public String connectToUpdateCoursePage(){
        return "updateCoursePage";
    }
    //Trainer Page
    @RequestMapping("/registerTrainerPage")
    public String connectToRegisterTrainerPage(){
        return "registerTrainerPage";
    }
    @RequestMapping("/viewTrainerPage")
    public String connectToViewTrainerPage(){
        return "viewTrainerPage";
    }
    @RequestMapping("/updateTrainerPage")
    public String connectToUpdateTrainerPage(){
        return "updateTrainerPage";
    }
    // Trainee Page
    @RequestMapping("/registerTraineePage")
    public String connectToRegisterTraineePage(){
        return "registerTraineePage";
    }
    @RequestMapping("/viewTraineePage")
    public String connectToViewTraineePage(){
        return "viewTraineePage";
    }
    @RequestMapping("/updateTraineePage")
    public String connectToUpdateTraineePage(){
        return "updateTraineePage";
    }
}
