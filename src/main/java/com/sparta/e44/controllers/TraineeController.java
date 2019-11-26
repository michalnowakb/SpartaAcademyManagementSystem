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

    @GetMapping("/trainee/getTrainees")
    public List<TraineeEntity> getTrainees(){
        return traineeService.getAll();
    }

    @GetMapping("/trainee/getTrainee/{id}")
    public TraineeEntity getTrainee(@PathVariable int id){
        return traineeService.getById(id);
    }


    @PostMapping("/trainee/addTrainee")
    public String addTrainee(@RequestBody TraineeEntity newTrainee){
        traineeService.addTrainee(newTrainee);
        return "Added trainee";
    }

    @PutMapping("/trainee/editTrainee/{id}")
    public TraineeEntity editTrainee(@RequestBody TraineeEntity editedTrainee, @PathVariable int id){
        traineeService.editTrainee(editedTrainee,id);
        return traineeService.getById(id);
    }
}
