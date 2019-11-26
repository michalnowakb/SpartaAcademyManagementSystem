package com.sparta.e44.controllers;

import com.sparta.e44.entities.TraineeEntity;
import com.sparta.e44.services.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TraineeController {

    @Autowired
    private TraineeService traineeService;

    @GetMapping("/trainees")
    public List<TraineeEntity> getTrainees(){
        return traineeService.getAll();
    }

    @GetMapping("/trainee/{id}")
    public TraineeEntity getTrainee(@PathVariable int id){
        return traineeService.getById(id);
    }


    @PostMapping("/newTrainee")
    public String addTrainee(@RequestBody TraineeEntity newTrainee){
        traineeService.addTrainee(newTrainee);
        return "Added trainee";
    }
}
