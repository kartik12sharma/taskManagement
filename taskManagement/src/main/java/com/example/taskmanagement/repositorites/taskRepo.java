package com.example.taskmanagement.repositorites;

import com.example.taskmanagement.enums.Priority;
import com.example.taskmanagement.enums.Status;
import com.example.taskmanagement.models.task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface taskRepo extends JpaRepository<task, Long> {

    @Override
    <S extends task> S save(S entity);

    Optional<task> findByTitleEquals(String title);

    Optional<task> findByDescEquals(String desc);

    List<task> findAllByPriorityEquals(Priority pt);

    List<task> findAllByStatusEquals(Status st);

    List<task> findAllByDueDateEquals(Date dt);

    @Modifying
    @Query(value = "update tasks p set " +
            "case " +
            "when :k.title is not null " +
            "then p.title = :k.title" +
            "when :k.desc is not null" +
            "then p.description = :k.desc" +
            "when :k.priority is not null" +
            "then p.priority = :prod.priority" +
            "when :k.status is not null" +
            "then p.status = :k.status" +
            "when :k.duedate is not null" +
            "then p.duedate = :k.duedate" +
            "when :k.userID is not null" +
            "then p.userID = :k.userID" +
            " where p.id = :id" +
            "end",
            nativeQuery = true)
    task updateTaskWith(task k, Long id);

    @Query(value = "delete from tasks k where k.id = :id", nativeQuery = true)
    void deletetaskByID(Long id);

    List<task> findAllByUserIDEquals(Long id);
}
