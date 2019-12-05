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
    public String getUpdateTimeslot(Model model,@PathVariable("id") int id) {
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
    public String addEvent(@Valid TimeslotEntity newTimeslot) {
        timeslotService.addTimeslot(newTimeslot);
        return "registerTimeslotPage";
    }

    @GetMapping("/timeslot/editTimeslot/{id}")
    public String editTimeslot(@Valid TimeslotEntity editedTimeslot, @PathVariable("id") int id, Model model) {
        timeslotService.editTimeslot(editedTimeslot, id);
        return getAllTimeslots(model);
    }

    @GetMapping("/timeslot/addTimeslotPage")
    public String addTimeSlotPage(Model model) {
        model.addAttribute("classes", classroomService.getAll());
        model.addAttribute("groups", teachingGroupService.getAllTeachingGroups());
        return "registerTimeslotPage";
    }


}
