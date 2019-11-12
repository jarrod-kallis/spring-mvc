package com.in28minutes.todo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	public String showTodoPage() {
		return "todo";
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addTodo(@RequestParam String description, ModelMap model) {
		String username = model.get("name").toString();
		service.addTodo(username, description, new Date(), false);

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
