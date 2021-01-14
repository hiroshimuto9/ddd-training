package com.example.ddd_training.domain.task;

import com.example.ddd_training.domain.shared.DomainException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

  @Nested
  class PostponeTest {
    @Test
    protected  void タスク延期1回目が成功し_延期回数が1増えて期日が1日後になる() {
      // given: 延期回数0回のタスク
      LocalDate dueDate = LocalDate.of(2021,1,14);
      Task task = new Task("taskName", dueDate);

      // when: タスクを延期すると
      task.postpone();

      // then:
      // タスクの延期回数が1増える
      // タスク期限が1日追加される
      assertEquals(task.getPostponeCount(), 1);
      assertEquals(task.getDueDate(), dueDate.plusDays(1));
    }

    @Test
    protected void タスクの4回目の延期が失敗する() {
      // given: 3回延期されているタスク
      LocalDate dueDate = LocalDate.of(2021,1,14);
      Task task = new Task("taskName", dueDate);

      // タスクを3回延期
      task.postpone();
      task.postpone();
      task.postpone();

      // when: 4回目の延期を行うと例外が発生する
      Executable target = () -> task.postpone();

      // then: 例外が発生する
      DomainException exception = assertThrows(DomainException.class, target);
      assertEquals(exception.getMessage(), "最大延期回数を超えています");
    }
  }

  @Nested
  class DoneTest {
    @Test
    protected void タスクを完了させるとステータスが完了状態になる() {
      // given: 新規生成状態のタスク
      Task task = new Task("taskName", LocalDate.now());

      // when: タスクを完了にする
      task.done();

      // then: ステータスが完了になる
      assertEquals(task.getTaskStatus(), TaskStatus.DONE);
    }
  }
}
