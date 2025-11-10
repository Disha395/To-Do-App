package com.example.mytodolistapi.controller;

import jakarta.validation.constraints.NotBlank;

//only for immutable objects
public record AddToDoRequest(@NotBlank String description) {
}
