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
        return courseService.getCourse(id);
    }

    @PostMapping("/course/newCourse")
    public String addCourse(@RequestBody CourseEntity newCourse) {
        courseService.addCourse(newCourse);
        return "Added course";
    }

    @DeleteMapping("/course/removeCourse")
    public String removeCourse(@RequestBody CourseEntity removeEntity) {
        courseService.removeCourse(removeEntity);
        return "Removed course";
    }

    @PutMapping("/course/updateCourse/{id}")
    public void editCourse(@PathVariable int id, @RequestBody CourseEntity editCourse) {
        courseService.editCourse(editCourse, id);
    }
}
