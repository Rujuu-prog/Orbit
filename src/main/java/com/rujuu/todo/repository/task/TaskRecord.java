package com.rujuu.todo.repository.task;

import lombok.Value;

import java.util.UUID;

@Value
public class TaskRecord {
    UUID id;
    String title;
}
