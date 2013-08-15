package br.com.tagview.todo.dao;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.tagview.todo.model.Task;

import com.googlecode.objectify.Key;

@Repository
public class TaskDAOObjectify implements TaskDAO {
	
	@Override
	public Task save(Task task) {
		ofy().save().entity(task).now();
		return null;
	}

	@Override
	public List<Task> all() {
		return ofy().load().type(Task.class).list();
	}



	@Override
	public Boolean destroy(Task task) {
		ofy().delete().entity(task).now();
		return true;
	}

	@Override
	public Task findById(Long id) {
		Key<Task> k = Key.create(Task.class, id);
		return ofy().load().key(k).now();
	}
	


}
