package com.sparta.e44.controllers;

import com.sparta.e44.entities.ModuleEntity;
import com.sparta.e44.entities.TraineeEntity;
import com.sparta.e44.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping("/module/getModules")
    public List<ModuleEntity> getModules(){
        return moduleService.getAll();
    }

    @GetMapping("/module/getModule/{id}")
    public ModuleEntity getModule(@PathVariable int id){
        return moduleService.getById(id);
    }


    @PostMapping("/module/addModule")
    public String addModule(@RequestBody ModuleEntity newModule){
        moduleService.addModule(newModule);
        return "Added module";
    }

    @PutMapping("/module/editModule/{id}")
    public ModuleEntity editModule(@RequestBody ModuleEntity editedModule, @PathVariable int id){
        moduleService.editModule(editedModule,id);
        return moduleService.getById(id);
    }

    @DeleteMapping("/module/removeModule/{id}")
    public void removeModule(@PathVariable int id){
        moduleService.removeModule(id);
    }

}
