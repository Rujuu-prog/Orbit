package com.rujuu.todo.service.task;

import lombok.Value;

import java.util.UUID;

@Value
public class TaskEntity {
    UUID id;
    String title;
}
