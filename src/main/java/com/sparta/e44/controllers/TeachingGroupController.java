package com.sparta.e44.controllers;

import com.sparta.e44.entities.CourseEntity;
import com.sparta.e44.entities.TeachingGroupEntity;
import com.sparta.e44.services.CourseService;
import com.sparta.e44.services.TeachingGroupService;
import com.sparta.e44.services.TraineeService;
import com.sparta.e44.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@Controller
public class TeachingGroupController {

    @Autowired
    private TeachingGroupService teachingGroupService;

    @Autowired
    private TrainerService trainerService;

    @Autowired
    private TraineeService traineeService;

    @Autowired
    private CourseService courseService;


    @GetMapping("/teachingGroups/getTeachingGroups")
    public String getTeachingGroups(Model model){
       model.addAttribute("teachingGroups" ,teachingGroupService.getAllTeachingGroups());
        return "viewTeachingGroupsPage";
    }

    @GetMapping("/teachingGroup/getTeachingGroup/{id}")
    public String getTeachingGroup(@PathVariable("id") int id, Model model){
        model.addAttribute("teachingGroup",teachingGroupService.getTeachingGroup(id));
        return "viewIndividualTeachingGroup";
    }

    @GetMapping("/teachingGroup/getUpdateTeachingGroup/{id}")
    public String getUpdateTeachingGroup(@PathVariable("id") int id, Model model){
        TeachingGroupEntity teachingGroup = teachingGroupService.getTeachingGroup(id);
        model.addAttribute("teachingGroup", teachingGroup);
        List<CourseEntity> courses = courseService.getAllCourses();
        courses.remove(teachingGroup.getCourse());
        model.addAttribute("courses", courses);
        return "updateTeachingGroupPage";
    }


    @PostMapping("/teachingGroup/addTeachingGroup")
    public String addTeachingGroup(@Valid TeachingGroupEntity teachingGroup){
        teachingGroupService.addTeachingGroup(teachingGroup);
        return "registerTeachingGroupPage";
    }

    @GetMapping("/teachingGroup/editTeachingGroup/{id}")
    public String editTeachingGroup(@PathVariable("id") int id, @Valid TeachingGroupEntity teachingGroup, Model model){
        teachingGroupService.editTeachingGroup(teachingGroup,id);
        model.addAttribute("teachingGroups", teachingGroupService.getAllTeachingGroups());
        return "viewTeachingGroupsPage";
    }

    @GetMapping("/teachingGroup/removeTeachingGroup/{id}")
    public String removeTeachingGroup(@PathVariable("id") int id, Model model){
        teachingGroupService.removeTeachingGroup(id);
        return getTeachingGroups(model);
    }

    //---addClassroom/removeClassroom---//
    @PostMapping("/teachingGroup/addClassroom/{groupId}/{classroomId}")
    public String addClassroom(@PathVariable("groupId") int groupId, @PathVariable("classroomId") int classroomId){
        teachingGroupService.addClassroom(groupId,classroomId);
        return "";
    }

    @GetMapping("/teachingGroup/removeClassroom/{id}")
    public String removeClassroom(@PathVariable("id") int id){
        teachingGroupService.removeClassroom(id);
        return "";
    }

    //---addTrainee/removeTrainee---//
    @PostMapping("/teachingGroup/addTrainee/{groupId}/{traineeId}")
    public String addTrainee(@PathVariable("groupId") int groupId, @PathVariable("traineeId") int traineeId, Model model){
        teachingGroupService.addTrainee(groupId,traineeId);
        return editTraineesPage(groupId,model);
    }

    @GetMapping("/teachingGroup/removeTrainee/{groupId}/{traineeId}")
    public String removeTrainee(@PathVariable("groupId") int groupId, @PathVariable("traineeId") int traineeId, Model model){
        teachingGroupService.removeTrainee(groupId,traineeId);
        return editTraineesPage(groupId,model);
    }

    //---addTrainer/removeTrainer---//
    @PostMapping("/teachingGroup/addTrainer/{groupId}/{trainerId}")
    public String addTrainer(@PathVariable("groupId") int groupId, @PathVariable("trainerId") int trainerId, Model model){
        teachingGroupService.addTrainer(groupId,trainerId);
        return editTrainersPage(groupId,model);
    }

    @GetMapping("/teachingGroup/removeTrainer/{groupId}/{trainerId}")
    public String removeTrainer(@PathVariable("groupId") int groupId, @PathVariable("trainerId") int trainerId, Model model){
        teachingGroupService.removeTrainer(groupId,trainerId);
        return editTrainersPage(groupId,model);
    }
    //---addCourse/removeCourse---//
    @PostMapping("/teachingGroup/addCourse/{groupId}/{courseId}")
    public String addCourse(@PathVariable("groupId") int groupId, @PathVariable("courseId") int courseId, Model model){
        teachingGroupService.addCourse(groupId,courseId);
        return editCoursesPage(groupId,model);
    }

    @GetMapping("/teachingGroup/removeCourse/{groupId}")
    public String removeCourse(@PathVariable("groupId") int groupId, Model model){
        teachingGroupService.removeCourse(groupId);
        return editCoursesPage(groupId,model);
    }

    //--redirect to teachingGroupTrainerEditPage--//

    @GetMapping("/teachingGroup/editTrainers/{groupId}")
    public String editTrainersPage(@PathVariable("groupId") int groupId, Model model){
        model.addAttribute("teachingGroup",teachingGroupService.getTeachingGroup(groupId));
        model.addAttribute("trainers", trainerService.getAll());
        return "updateTeachingGroupTrainers";
    }

    //--redirect to teachingGroupTraineeEditPage--//

    @GetMapping("/teachingGroup/editTrainees/{groupId}")
    public String editTraineesPage(@PathVariable("groupId") int groupId, Model model){
        model.addAttribute("teachingGroup",teachingGroupService.getTeachingGroup(groupId));
        model.addAttribute("trainees", traineeService.getAll());
        return "updateTeachingGroupTrainees";
    }

    //--redirect to teachingGroupCoursesEditPage--//
    @GetMapping("/teachingGroup/editCourses/{groupId}")
    public String editCoursesPage(@PathVariable("groupId") int groupId, Model model){
        model.addAttribute("teachingGroup",teachingGroupService.getTeachingGroup(groupId));
        model.addAttribute("courses", courseService.getAllCourses());
        return "updateTeachingGroupCourses";
    }

    @GetMapping("/teachingGroup/registerNewGroupPage")
    public String registerTeachingGroupPage(Model model){
        model.addAttribute("courses", courseService.getAllCourses());
        return "/registerTeachingGroupPage";
    }
}
