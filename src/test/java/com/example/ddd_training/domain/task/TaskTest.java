package com.example.ddd_training.domain.task;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
class TaskTest {
  @Nested
  class ConstructorTest {
    @Test
    protected void タスク新規作成() {
      // when: タスク名と期日を指定してタスクを生成すると
      String taskName = "タスク名";
      LocalDate dueDate = LocalDate.of(2021, 1, 10);
      Task task = new Task(taskName, dueDate);

      // then:
      // タスク名と期日は引数の値で生成される
      assertEquals(task.getName(), taskName);
      assertEquals(task.getDueDate(), dueDate);

      // 延期回数とステータスは初期状態として0回と未完了で生成される
      assertEquals(task.getPostponeCount(), 0);
      assertEquals(task.getTaskStatus(), TaskStatus.UNDONE);
    }

  }
}
