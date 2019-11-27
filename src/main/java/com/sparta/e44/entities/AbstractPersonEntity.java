package com.sparta.e44.entities;

import com.sparta.e44.entities.state.Gender;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
public abstract class AbstractPersonEntity {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String contactNumber;
    private Gender gender;
    private LocalDate startDate;

    public AbstractPersonEntity(int id, String firstName, String lastName, LocalDate dateOfBirth, String email, String contactNumber, Gender gender, LocalDate startDate) {

    }

    public AbstractPersonEntity() {}

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setGender(char gender){
        this.gender = Gender.getGender(gender);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}
