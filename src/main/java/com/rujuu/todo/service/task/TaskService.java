package com.rujuu.todo.service.task;

import com.rujuu.todo.repository.task.TaskRecord;
import com.rujuu.todo.repository.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<TaskEntity> find(Integer limit, Long offset ){
        return taskRepository.selectList(limit, offset).stream()
                .map(taskRecord -> new TaskEntity(taskRecord.getId(), taskRecord.getTitle()))
                .toList();
    }

    public TaskEntity create(String title) {
        var taskRecord = new TaskRecord(null, title);
        taskRepository.insert(taskRecord);
        return new TaskEntity(taskRecord.getId(), taskRecord.getTitle());
    }
}
