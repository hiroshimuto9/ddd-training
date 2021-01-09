package com.example.ddd_training.domain.task;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Task {
  private Long id;
  private TaskStatus taskStatus;
  private String name;
  private int postponeCount;
  private LocalDate dueDate;

  public Task(String name, LocalDate dueDate) {
    if (name == null || dueDate == null) {
      throw  new IllegalArgumentException("必須項目が選択されていません。");
    }
    this.name = name;
    this.dueDate = dueDate;
    this.postponeCount = 0;
    // タスク作成時は、ステータスが未完了で作成される。
    this.taskStatus = TaskStatus.UNDONE;
  }
}
