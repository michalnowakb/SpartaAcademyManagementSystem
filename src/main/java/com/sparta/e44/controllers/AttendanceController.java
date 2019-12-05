package com.sparta.e44.controllers;

import com.sparta.e44.entities.AttendanceEntity;
import com.sparta.e44.entities.AttendanceId;
import com.sparta.e44.entities.TeachingGroupEntity;
import com.sparta.e44.entities.TraineeEntity;
import com.sparta.e44.services.AttendanceService;
import com.sparta.e44.services.TeachingGroupService;
import com.sparta.e44.services.TraineeService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes("attendanceMap")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private TraineeService traineeService;

    @Autowired
    private TeachingGroupService teachingGroupService;

    @GetMapping("/attendance/addAttendance/{traineeId}/{date}/{isPresent}/{groupId}")
    public String addAttendance(@PathVariable("traineeId") int traineeId, @PathVariable("date") String date, @PathVariable("isPresent") boolean isPresent, @PathVariable("groupId") int groupId, Model model) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date,dateTimeFormatter);
        attendanceService.addAttendance(traineeId, localDate, isPresent);
        return registerAttendancePage(groupId, date, model);
    }

    @GetMapping("/attendance/viewAttendancePerGroup/{groupId}")
    public String viewAllAttendancePerGroup(@PathVariable("groupId") int groupId, Model model) {

        TeachingGroupEntity teachingGroup = teachingGroupService.getTeachingGroup(groupId);
        model.addAttribute("group", teachingGroup);

        List<LocalDate> dates = new ArrayList<>();
        dates.add(teachingGroup.getStartDate());

//        int dayCount = teachingGroup.getStartDate().until(teachingGroup.getEndDate(),DAYS);
//        int maxWeek = dayCount/7;
//        if(dayCount%7>0){
//            maxWeek++;
//        }
//        if(pageNumber>maxWeek)

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





    public String registerAttendancePage(int groupId, LocalDate date, Model model){
        TeachingGroupEntity teachingGroup = teachingGroupService.getTeachingGroup(groupId);
        model.addAttribute("group",teachingGroup);
        if(date.isBefore(teachingGroup.getStartDate())){
            date = teachingGroup.getStartDate();
        }else if(date.isAfter(teachingGroup.getEndDate())){
            date = teachingGroup.getEndDate();
        }
        model.addAttribute("date",date);
        return "registerAttendancePage";
    }

    @GetMapping("/attendance/registerAttendancePage/{groupId}")
    public String registerAttendancePage(@PathVariable("groupId") int groupId,Model model){
        return registerAttendancePage(groupId,LocalDate.now(),model);
    }

    @GetMapping("/attendance/registerAttendancePage/{groupId}/{date}")
    public String registerAttendancePage(@PathVariable("groupId") int groupId, @PathVariable("date") String date, Model model){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(date,dateTimeFormatter);
        return registerAttendancePage(groupId,localDate,model);
    }



}
