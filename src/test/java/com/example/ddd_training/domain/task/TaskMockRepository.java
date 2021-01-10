package com.example.ddd_training.domain.task;

import java.util.HashMap;
import java.util.Map;

public class TaskMockRepository implements TaskRepository {
  private Map<TaskId, Task> map = new HashMap<>();
  @Override
  public Task findById(TaskId id) {
    return map.get(id);
  }

  @Override
  public void save(Task task) {
    map.put(task.getId(), task);
  }
}
