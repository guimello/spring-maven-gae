package br.com.tagview.todo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.tagview.todo.dao.TaskDAO;
import br.com.tagview.todo.exception.ResourceNotFoundException;
import br.com.tagview.todo.model.Task;

@Controller
@RequestMapping("/")
public class TasksController {
	
	@Autowired
	private TaskDAO dao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String todos(Model uiModel) {
		List<Task> tasks = dao.all();
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
	public String create(@Valid Task task, BindingResult bindingResult, Model uiModel) {
		if (bindingResult.hasErrors()) {
			uiModel.addAttribute("task", new Task());
			return "tasks/new";
		}

		dao.save(task);
		return "redirect:/";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String show(@PathVariable Long id, Model uiModel) {
		Task task = dao.findById(id);
		
		if (task == null) {
			throw new ResourceNotFoundException();
		}
		
		uiModel.addAttribute("task", task);
		return "tasks/show";
	}
	
	@RequestMapping(value="/remove/{id}")
	public String destroy(@PathVariable Long id, Model uiModel) {
		Task task = dao.findById(id);
		if (task != null) dao.destroy(task);
		
		return "redirect:/";
	}
}
