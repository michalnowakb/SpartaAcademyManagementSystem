package com.sparta.e44.services;

import com.sparta.e44.entities.CourseEntity;
import com.sparta.e44.entities.ModuleEntity;
import com.sparta.e44.repositories.CourseRepository;
import com.sparta.e44.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ModuleRepository moduleRepository;

    public List<CourseEntity> getAllCourses() {
        ArrayList<CourseEntity> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courseEntity -> courses.add(courseEntity));
        return courses;
    }

    public CourseEntity getById(int courseId) {
        return courseRepository.findById(courseId).get();
    }

    public void addCourse(CourseEntity newCourse) {
        courseRepository.save(newCourse);
    }

    public void removeCourse(int id) {
        courseRepository.deleteById(id);
    }

    public CourseEntity editCourse(CourseEntity editEntity, int id) {
        editEntity.setCourseId(id);
        courseRepository.save(editEntity);
        return editEntity;
        
    }

    public void addModule(int courseId, int moduleId) {
        CourseEntity course = courseRepository.findById(courseId).get();
        ModuleEntity module = moduleRepository.findById(moduleId).get();
        course.addModule(module);
        courseRepository.save(course);

    }

    public void removeModule(int courseId, int moduleId) {
        CourseEntity course = courseRepository.findById(courseId).get();
        ModuleEntity module = moduleRepository.findById(moduleId).get();
        course.removeModule(module);
        courseRepository.save(course);
    }
}
