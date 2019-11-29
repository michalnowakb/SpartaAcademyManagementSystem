package com.sparta.e44.controllers;

import com.sparta.e44.entities.CourseEntity;
import com.sparta.e44.services.CourseService;
import com.sparta.e44.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private ModuleService moduleService;

    @GetMapping("/course/getCourses")
    public String getCourses(Model model) {
        model.addAttribute("courses",courseService.getAllCourses());
        return "viewCoursePage";
    }

    @GetMapping("/course/getCourse/{id}")
    public String getCourse(@PathVariable("id") int id,Model model) {
        model.addAttribute("course",courseService.getById(id));
        return "updateCoursePage";
    }

    @PostMapping("/course/addCourse")
    public String addCourse(@Valid CourseEntity newCourse) {
        courseService.addCourse(newCourse);
        return "registerCoursePage+";
    }

    @GetMapping("/course/removeCourse/{id}")
    public String removeCourse(@PathVariable("id") int id) {
        courseService.removeCourse(id);
        return "viewCoursePage";
    }

    @GetMapping("/course/editCourse/{id}")
    public String editCourse(@PathVariable("id") int id, @Valid CourseEntity editCourse) {
        courseService.editCourse(editCourse, id);
        return "viewCoursePage";
    }


    @PostMapping("/course/addModule/{courseId}/{moduleId}")
    public String addModule(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId, Model model){
        courseService.addModule(courseId,moduleId);
        model.addAttribute("course", courseService.getById(courseId));
        model.addAttribute("modules", moduleService.getAll());
        return "/viewCourseModules";
    }

    @GetMapping("/course/removeModule/{courseId}/{moduleId}")
    public String removeModule(@PathVariable("courseId") int courseId, @PathVariable("moduleId") int moduleId, Model model){
        courseService.removeModule(courseId,moduleId);
        model.addAttribute("course", courseService.getById(courseId));
        model.addAttribute("modules", moduleService.getAll());
        return "/viewCourseModules";
    }

    @GetMapping("/course/viewModules/{courseId}")
    public String viewModulePage(@PathVariable("courseId") int courseId, Model model) {
        model.addAttribute("course", courseService.getById(courseId));
        model.addAttribute("modules", moduleService.getAll());
        return "/viewCourseModules";
    }

}
