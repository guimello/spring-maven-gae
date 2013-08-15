package br.com.tagview.todo.dao;

import java.util.List;

import br.com.tagview.todo.model.Task;

public interface TaskDAO {
	Task save(Task task);
	List<Task> all();
	Boolean destroy(Task task);
	Task findById(Long id);
}
