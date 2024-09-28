package com.example.taskmanagement.models;

import com.example.taskmanagement.enums.Priority;
import com.example.taskmanagement.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "Tasks")
@Getter
@Setter
public class task extends baseClass{

    private String title;
    @Column(name = "description")
    private String desc;
    @Enumerated(EnumType.ORDINAL)
    private Priority priority;
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    private Date dueDate;
    private Long userID;
}