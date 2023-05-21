package com.gnb.projectboard.repository;

import com.gnb.projectboard.model.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask,Long> {

    ProjectTask findById(long id);
}
