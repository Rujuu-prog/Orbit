package com.rujuu.todo.repository.task;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;
import java.util.UUID;

@Mapper
public interface TaskRepository {
    @Select("SELECT id, title FROM tasks WHERE id = #{taskId}::UUID LIMIT 1")
    Optional<TaskRecord> select(UUID taskId);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO tasks (title) VALUES (#{title})")
    void insert(TaskRecord record);
}
