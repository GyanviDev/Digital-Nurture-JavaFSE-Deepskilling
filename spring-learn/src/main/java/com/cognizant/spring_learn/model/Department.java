package com.cognizant.spring_learn.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Department {
    @NotNull(message = "Department ID should not be null")
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 30, message = "Name must be between 1 and 30 characters")
    private String name;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}