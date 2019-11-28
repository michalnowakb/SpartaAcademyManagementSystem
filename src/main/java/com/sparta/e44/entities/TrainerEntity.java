package com.sparta.e44.entities;

import com.sparta.e44.entities.state.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class TrainerEntity extends AbstractPersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainerId;

    @ManyToMany
    @JoinTable(
            name = "qualified_modules",
            joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private List<ModuleEntity> qualifiedModules;

    private String employmentType;

    public TrainerEntity() {
    }

    public TrainerEntity(int id, String firstName, String lastName, LocalDate dateOfBirth, String email, String contactNumber,
                         Gender gender, LocalDate startDate, List qualifiedModules, String employmentType) {
        super( firstName, lastName, dateOfBirth, email, contactNumber, gender, startDate);
        this.qualifiedModules = qualifiedModules;
        this.employmentType = employmentType;
    }

    @ManyToMany(mappedBy = "trainers")
    private List<TeachingGroupEntity> groups;


    public List<TeachingGroupEntity> getGroups() {
        return groups;
    }

    public void setGroups(List<TeachingGroupEntity> groups) {
        this.groups = groups;
    }

    public List<ModuleEntity> getQualifiedModules() {
        return qualifiedModules;
    }

    public void setQualifiedModules(List<ModuleEntity> qualifiedModules) {
        this.qualifiedModules = qualifiedModules;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }


    public void addModule(ModuleEntity module) {
        this.qualifiedModules.add(module);
    }

    public void removeModule(ModuleEntity module) {
        this.qualifiedModules.remove(module);
    }
}
