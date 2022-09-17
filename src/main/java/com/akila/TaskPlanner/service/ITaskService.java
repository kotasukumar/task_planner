package com.akila.TaskPlanner.service;

import com.akila.TaskPlanner.dto.AssignDTO;
import com.akila.TaskPlanner.dto.CreateDTO;
import com.akila.TaskPlanner.dto.SearchDTO;
import com.akila.TaskPlanner.dto.UpdateDTO;
import com.akila.TaskPlanner.model.TaskEntity;

import java.util.List;

public interface ITaskService {

    CreateDTO createTask(CreateDTO createDTO);

    TaskEntity UpdateTask(UpdateDTO updateDTO);

    TaskEntity assignTask(AssignDTO assignDTO);

    SearchDTO searchTask(int taskId, String title);

    List<TaskEntity> getHistory(int taskId, String title);
}
