package com.example.todo.application;

import com.example.todo.dto.TaskDto;

import java.util.List;

public interface TaskService {

    List<TaskDto> getTasks();

    TaskDto getTask(Long id);

    TaskDto create(TaskDto taskDto);

    TaskDto update(Long id, TaskDto taskDto);

    TaskDto delete(Long id);
}
