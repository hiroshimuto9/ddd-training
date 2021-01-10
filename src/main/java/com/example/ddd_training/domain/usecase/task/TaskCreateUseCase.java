package com.example.ddd_training.domain.usecase.task;

import com.example.ddd_training.domain.task.Task;
import com.example.ddd_training.domain.task.TaskId;
import com.example.ddd_training.domain.task.TaskRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class TaskCreateUseCase {
  @NonNull
  private TaskRepository taskRepository;

  public TaskId createTask(String name, LocalDate dueDate) {
    Task task = new Task(name, dueDate);
    taskRepository.save(task);
    return task.getTaskId();
  }
}
