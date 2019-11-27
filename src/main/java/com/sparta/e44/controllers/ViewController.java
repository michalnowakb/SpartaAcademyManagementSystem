package com.sparta.e44.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewController {

    @RequestMapping("/trainerPage")
    public String connectToTrainerPage(){
        return "trainerPage";
    }
}
