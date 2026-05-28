package com.tismo.fullstack.yt.repository;

import com.tismo.fullstack.yt.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
