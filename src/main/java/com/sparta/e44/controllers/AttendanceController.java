package com.sparta.e44.controllers;

import com.sparta.e44.entities.AttendanceEntity;
import com.sparta.e44.entities.AttendanceId;
import com.sparta.e44.entities.TeachingGroupEntity;
import com.sparta.e44.entities.TraineeEntity;
import com.sparta.e44.services.AttendanceService;
import com.sparta.e44.services.TeachingGroupService;
import com.sparta.e44.services.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private TraineeService traineeService;

    @Autowired
    private TeachingGroupService teachingGroupService;

    @PostMapping("/attendance/addAttendance/{traineeId}/{date}/{isPresent}")
    public String addAttendance(@PathVariable("traineeId") int traineeId, @PathVariable("date") LocalDate date, @PathVariable("isPresent") boolean isPresent, Model model) {
        attendanceService.addAttendance(traineeId, date, isPresent);
        return viewAttendance(traineeId, model);
    }

    @GetMapping("/attendance/viewAttendancePerGroup/{groupId}")
    public String viewAllAttendancePerGroup(@PathVariable("groupId") int groupId, Model model) {

        TeachingGroupEntity teachingGroup = teachingGroupService.getTeachingGroup(groupId);
        List<TraineeEntity> traineesList = teachingGroup.getTrainees();
        Map<TraineeEntity,List<AttendanceEntity>> traineeAttendances = new HashMap<>();

        for(TraineeEntity trainee : traineesList){
            traineeAttendances.put(trainee,attendanceService.getAttendances(trainee));
        }
        model.addAttribute("group", teachingGroup);
        model.addAttribute("traineeAttendances",traineeAttendances);

        List<LocalDate> dates = new ArrayList<>();
        dates.add(teachingGroup.getStartDate());
        while(dates.get(dates.size()-1).isBefore(teachingGroup.getEndDate())){
            LocalDate holder = dates.get(dates.size()-1);
            dates.add(holder.plusDays(1));
        }



        model.addAttribute("dates",dates);
        return "/viewAllAttendances";
    }

    //--viewIndividualAttendance--//
    @GetMapping("/attendance/viewAttendance/{traineeId}")
    public String viewAttendance(@PathVariable("traineeId") int traineeId, Model model) {
        model.addAttribute("trainee", traineeService.getById(traineeId));
        return "viewIndividualAttendance";
    }

}
