package com.example.taskmanagement.services;

import com.example.taskmanagement.dtos.taskDTO;
import com.example.taskmanagement.models.task;
import com.example.taskmanagement.repositorites.taskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class taskService {
    @Autowired
    private taskRepo rp;
    public task createTask(taskDTO dto){
        task tk = taskDTO.toTask(dto);
        return rp.save(tk);
    }
    public task updateTask(taskDTO dto, Long id){
        task tk = taskDTO.toTask(dto);
        return rp.updateTaskWith(tk, id);
    }
    public void deleteTaskByID(Long id){
        rp.deletetaskByID(id);
    }
    public task getTaskByTitle(String title){
        return rp.findByTitleEquals(title).get();
    }
    public task getTaskByDesc(String desc){
        return rp.findByDescEquals(desc).get();
    }
    public List<task> getTasksByPriority(taskDTO dto) {
        task tk = taskDTO.toTask(dto);
        return rp.findAllByPriorityEquals(tk.getPriority());
    }
    public List<task> getTasksByDueDate(taskDTO dto){
        task tk = taskDTO.toTask(dto);
        return rp.findAllByDueDateEquals(tk.getDueDate());
    }
    public List<task> getTasksByStatus(taskDTO dto){
        task tk = taskDTO.toTask(dto);
        return rp.findAllByStatusEquals(tk.getStatus());
    }
    public List<task> getTaskByUserID(Long id){
        return rp.findAllByUserIDEquals(id);
    }
}
