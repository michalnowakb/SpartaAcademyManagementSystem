package com.sparta.e44.services;

import com.sparta.e44.entities.CourseEntity;
import com.sparta.e44.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

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
}
