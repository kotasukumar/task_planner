package com.akila.TaskPlanner.controlller;

import com.akila.TaskPlanner.dto.AssignDTO;
import com.akila.TaskPlanner.dto.CreateDTO;
import com.akila.TaskPlanner.dto.ResponseDTO;
import com.akila.TaskPlanner.dto.UpdateDTO;
import com.akila.TaskPlanner.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private ITaskService iTaskService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createTask(@RequestBody CreateDTO createDTO){
        ResponseDTO responseDTO = ResponseDTO.Build((iTaskService.createTask(createDTO)), "Created successfully");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<ResponseDTO> upadteTask(@RequestBody UpdateDTO updateDTO){
        ResponseDTO responseDTO = ResponseDTO.Build(iTaskService.UpdateTask(updateDTO), "Updated successfully");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping("/assign")
    public ResponseEntity<ResponseDTO> assignTask(AssignDTO assignDTO){
        ResponseDTO responseDTO = ResponseDTO.Build(iTaskService.assignTask(assignDTO), "Assigned successfully");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/search/{taskId}/{title}")
    public ResponseEntity<ResponseDTO> searchTask(@PathVariable int taskId, @PathVariable String title){
        ResponseDTO responseDTO = ResponseDTO.Build(iTaskService.searchTask(taskId, title), "Searching task completed");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/history/{takId}/{title}")
    public ResponseEntity<ResponseDTO> getHistory(@PathVariable int takId, @PathVariable String title){
        ResponseDTO responseDTO = ResponseDTO.Build(iTaskService.getHistory(takId, title), "History of given task is fetched successfully");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
