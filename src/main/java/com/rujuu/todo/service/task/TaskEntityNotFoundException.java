package com.rujuu.todo.service.task;

import java.util.UUID;

public class TaskEntityNotFoundException extends RuntimeException{

    private UUID taskId;

    public TaskEntityNotFoundException(UUID taskId){
        super("TaskId： " + taskId.toString() + " is not found.");
        this.taskId = taskId;
    }
}
