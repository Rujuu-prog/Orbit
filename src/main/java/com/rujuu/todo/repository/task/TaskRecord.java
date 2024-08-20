package com.rujuu.todo.repository.task;

import com.rujuu.todo.model.TaskForm;
import lombok.Value;

import java.util.UUID;

@Value
public class TaskRecord {
    UUID id;
    String title;
    TaskForm.StatusEnum status;
}
