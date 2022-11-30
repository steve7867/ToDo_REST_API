package com.example.todo.errors;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super("Task가 존재하지 않습니다: " + id);
    }
}
