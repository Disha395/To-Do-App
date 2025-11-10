package com.example.mytodolistapi.service;
import java.util.*;
import com.example.mytodolistapi.model.ToDo;

public interface ToDoService {

    ToDo getToDo(long id);

    List<ToDo> getToDos();

    ToDo addToDo(String description);

    void deleteToDo(long id);

    void updateToDo(long id, boolean completed);

}
