package com.sparta.e44.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/indexPage")
    public String viewIndexPage() {
        return "indexPage";
    }

    //for the main page
    @RequestMapping("/trainerPage")
    public String connectToTrainerPage() {
        return "trainerPage";
    }

    @RequestMapping("/coursePage")
    public String connectToCoursePage() {
        return "coursePage";
    }

    @RequestMapping("/traineePage")
    public String connectToTraineePage() {
        return "traineePage";
    }

    @RequestMapping("/registerCoursePage")
    public String connectToRegisterCoursePage() {
        return "registerCoursePage";
    }

    @RequestMapping("/viewCoursePage")
    public String connectToViewCoursePage() {
        return "viewCoursePage";
    }

    @RequestMapping("/updateCoursePage")
    public String connectToUpdateCoursePage() {
        return "updateCoursePage";
    }

    //Trainer Page
    @RequestMapping("/registerTrainerPage")
    public String connectToRegisterTrainerPage() {
        return "registerTrainerPage";
    }

    @RequestMapping("/viewTrainerPage")
    public String connectToViewTrainerPage() {
        return "viewTrainerPage";
    }

    @RequestMapping("/updateTrainerPage")
    public String connectToUpdateTrainerPage() {
        return "updateTrainerPage";
    }

    // Trainee Page
    @RequestMapping("/registerTraineePage")
    public String connectToRegisterTraineePage() {
        return "registerTraineePage";
    }

    @RequestMapping("/viewTraineePage")
    public String connectToViewTraineePage() {
        return "viewTraineePage";
    }

    @RequestMapping("/updateTraineePage")
    public String connectToUpdateTraineePage() {
        return "updateTraineePage";
    }

    //Module Page
    @RequestMapping("/registerModulePage")
    public String connectToRegisterModulePage() {
        return "registerModulePage";
    }
    //Classroom Page
    @RequestMapping("/registerClassroomPage")
    public String connectToRegisterClassroomPage(){
        return "registerClassroomPage";
    }
    @RequestMapping("/registerTeachingGroupPage")
    public String connectToRegisterTeachingGroupPage(){
        return "registerTeachingGroupPage";
    }
    @RequestMapping("/viewTeachingGroupsPage")
    public String connectToViewTeachingGroupsPage() {
        return "viewTeachingGroupsPage";
    }

    @RequestMapping("/viewSchedulePage")
    public String connectToViewSchedulePage() {
        return "viewSchedulePage";
    }

}
