package com.example.ddd_training.infra.task;

import com.example.ddd_training.domain.task.Task;
import com.example.ddd_training.domain.task.TaskId;
import com.example.ddd_training.domain.task.TaskRepository;
import org.springframework.stereotype.Component;

@Component
public class TaskRdbRepository implements TaskRepository {
  @Override
  public Task findById(TaskId id) {
    return null; // omitted
  }

  @Override
  public void save(Task task) {
    // omitted
  }
}
