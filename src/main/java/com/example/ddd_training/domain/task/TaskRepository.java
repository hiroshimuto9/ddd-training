package com.example.ddd_training.domain.task;

public interface TaskRepository {
  Task findById(Long id);

  void save(Task task);
}
