package com.rujuu.todo.controller.task;

import com.rujuu.todo.controller.TasksApi;
import com.rujuu.todo.model.PageDTO;
import com.rujuu.todo.model.TaskDTO;
import com.rujuu.todo.model.TaskForm;
import com.rujuu.todo.model.TaskListDTO;
import com.rujuu.todo.service.task.TaskEntity;
import com.rujuu.todo.service.task.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TaskController implements TasksApi {
    private final TaskService taskService;
    @Override
    public ResponseEntity<TaskDTO> getTask(UUID taskId) {
        var entity = taskService.find(taskId);

        var dto = toTaskDTO(entity);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<TaskListDTO> getTasks(Integer limit, Long offset) {
        var entityList = taskService.find(limit, offset);
        var dtoList = entityList.stream()
                .map(TaskController::toTaskDTO)
                .toList();

        var pageDTO = new PageDTO();
        pageDTO.setLimit(limit);
        pageDTO.setOffset(offset);
        pageDTO.setSize(dtoList.size());

        var dto = new TaskListDTO();
        dto.setPage(pageDTO);
        dto.setResults(dtoList);
        return ResponseEntity.ok(dto);
    }

    private static TaskDTO toTaskDTO(TaskEntity taskEntity) {
        var taskDTO =  new TaskDTO();
        taskDTO.setId(taskEntity.getId());
        taskDTO.setTitle(taskEntity.getTitle());
        return taskDTO;
    }

    @Override
    public ResponseEntity<TaskDTO> createTask(TaskForm taskForm) {
        var entity = taskService.create(taskForm.getTitle(), taskForm.getStatus());

        var dto = toTaskDTO(entity);
        return ResponseEntity.created(URI.create("/tasks/" + dto.getId())).body(dto);
    }
}
