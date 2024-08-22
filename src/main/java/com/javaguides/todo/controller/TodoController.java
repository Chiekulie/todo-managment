package com.javaguides.todo.controller;

import com.javaguides.todo.dto.TodoDto;
import com.javaguides.todo.entity.Todo;
import com.javaguides.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos")
@AllArgsConstructor
public class TodoController {

    private TodoService todoService;

    //Build Add Todo Rest Api

    @PostMapping 
    public ResponseEntity<TodoDto> addTodo(@RequestBody TodoDto todoDto){

     TodoDto savedTodo =  todoService.addTodo(todoDto);

     return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

    //Build Get Todo REST APi
    @GetMapping("{id}")
    public ResponseEntity<TodoDto> getTodo(@PathVariable("id") Long todoID){
        TodoDto todoDto = todoService.getTodo(todoID);
        return new ResponseEntity<>(todoDto,HttpStatus.OK);
    }

     //BUILD GET ALL Todos REST API
    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos(){
        List<TodoDto> todos = todoService.getAllTodos();
        //return new ResponseEntity<>(todos, HttpStatus.OK);
        return ResponseEntity.ok(todos);
    }

    //Build Update Todo REST API
    @PutMapping("{id}")
    public ResponseEntity<TodoDto> update( @RequestBody TodoDto todoDto,@PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.updateTodo(todoDto,todoId);
        return ResponseEntity.ok(updatedTodo);
    }

    //Build Delete Todo REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo deleted successfully");
    }

    //Build complete Todo REST API
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDto> completeTodo(@PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.completeTodo(todoId);
        return ResponseEntity.ok(updatedTodo);

    }

    //Build In Complete Todo REST API
    @PatchMapping("{id}/in-complete")
    public ResponseEntity<TodoDto> inCompleteTodo(@PathVariable("id") Long todoId){
        TodoDto updatedTodo = todoService.inCompleteTodo(todoId);
        return ResponseEntity.ok(updatedTodo);
    }

}
