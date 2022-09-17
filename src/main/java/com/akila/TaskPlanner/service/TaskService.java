package com.akila.TaskPlanner.service;

import com.akila.TaskPlanner.dto.AssignDTO;
import com.akila.TaskPlanner.dto.CreateDTO;
import com.akila.TaskPlanner.dto.SearchDTO;
import com.akila.TaskPlanner.dto.UpdateDTO;
import com.akila.TaskPlanner.model.TaskEntity;
import com.akila.TaskPlanner.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public CreateDTO createTask(CreateDTO createDTO) {
        TaskEntity taskEntity = TaskEntity.Build(0, createDTO.taskId, createDTO.title, createDTO.description, createDTO.createdBy, createDTO.createdOn, null, null, null);
        TaskEntity task = taskRepository.save(taskEntity);
        CreateDTO createDTO1 = CreateDTO.Build(task.getTaskId(), task.getTitle(), task.getDescription(), task.getCreatedBy(), task.getCreatedOn());
        return createDTO1;
    }

    @Override
    public TaskEntity UpdateTask(UpdateDTO updateDTO) {
        TaskEntity taskEntity = TaskEntity.Build(0, updateDTO.taskId, updateDTO.title, updateDTO.description, updateDTO.createdBy, updateDTO.createdOn, null, updateDTO.createdOn, updateDTO.status);
        return taskRepository.save(taskEntity);
    }

    @Override
    public TaskEntity assignTask(AssignDTO assignDTO) {
        TaskEntity taskEntity = TaskEntity.Build(0, assignDTO.taskId, assignDTO.title, assignDTO.description, assignDTO.createdBy, assignDTO.createdOn, assignDTO.assignedTo, assignDTO.completedOn, assignDTO.status);
        return taskRepository.save(taskEntity);
    }

    @Override
    public SearchDTO searchTask(int taskId, String title) {
        TaskEntity taskEntity = taskRepository.getSearchResult(taskId, title);
        SearchDTO searchDTO = SearchDTO.Build(taskEntity.getTaskId(), taskEntity.getTitle(), taskEntity.getDescription(), taskEntity.getCreatedBy(), taskEntity.getCreatedOn());
        return searchDTO;

    }

    @Override
    public List<TaskEntity> getHistory(int taskId, String title) {
        return taskRepository.getHistory(taskId, title);
    }
}
