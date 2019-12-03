package com.sparta.e44.services;

import com.sparta.e44.entities.TimeslotEntity;
import com.sparta.e44.entities.TraineeEntity;
import com.sparta.e44.repositories.TimeslotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class TimeslotService {

    @Autowired
    private TimeslotRepository timeslotRepository;

    public List<TimeslotEntity> getAllTimeslots(){
        ArrayList<TimeslotEntity> timeslots = new ArrayList<>();
        timeslotRepository.findAll().forEach(t->timeslots.add(t));
        return timeslots;
    }

    public void removeTimeslot(int id){
        timeslotRepository.deleteById(id);
    }

    public void addTimeslot(TimeslotEntity newTimeslot){
        timeslotRepository.save(newTimeslot);
    }

    public TimeslotEntity editTimeslot(TimeslotEntity editedTimeslot, int id){
        editedTimeslot.setTimeslotId(id);
        timeslotRepository.save(editedTimeslot);
        return editedTimeslot;
    }
}
