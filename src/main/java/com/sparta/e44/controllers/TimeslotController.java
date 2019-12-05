package com.sparta.e44.controllers;

import com.sparta.e44.entities.ClassroomEntity;
import com.sparta.e44.entities.TeachingGroupEntity;
import com.sparta.e44.entities.TimeslotEntity;
import com.sparta.e44.services.ClassroomService;
import com.sparta.e44.services.TeachingGroupService;
import com.sparta.e44.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TimeslotController {

    @Autowired
    private TimeslotService timeslotService;

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private TeachingGroupService teachingGroupService;

    @GetMapping("/timeslot/getAllTimeslots")
    public String getAllTimeslots(Model model) {
        model.addAttribute("timeslots", timeslotService.getAllTimeslots());
        return "viewSchedulePage";
    }

    @GetMapping("/timeslot/updateTimeslot/{id}")
    public String getAllTimeslots(Model model,@PathVariable("id") int id) {
        TimeslotEntity timeslot =  timeslotService.getById(id);
        List<TeachingGroupEntity> teachingGroups = new ArrayList<>();
        if (teachingGroupService.getAllTeachingGroups()!= null) {
            for (TeachingGroupEntity teachingGroup: teachingGroupService.getAllTeachingGroups()) {
                if(teachingGroup.getGroupId() != timeslot.getGroup().getGroupId()){
                    teachingGroups.add(teachingGroup);
                }
            }
        }

        List<ClassroomEntity> classrooms = new ArrayList<>();
        if(classroomService.getAll()!=null){
            for(ClassroomEntity classroom: classroomService.getAll()){
                if(classroom.getClassroomId() !=  timeslot.getClassroom().getClassroomId()){
                    classrooms.add(classroom);
                }
            }
        }

        model.addAttribute("teachingGroups" ,teachingGroups);
        model.addAttribute("classrooms",classrooms);
        model.addAttribute("timeslot", timeslotService.getById(id));
        return "updateSchedulePage";
    }

    @GetMapping("/timeslot/removeTimeslot/{timeslotId}")
    public String removeTimeslot(@PathVariable("timeslotId") int timeslotId, Model model){
        timeslotService.removeTimeslot(timeslotId);
        return getAllTimeslots(model);
    }

    @PostMapping("/timeslot/addTimeslot")
    public String addEvent(@Valid TimeslotEntity newTimeslot, Model model) {
        timeslotService.addTimeslot(newTimeslot);
        return addTimeSlotPage((model));
    }

    @GetMapping("/timeslot/editTimeslot/{id}")
    public String editTimeslot(@Valid TimeslotEntity editedTimeslot, @PathVariable("id") int id, Model model) {
        timeslotService.editTimeslot(editedTimeslot, id);
        return getAllTimeslots(model);
    }

    @GetMapping("/timeslot/addTimeslotPage")
    public String addTimeSlotPage(Model model) {
        //List of all recorded timeslots
        List<TimeslotEntity> allTimeslots =  timeslotService.getAllTimeslots();

        //Check classrooms in use
        List<ClassroomEntity> availabeClasrooms =  new ArrayList<>();
        List<TeachingGroupEntity> availableGroups = new ArrayList<>();

        for(TeachingGroupEntity group : teachingGroupService.getAllTeachingGroups()){
            boolean isPresent = true;
            for(TimeslotEntity timeslot : allTimeslots){
                if(timeslot.getGroup().getGroupId() == group.getGroupId()){
                    isPresent = false;
                }
                if(isPresent){
                    availableGroups.add(group);
                }
            }
        }

        for(ClassroomEntity classroom : classroomService.getAll()){
            boolean isPresent = true;
            for(TimeslotEntity timeslot : allTimeslots){
                if(timeslot.getClassroom().getClassroomId()== classroom.getClassroomId()){
                    isPresent = false;
                }
                if(isPresent){
                    availabeClasrooms.add(classroom);
                }
            }
        }
        model.addAttribute("classes", availabeClasrooms);
        model.addAttribute("groups", availableGroups);
        return "registerTimeslotPage";
    }


}
