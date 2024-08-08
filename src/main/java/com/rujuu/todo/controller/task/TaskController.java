package com.rujuu.todo.controller.task;

import com.rujuu.todo.controller.TasksApi;
import com.rujuu.todo.model.TaskDTO;
import com.rujuu.todo.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TaskController implements TasksApi {
    private final TaskService taskService;
    @Override
    public ResponseEntity<TaskDTO> getTask(UUID taskId) {
        var entity = taskService.find(taskId);

        var dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        return ResponseEntity.ok(dto);

    }


}
