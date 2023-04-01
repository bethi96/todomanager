package com.example.tharun.todomanager.entity;

import java.time.LocalTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="todos")
public class Todomanager {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="todoitem")
	private String todoitem;
	
	@Column(name="priority")
	private String priority;
	
	@Column(name="description")
	private String description;
	
	@Column(name="comments")
	private String comments;
	
	@Column(name="dueDate")
	private String dueDate;
	
	@Column(name="dueTime")
	private String dueTime;

	public Todomanager () {
		
	}
	
	
	public Todomanager(Long id,String name,String todoitem, String priority, String description, String comments, String dueDate, String dueTime) {
		super();
		this.id = id;
		this.name = name;
		this.todoitem = todoitem;
		this.priority = priority;
		this.description = description;
		this.comments = comments;
		this.dueDate = dueDate;
		this.dueTime = dueTime;
		
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


	public String getTodoitem() {
		return todoitem;
	}

	public void setTodoitem(String todoitem) {
		this.todoitem = todoitem;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}


	public String getDueTime() {
		return dueTime;
	}


	public void setDueTime(String dueTime) {
		this.dueTime = dueTime;
	}


	@Override
	public String toString() {
		return "Todomanager [id=" + id + ", name=" + name + ", todoitem=" + todoitem + ", priority=" + priority
				+ ", description=" + description + ", comments=" + comments + ", dueDate=" + dueDate + ", dueTime="
				+ dueTime + "]";
	}
	
	
	

}
