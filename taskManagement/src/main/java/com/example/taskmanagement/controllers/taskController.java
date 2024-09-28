package com.example.taskmanagement.controllers;

import com.example.taskmanagement.dtos.taskDTO;
import com.example.taskmanagement.exceptions.notFoundException;
import com.example.taskmanagement.models.task;
import com.example.taskmanagement.services.taskService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/tasks")
public class taskController {
    @Autowired
    private taskService tks;
    @PostMapping("/post")
//    @ApiOperation(value = "Create a task")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "desc", value = "The description of task",
//                    required = true, dataType = "String"),
//            @ApiImplicitParam(name = "title", value = "The title of task",
//                    required = true, dataType = "String"),
//            @ApiImplicitParam(name = "priority", value = "The priority associated to the task",
//                    required = true, dataType = "String"),
//            @ApiImplicitParam(name = "noOfDays", value = "The no of days alloted to complete the task",
//                    required = true, dataType = "Integer"),
//            @ApiImplicitParam(name = "assignedToUser", value = "The id of the user supposed to do task",
//                    required = true, dataType = "Long")
//    })
    public task createTask(@RequestBody() taskDTO dto){
        return tks.createTask(dto);
    }
    @GetMapping("/id/{id}")
//    @ApiOperation(value = "Get a task associated to 'id'")
    public List<task> getTaskByUSRID(@RequestHeader(HttpHeaders.AUTHORIZATION) String authToken, @PathVariable("id") Long id){
        List<task> t = tks.getTaskByUserID(id);
        if(t.size() == 0)
            throw new notFoundException("No tasks found for user "+id);
        return t;
    }
    @GetMapping("/title/{title}")
//    @ApiOperation(value = "Get a task associated to 'title'")
    public task getTaskByTitle(@PathVariable("title") String title){
        task t = tks.getTaskByTitle(title);
        if(t == null)
            throw new notFoundException("No task found by title "+title);
        return t;
    }
    @GetMapping("/desc/{desc}")
//    @ApiOperation(value = "Get a task associated to 'description'")
    public task getTaskByDesc(@PathVariable("desc") String desc){
        task t = tks.getTaskByDesc(desc);
        if(t == null)
            throw new notFoundException("No task found by desc "+desc);
        return t;
    }
    @PostMapping("/priority")
//    @ApiOperation(value = "Get a task associated to 'priority'")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "desc", value = "The description of task",
//                    required = false, dataType = "String"),
//            @ApiImplicitParam(name = "title", value = "The title of task",
//                    required = false, dataType = "String"),
//            @ApiImplicitParam(name = "priority", value = "The priority associated to the task",
//                    required = true, dataType = "String"),
//            @ApiImplicitParam(name = "noOfDays", value = "The no of days alloted to complete the task",
//                    required = false, dataType = "Integer"),
//            @ApiImplicitParam(name = "assignedToUser", value = "The id of the user supposed to do task",
//                    required = false, dataType = "Long")
//    })
    public List<task> getTaskByPriority(@RequestBody() taskDTO pr){
        List<task> t = tks.getTasksByPriority(pr);
        if(t.isEmpty())
            throw new notFoundException("No tasks found for priority "+pr.getPriority().toString());
        return t;
    }
    @PostMapping("/dueDate")
//    @ApiOperation(value = "Get a task associated to 'due date'")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "desc", value = "The description of task",
//                    required = false, dataType = "String"),
//            @ApiImplicitParam(name = "title", value = "The title of task",
//                    required = false, dataType = "String"),
//            @ApiImplicitParam(name = "priority", value = "The priority associated to the task",
//                    required = false, dataType = "String"),
//            @ApiImplicitParam(name = "noOfDays", value = "The no of days alloted to complete the task",
//                    required = true, dataType = "Integer"),
//            @ApiImplicitParam(name = "assignedToUser", value = "The id of the user supposed to do task",
//                    required = false, dataType = "Long")
//    })
    public List<task> getTaskByDDate(@RequestBody() taskDTO pr){
        return tks.getTasksByDueDate(pr);
    }
    @PostMapping("/status")
//    @ApiOperation(value = "Get a task associated to 'status'")
    public List<task> getTaskByStatus(@RequestBody() taskDTO pr){
        return tks.getTasksByStatus(pr);
    }
    @PatchMapping("/{id}")
//    @ApiOperation(value = "Update task associated to id")
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "desc", value = "The description of task",
//                    required = true, dataType = "String"),
//            @ApiImplicitParam(name = "title", value = "The title of task",
//                    required = true, dataType = "String"),
//            @ApiImplicitParam(name = "priority", value = "The priority associated to the task",
//                    required = true, dataType = "String"),
//            @ApiImplicitParam(name = "noOfDays", value = "The no of days alloted to complete the task",
//                    required = true, dataType = "Integer"),
//            @ApiImplicitParam(name = "assignedToUser", value = "The id of the user supposed to do task",
//                    required = true, dataType = "Long")
//    })
    public task updateTask(@RequestBody() taskDTO dto, @PathVariable("id") Long id){
        return tks.updateTask(dto, id);
    }
    @DeleteMapping("/{id}")
//    @ApiOperation(value = "Delete task associated to id")
    public void deleteTask(@PathVariable("id") Long id){
        tks.deleteTaskByID(id);
    }
}