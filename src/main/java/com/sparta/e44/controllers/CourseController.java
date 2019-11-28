package com.sparta.e44.controllers;

import com.sparta.e44.entities.CourseEntity;
import com.sparta.e44.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/course")
    public List<CourseEntity> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/course/{id}")
    public CourseEntity getCourse(@PathVariable int id) {
        return courseService.getById(id);
    }

    @PostMapping("/course/newCourse")
    public String addCourse(@RequestBody CourseEntity newCourse) {
        courseService.addCourse(newCourse);
        return "Added course";
    }

    @DeleteMapping("/course/removeCourse/{id}")
    public String removeCourse(@PathVariable int id) {
        courseService.removeCourse(id);
        return "Removed course";
    }

    @PutMapping("/course/updateCourse/{id}")
    public void editCourse(@PathVariable int id, @RequestBody CourseEntity editCourse) {
        courseService.editCourse(editCourse, id);
    }


    @PutMapping("/course/addModule/{courseId}/{moduleId}")
    public CourseEntity addModule(@PathVariable int courseId, @PathVariable int moduleId){
        courseService.addModule(courseId,moduleId);
        return courseService.getById(courseId);
    }

    @PutMapping("/course/removeModule/{courseId}/{moduleId}")
    public CourseEntity removeModule(@PathVariable int courseId, @PathVariable int moduleId){
        courseService.removeModule(courseId,moduleId);
        return courseService.getById(courseId);
    }
}
