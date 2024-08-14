package com.rujuu.todo.service.task;

import com.rujuu.todo.repository.task.TaskRecord;
import com.rujuu.todo.repository.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    public TaskEntity find(UUID taskId){
        return taskRepository.select(taskId)
                .map(record -> new TaskEntity(record.getId(), record.getTitle()))
                .orElseThrow(() -> new TaskEntityNotFoundException(taskId));
    }

    public TaskEntity create(String title) {
        var taskRecord = new TaskRecord(null, title);
        taskRepository.insert(taskRecord);
        return new TaskEntity(taskRecord.getId(), taskRecord.getTitle());
    }
}
