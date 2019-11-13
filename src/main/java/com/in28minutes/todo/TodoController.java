package com.in28minutes.todo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TodoController {
	@Autowired
	TodoService service;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		// Whenever the screen shows a date it must use this format, or whenever
		// there is some sort of binding
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String retrieveTodos(ModelMap model) {
		model.put("todos", service.retrieveTodos(getLoggedInUserName()));

		return "todos";
	}

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showAddTodoPage(ModelMap model) {
		model.put("todo", new Todo(0, getLoggedInUserName(), "", new Date(), false));
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

		String username = getLoggedInUserName();
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

	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
		Todo todo = service.retrieveTodo(id);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if (result.hasErrors()) {
			return "todo";
		}

		Todo origTodo = service.retrieveTodo(todo.getId());
		origTodo.setDescription(todo.getDescription());
		origTodo.setTargetDate(todo.getTargetDate());
		service.updateTodo(origTodo);

		model.clear();
		return "redirect:todos";
	}
}
