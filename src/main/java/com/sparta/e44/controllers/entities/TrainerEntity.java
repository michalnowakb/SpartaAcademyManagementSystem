package com.sparta.e44.controllers.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TrainerEntity extends AbstractPersonEntity
{
    private String specialization;
    private String employmentType;

    public TrainerEntity() {}

    public TrainerEntity(int id, String firstName, String lastName, LocalDate dateOfBirth, String email, String contactNumber,
                         char gender, LocalDate startDate, String specialization, String employmentType) {
        super(id, firstName, lastName, dateOfBirth, email, contactNumber, gender, startDate);
        this.specialization = specialization;
        this.employmentType = employmentType;
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
}
