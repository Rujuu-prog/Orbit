package com.rujuu.todo.service.task;

import com.rujuu.todo.model.TaskForm;
import lombok.Value;

import java.util.UUID;

@Value
public class TaskEntity {
    UUID id;
    String title;
    TaskForm.StatusEnum status;
}
