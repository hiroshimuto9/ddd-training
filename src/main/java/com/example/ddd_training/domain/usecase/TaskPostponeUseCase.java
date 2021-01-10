package com.example.ddd_training.domain.usecase;

import com.example.ddd_training.domain.shared.DomainException;
import com.example.ddd_training.domain.task.Task;
import com.example.ddd_training.domain.task.TaskId;
import com.example.ddd_training.domain.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskPostponeUseCase {
  private final TaskRepository taskRepository;

  public void postpone(TaskId taskId) throws DomainException {
    Task task = taskRepository.findById(taskId);
    task.postpone();
    taskRepository.save(task);
  }

}
