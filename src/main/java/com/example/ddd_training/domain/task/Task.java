package com.example.ddd_training.domain.task;

import com.example.ddd_training.domain.shared.DomainException;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Task {
  private final TaskId taskId;
  private TaskStatus taskStatus;
  private String name;
  private int postponeCount;
  private LocalDate dueDate;

  public Task(String name, LocalDate dueDate) {
    if (name == null || dueDate == null) {
      throw  new IllegalArgumentException("必須項目が選択されていません。");
    }
    this.taskId = new TaskId();
    this.name = name;
    this.dueDate = dueDate;
    this.postponeCount = 0;
    // タスク作成時は、ステータスが未完了で作成される。
    this.taskStatus = TaskStatus.UNDONE;
  }

  private static final int MAX_POSTPONE_COUNT = 3;
  // 期限の延期処理
  // Setterを使っていないため、コンストラクタの状態変更はこの処理を通さないと行えないと判断しやすい。
  public void postpone() {
    validatePostPoneCount();
    dueDate.plusDays(1L);
    postponeCount++;
  }

  private void validatePostPoneCount() throws DomainException {
    if (this.postponeCount >= MAX_POSTPONE_COUNT) {
      throw new DomainException("最大延期回数を超えています");
    }
  }
}
