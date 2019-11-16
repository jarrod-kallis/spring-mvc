package com.in28minutes.todo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.todo.Todo;
import com.in28minutes.todo.TodoService;

@RestController
public class TodoRestController {
	@Autowired
	TodoService service;

	// If there is any letter in the string then assume we're searching on user
	// name
	// .* = 0 - many occurrences of any thing (char, digit, whatever...)
	// [a-zA-Z]+ = 1 or more occurrence of letters (case insensitive)
	// .* = 0 - many occurrences of any thing (char, digit, whatever...)
	@RequestMapping(value = "/rest/todos/{user:.*[a-zA-Z]+.*}", method = RequestMethod.GET)
	public List<Todo> retrieveTodos(@PathVariable String user) {
		return service.retrieveTodos(user);
	}

	// If only digits then assume we're searching on todo id
	@RequestMapping(value = "/rest/todos/{id:[0-9]+}", method = RequestMethod.GET)
	public Todo retrieveTodo(@PathVariable int id) {
		return service.retrieveTodo(id);
	}
}
