package com.example.ddd_training.domain.task;

import lombok.Value;

import java.util.UUID;

@Value
public class TaskId {
  private String value;

  public TaskId() {
    this.value = UUID.randomUUID().toString();
  }
}
