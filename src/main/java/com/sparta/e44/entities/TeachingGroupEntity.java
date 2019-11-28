package com.sparta.e44.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class TeachingGroupEntity {

    @Id
    private int groupId;
    private String groupName;


    private int classroomId;

    private LocalDate startDate;

    private LocalDate endDate;

    public TeachingGroupEntity(int groupId, String groupName, int classroomId, LocalDate startDate, LocalDate endDate) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.classroomId = classroomId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TeachingGroupEntity(){}

    @ManyToMany
    @JoinTable(
            name = "group_trainer",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "trainer_id")
    )
    private List<TrainerEntity> trainers;

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "classroom_id")
    private ClassroomEntity classroomEntity;

    public ClassroomEntity getClassroomEntity() {
        return classroomEntity;
    }

    public void setClassroomEntity(ClassroomEntity classroomEntity) {
        this.classroomEntity = classroomEntity;
    }

    public List<TrainerEntity> getTrainers() {
        return trainers;
    }

    public void setTrainers(List<TrainerEntity> trainers) {
        this.trainers = trainers;
    }

    public void addTrainer(TrainerEntity trainer){
        this.trainers.add(trainer);
    }

    public void removeTrainer(TrainerEntity trainer){
        this.trainers.remove(trainer);
    }


    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
