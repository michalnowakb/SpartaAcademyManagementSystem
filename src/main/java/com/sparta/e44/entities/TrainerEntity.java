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
    private String specialization;
    private String employmentType;

    public TrainerEntity() {
    }

    public TrainerEntity(int id, String firstName, String lastName, LocalDate dateOfBirth, String email, String contactNumber,
                         Gender gender, LocalDate startDate, String specialization, String employmentType) {
        super(id, firstName, lastName, dateOfBirth, email, contactNumber, gender, startDate);
        this.specialization = specialization;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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
}
