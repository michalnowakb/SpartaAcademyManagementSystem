package com.sparta.e44.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class TimeslotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timeslotID;

    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name="group_id")
    private TeachingGroupEntity group;

    @ManyToOne
    @JoinColumn(name="classroom_id")
    private ClassroomEntity classroom;



}
