package br.com.tagview.todo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Task {
	@Id
	private Long id;
	
	@NotBlank
	private String name;

	@NotBlank
	private String description;
	
	public Task() {}
	
	public Task(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toJSON() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> task = new HashMap<String, Object>();
		task.put("le name", this.name);
		task.put("le desc", this.description);
		
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(5);
		numbers.add(7);
		task.put("le addons", numbers);
		
		return mapper.writeValueAsString(task);
	}
}
