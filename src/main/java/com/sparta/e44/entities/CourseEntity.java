package com.sparta.e44.entities;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.List;

@Entity
public class CourseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;
    private String courseName;
    private String courseDescription;
    private int durationInWeeks;

    @ManyToMany//(targetEntity = ModuleEntity.class)
    @JoinTable(
            name = "course_modules",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private List<ModuleEntity> modules;


    public CourseEntity() {}

    public CourseEntity(String courseName, String courseDescription, int durationInWeeks) {
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.durationInWeeks = durationInWeeks;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }


    public List<ModuleEntity> getModules() {
        return modules;
    }

    public void setModules(List<ModuleEntity> modules) {
        this.modules = modules;
    }

    public void addModule(ModuleEntity module){
        this.modules.add(module);
    }

    public void removeModule(ModuleEntity module){
        this.modules.remove(module);
    }
}
