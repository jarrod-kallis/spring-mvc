package com.in28minutes.todo;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
// Use the session attribute
@SessionAttributes("name")
public class TodoController {
	@Autowired
	TodoService service;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String retrieveTodos(ModelMap model) {
		model.put("todos", service.retrieveTodos(model.get("name").toString()));

		return "todos";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showTodoPage(ModelMap model) {
		model.put("todo", new Todo(0, model.get("name").toString(), "", new Date(), false));
		return "todo";
	}

	// Command Bean Tag will map the individual form elements to the Todo model
	// so you don't have to pass the fields individually
	// Binding Result holds any validation errors
	// NB!! It seems that these two, '@Valid Todo todo, BindingResult result',
	// have to be next to each other in the args list
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(@Valid Todo todo, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "todo";
		}

		String username = model.get("name").toString();
		service.addTodo(username, todo.getDescription(), new Date(), false);

		// model.put("todos", service.retrieveTodos(username));
		// return "todos";

		// Stops the "name" attribute from being passed as a URL query param
		model.clear();
		return "redirect:todos";
	}

	@RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam int id, ModelMap model) {
		service.deleteTodo(id);
		model.clear();
		return "redirect:todos";
	}
}
