package com.sparta.e44.controllers;

import com.sparta.e44.entities.ModuleEntity;
import com.sparta.e44.services.ModuleService;
import com.sparta.e44.services.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class ModuleController {
    @Autowired
    private ModuleService moduleService;
    @Autowired
    private TrainerService trainerService;

    @GetMapping("/module/getModules")
    public String getModules(Model model) {
        model.addAttribute("modules", moduleService.getAll());
        return "/viewModulePage";
    }

    @GetMapping("/module/getModule/{id}")
    public String getModule(@PathVariable("id") int id, Model model) {
        model.addAttribute("module", moduleService.getById(id));
        return "/updateModulePage";
    }


    @PostMapping("/module/addModule")
    public String addModule(@Valid ModuleEntity newModule, Model model) {
        moduleService.addModule(newModule);
        return "registerModulePage";
    }

    @GetMapping("/module/editModule/{id}")
    public String editModule(@Valid ModuleEntity editedModule, @PathVariable("id") int id) {
        moduleService.editModule(editedModule, id);
        return "";
    }

    @GetMapping("/module/removeModule/{id}")
    public String removeModule(@PathVariable("id") int id,Model model) {
        moduleService.removeModule(id);
        return getModules(model);
    }

    @GetMapping("/module/viewTrainers/{moduleId}")
    public String viewTrainers(@PathVariable("moduleId") int moduleId, Model model ){
        model.addAttribute("trainers", trainerService.getAll());
        model.addAttribute("module",moduleService.getById(moduleId));
        return "viewModuleTrainers";
    }

    @GetMapping("/module/addTrainer/{moduleId}/{trainerId}")
    public String addModuleTrainer(@PathVariable("moduleId") int moduleId, @PathVariable("trainerId") int trainerId, Model model){
        trainerService.addQualifiedModule(trainerId, moduleId);
        model.addAttribute("trainers", trainerService.getAll());
        model.addAttribute("module",moduleService.getById(moduleId));
        return "viewModuleTrainers";
    }

    @GetMapping("/module/removeTrainer/{moduleId}/{trainerId}")
    public String removeModuleTrainer(@PathVariable("moduleId") int moduleId, @PathVariable("trainerId") int trainerId, Model model){
        trainerService.removeQualifiedModule(trainerId, moduleId);
        model.addAttribute("trainers", trainerService.getAll());
        model.addAttribute("module",moduleService.getById(moduleId));
        return "viewModuleTrainers";
    }
}
