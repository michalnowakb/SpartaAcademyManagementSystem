package com.sparta.e44.controllers;

import com.sparta.e44.entities.TimeslotEntity;
import com.sparta.e44.services.ClassroomService;
import com.sparta.e44.services.TeachingGroupService;
import com.sparta.e44.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TimeslotController {

    @Autowired
    private TimeslotService timeslotService;

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private TeachingGroupService teachingGroupService;

    @GetMapping("/schedule/getAllTimeslots")
    public String getAllTimeslots(Model model) {
        model.addAttribute("timeslots", timeslotService.getAllTimeslots());
        return "viewSchedulePage";
    }

    @GetMapping("/schedule/removeTimeslot")
    public String removeTimeslot(@PathVariable("id") int id, Model model){
        timeslotService.removeTimeslot(id);
        return getAllTimeslots(model);
    }

    @PostMapping("/schedule/addTimeslot")
    public String addEvent(@Valid TimeslotEntity newTimeslot) {
        timeslotService.addTimeslot(newTimeslot);
        return "registerTimeslotPage";
    }

    @GetMapping("/trainee/editTimeslot/{id}")
    public String editTimeslot(@Valid TimeslotEntity editedTimeslot, @PathVariable("id") int id, Model model) {
        timeslotService.editTimeslot(editedTimeslot, id);
        model.addAttribute("timeslots", timeslotService.getAllTimeslots());
        return getAllTimeslots(model);
    }

    @GetMapping("/schedule/addTimeslotPage")
    public String addTimeSlotPage(Model model) {
        model.addAttribute("classes", classroomService.getAll());
        model.addAttribute("groups", teachingGroupService.getAllTeachingGroups());
        return "registerTimeslotPage";
    }


}
