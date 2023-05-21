package com.gnb.projectboard.controller;

import com.gnb.projectboard.model.ProjectTask;
import com.gnb.projectboard.service.ProjectTaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectTaskController {
    @Autowired
    private ProjectTaskService service;

    @PostMapping("")
    public ResponseEntity<?> createProjectTask(@Valid @RequestBody ProjectTask projectTask,
                                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(service.createTask(projectTask), HttpStatus.CREATED);
    }

    @GetMapping
    public Iterable<ProjectTask> getAllProjectTasks() {
        return service.getAllProjectTasks();
    }

    @GetMapping("{projectTaskID}")
    public ResponseEntity<?> getProjectTaskById(@PathVariable long projectTaskID) {
        return new ResponseEntity<ProjectTask>(service.getProjectTaskById(projectTaskID), HttpStatus.OK);
    }
    @DeleteMapping("{projectTaskID}")
    public ResponseEntity<?> deleteProjectTask(@PathVariable long projectTaskID){
        service.deleteProjectTaskById(projectTaskID);
        return new ResponseEntity<>("Project Task deleted",HttpStatus.OK);
    }

}
