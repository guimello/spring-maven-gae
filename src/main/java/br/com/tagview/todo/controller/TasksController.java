package br.com.tagview.todo.controller;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tagview.todo.model.Task;


@Controller
@RequestMapping("/")
public class TasksController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String todos(Model uiModel) {
		List<Task> tasks = ofy().load().type(Task.class).list();
		for (Task t : tasks) {
			System.out.println("task: " + t.getId() + " name: " + t.getName() + " desc: " + t.getDescription());
		}
		
		uiModel.addAttribute("message", "hello noobs!!");
		uiModel.addAttribute("tasks", tasks);

		return "tasks/index";
	}
	
	@RequestMapping(value="/new", method=RequestMethod.GET)
	public String newTask(Model uiModel) {
		uiModel.addAttribute("task", new Task());
		return "tasks/new";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String create(Task task, BindingResult bindingResult, Model uiModel) {
		ofy().save().entity(task).now();
		return "redirect:/";
	}
}
