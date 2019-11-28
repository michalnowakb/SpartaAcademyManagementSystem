package com.sparta.e44.controllers;

import com.sparta.e44.entities.ClassroomEntity;
import com.sparta.e44.services.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ClassroomController {

     @Autowired
     private ClassroomService classroomService;

     @GetMapping("/classroom/getClassrooms")
    public String getClassrooms(Model model){
         model.addAttribute("classrooms",classroomService.getAll());
         return "";
     }

    @GetMapping("/classroom/getClassroom/{id}")
    public String getClassroom(@PathVariable("id") int id, Model model){
         model.addAttribute("classroom",classroomService.getById(id));
         return "";
     }

     @PostMapping("/classroom/addClassroom")
     public String addClassroom(@Valid ClassroomEntity newClassroom){
         classroomService.addClassroom(newClassroom);
         return  "";
     }

     @PutMapping("/classroom/editClassroom/{id}")
    public String editClassroom(@PathVariable("id") int id, @Valid ClassroomEntity editedClassroom){
         classroomService.editClassroom(editedClassroom,id);
         return "";
     }

     @GetMapping("/classroom/removeClassroom/{id}")
    public  String removeClassroom(@PathVariable("id") int id){
         classroomService.removeClassroom(id);
         return "";
     }



}
