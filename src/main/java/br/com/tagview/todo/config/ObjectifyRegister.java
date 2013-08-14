package br.com.tagview.todo.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.tagview.todo.model.Task;

import com.googlecode.objectify.ObjectifyService;

public class ObjectifyRegister implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ObjectifyService.register(Task.class);
	}

}
