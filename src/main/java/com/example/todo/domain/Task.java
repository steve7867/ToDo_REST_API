package com.example.todo.domain;

import com.example.todo.dto.TaskDto;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
public class Task {

    @Id @GeneratedValue
    private Long id;
    private String name;

    private LocalDateTime regDate = LocalDateTime.now();
    private LocalDateTime modDate = LocalDateTime.of(regDate.toLocalDate(), regDate.toLocalTime());

    public void update(TaskDto taskDto) {
        if (taskDto.getName() == null) {
            return;
        }

        this.name = taskDto.getName();
        this.modDate = LocalDateTime.now();
    }
}
