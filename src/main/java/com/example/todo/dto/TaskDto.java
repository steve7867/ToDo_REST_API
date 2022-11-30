package com.example.todo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TaskDto {

    private Long id;

    @NotBlank
    private String name;

    @JsonIgnore private LocalDateTime regDate;
    @JsonIgnore private LocalDateTime modDate;
}
