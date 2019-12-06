package com.sparta.e44.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class ModuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int moduleId;
    private String moduleName;
    private String moduleDescription;


    @ManyToMany(mappedBy = "modules")
    private List<CourseEntity> courses;

    @OneToMany(mappedBy = "gradeId.module")
    private List<GradeEntity> grades;

    @ManyToMany(mappedBy = "qualifiedModules")
    private List<TrainerEntity> trainers;

    public ModuleEntity(){}

    public ModuleEntity(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }


    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }

    public List<TrainerEntity> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<TrainerEntity> trainers) {
        this.trainers = trainers;
    }

    public void addTrainer(TrainerEntity trainer){
        trainers.add(trainer);
    }

    public void removeTrainer(TrainerEntity trainer){
        trainers.remove(trainer);
    }
}
