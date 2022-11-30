package com.example.todo.application;

import com.example.todo.domain.Task;
import com.example.todo.domain.TaskRepository;
import com.example.todo.dto.TaskDto;
import com.example.todo.errors.TaskNotFoundException;
import com.github.dozermapper.core.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final Mapper dozerMapper;
    private final TaskRepository taskRepository;

    @Override
    public List<TaskDto> getTasks() {
        return taskRepository.findAll()
                .stream()
                .map(this::taskToDto)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public TaskDto getTask(Long id) {
        final Task task = findTaskByIdAndHandleException(id);

        return taskToDto(task);
    }

    @Override
    public TaskDto create(TaskDto taskDto) {
        final Task task = dozerMapper.map(taskDto, Task.class);

        final Task addedTask = taskRepository.save(task);

        return taskToDto(addedTask);
    }

    @Override
    public TaskDto update(Long id, TaskDto taskDto) {
        final Task task = findTaskByIdAndHandleException(id);

        task.update(taskDto);

        return taskToDto(task);
    }

    @Override
    public TaskDto delete(Long id) {
        final Task task = findTaskByIdAndHandleException(id);

        taskRepository.delete(task);

        return taskToDto(task);
    }

    private Task findTaskByIdAndHandleException(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
    }

    private TaskDto taskToDto(Task task) {
        return dozerMapper.map(task, TaskDto.class);
    }
}
