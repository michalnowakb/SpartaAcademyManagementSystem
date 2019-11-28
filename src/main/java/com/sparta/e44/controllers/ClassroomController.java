package com.sparta.e44.controllers;

import com.sparta.e44.entities.ClassroomEntity;
import com.sparta.e44.services.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassroomController {

     @Autowired
     private ClassroomService classroomService;

     @GetMapping("/classroom/getClassrooms")
    public List<ClassroomEntity> getClassrooms(){
         return classroomService.getAll();
     }

    @GetMapping("/classroom/getClassroom/{id}")
    public ClassroomEntity getClassroom(@PathVariable int id){
         return classroomService.getById(id);
     }

     @PostMapping("/classroom/addClassroom")
     public String addClassroom(@RequestBody ClassroomEntity newClassroom){
         classroomService.addClassroom(newClassroom);
         return  "Added classroom";
     }

     @PutMapping("/classroom/editClassroom/{id}")
    public ClassroomEntity editClassroom(@RequestBody ClassroomEntity editedClassroom, @PathVariable int id){
         classroomService.editClassroom(editedClassroom,id);
         return classroomService.getById(id);
     }

     @DeleteMapping("/classroom/removeClassroom/{id}")
    public  String removeClassroom(@PathVariable int id){
         classroomService.removeClassroom(id);
         return "Removed classroom";
     }


}
