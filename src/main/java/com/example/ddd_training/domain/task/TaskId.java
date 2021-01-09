package com.example.ddd_training.domain.task;

import java.util.UUID;

public class TaskId {
  private String value;

  public TaskId() {
    this.value = UUID.randomUUID().toString();
  }
}
