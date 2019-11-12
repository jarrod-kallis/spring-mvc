package com.in28minutes.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todoCount = 3;

	static {
		todos.add(new Todo(1, "jmk", "Learn Spring MVC", new Date(), false));
		todos.add(new Todo(2, "jmk", "Learn Struts", new Date(), true));
		todos.add(new Todo(3, "jmk", "Learn Hibernate", new Date(), false));
	}

	public List<Todo> retrieveTodos(String user) {
		List<Todo> filteredTodos = new ArrayList<Todo>();
		for (Todo todo : todos) {
			if (todo.getUser().equals(user)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}

	public void addTodo(String user, String desc, Date targetDate, boolean isDone) {
		todos.add(new Todo(++todoCount, user, desc, targetDate, isDone));
	}

	public void deleteTodo(int id) {
		for (int i = todos.size() - 1; i >= 0; i--) {
			Todo todo = todos.get(i);
			if (todo.getId() == id) {
				todos.remove(i);
				break;
			}
		}
		// Iterator<Todo> iterator = todos.iterator();
		// while (iterator.hasNext()) {
		// Todo todo = iterator.next();
		// if (todo.getId() == id) {
		// iterator.remove();
		// }
		// }
	}
}