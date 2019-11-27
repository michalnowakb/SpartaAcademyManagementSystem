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
}
