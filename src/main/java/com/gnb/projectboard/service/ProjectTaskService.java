package com.gnb.projectboard.service;

import com.gnb.projectboard.model.ProjectTask;
import com.gnb.projectboard.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {
    @Autowired
    private ProjectTaskRepository repository;

    public ProjectTask createTask(ProjectTask projectTask){
        return  repository.save(projectTask);
    }

    public Iterable<ProjectTask> getAllProjectTasks(){
        return repository.findAll();
    }

    public ProjectTask getProjectTaskById(long id){
        return repository.findById(id);
    }

    public void deleteProjectTaskById(long id){
         repository.deleteById(id);
    }
}
