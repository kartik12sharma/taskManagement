package com.example.taskmanagement.dtos;

import com.example.taskmanagement.enums.Priority;
import com.example.taskmanagement.enums.Status;
import com.example.taskmanagement.exceptions.inValidEntry;
import com.example.taskmanagement.models.task;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class taskDTO {
    private String desc;
    private String title;
    private String priority;
    private int noOfDays;
    private Long assignedToUser;

    public static task toTask(taskDTO dto){
        task t = new task();
        Date d = new Date(LocalDate.now().toEpochDay());
        t.setCreatedAt(d);
        t.setDesc(dto.desc);
        t.setTitle(dto.getTitle());
        t.setStatus(Status.TO_DO);
        t.setUserID(dto.getAssignedToUser());
        t.setDueDate(new Date(LocalDate.now().plusDays(dto.noOfDays).toEpochDay()));
        if(dto.getPriority().toLowerCase().equals("low")){
            t.setPriority(Priority.low);
        }
        else if(dto.getPriority().toLowerCase().equals("high")){
            t.setPriority(Priority.high);
        }
        else if(dto.getPriority().toLowerCase().equals("medium")){
            t.setPriority(Priority.medium);
        }
        else
            throw new inValidEntry("Invalid priority entered");
        return t;
    }
}
