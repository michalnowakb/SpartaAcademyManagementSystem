package com.sparta.e44.controllers.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class AbstractPersonEntity {
    //    @Column
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String contactNumber;
    private char gender;
    private LocalDate startDate;

    public AbstractPersonEntity(int id, String firstName, String lastName, LocalDate dateOfBirth, String email, String contactNumber, char gender, LocalDateTime startDate) {
    }

    public AbstractPersonEntity() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
