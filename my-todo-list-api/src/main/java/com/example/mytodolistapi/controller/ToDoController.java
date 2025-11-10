package com.example.mytodolistapi.controller;
import java.util.*;
import com.example.mytodolistapi.model.ToDo;
import com.example.mytodolistapi.service.ToDoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/*
The ToDoController has endpoints to:

Retrieve all To-Do items
Add a new To-Do item
Delete a To-Do item
Update the completion status of a To-Do item
 */

@RequiredArgsConstructor
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping
    public List<ToDo> getToDos(){
        return toDoService.getToDos();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ToDo addToDo(@Valid @RequestBody AddToDoRequest addToDoRequest){
        return toDoService.addToDo(addToDoRequest.description());
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable Long id){
        toDoService.deleteToDo(id);
    }

    @PatchMapping("/{id}")
    public void updateToDo(@PathVariable Long id, @RequestParam Boolean Completed){
        toDoService.updateToDo(id, Completed);
    }

}
