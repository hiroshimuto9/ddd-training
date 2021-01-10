package com.example.ddd_training.domain.task;

public interface TaskRepository {
  Task findById(TaskId id);

  void save(Task task);
}
