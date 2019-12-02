package com.sparta.e44.controllers;

import com.sparta.e44.services.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TimeslotController {

    @Autowired
    private TimeslotService timeslotService;

    @GetMapping("/schedule/getTimeslot")
    public String getTimeslots(Model model) {
        model.addAttribute("timeslots", TimeslotService.getAll());
        return "/viewAllTimeslots";
    }

    @GetMapping("/schedule/removeTimeslot")
    public String removeTimeslot(@PathVariable("id") int id, Model model){
        timeslotService.removeTimeslot(id);
        return getTimeslots(model);
    }

}
