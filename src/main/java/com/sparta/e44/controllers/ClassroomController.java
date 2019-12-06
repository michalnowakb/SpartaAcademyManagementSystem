package com.sparta.e44.controllers;

import com.sparta.e44.entities.ClassroomEntity;
import com.sparta.e44.services.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;


    @GetMapping("/classroom/getClassrooms")
    public String getClassrooms(Model model) {
        model.addAttribute("classrooms", classroomService.getAll());
        return "viewClassroomPage";
    }

    @GetMapping("/classroom/getClassrooms/search")
    public String getClassroomsSearch(Model model, @Valid String searchQuery){
        model.addAttribute("classrooms", classroomService.getByName(searchQuery));
        model.addAttribute("searchQuery", searchQuery);
        return "viewClassroomPage";
    }

    @GetMapping("/classroom/getClassroom/{id}")
    public String getClassroom(@PathVariable int id, Model model) {
        model.addAttribute("classroom", classroomService.getById(id));
        return "updateClassroomPage";
    }


    @PostMapping("/classroom/addClassroom")
    public String addClassroom(@Valid ClassroomEntity newClassroom) {
        classroomService.addClassroom(newClassroom);
        return "registerClassroomPage";
    }

    @GetMapping("/classroom/editClassroom/{id}")
    public String editClassroom(@Valid ClassroomEntity editedClassroom, @PathVariable int id, Model model) {
        classroomService.editClassroom(editedClassroom, id);
        model.addAttribute("classrooms", classroomService.getAll());
        return "viewClassroomPage";
    }

    @GetMapping("/classroom/removeClassroom/{id}")
    public String removeClassroom(@PathVariable int id, Model model) {
        classroomService.removeClassroom(id);
        model.addAttribute("classrooms", classroomService.getAll());
        return "viewClassroomPage";
    }
}
