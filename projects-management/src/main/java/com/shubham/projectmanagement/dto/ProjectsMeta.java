package com.shubham.projectmanagement.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class ProjectsMeta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String taskName;
	private String taskDescription;
	private boolean status = true;
	@Transient // means "not a DB field"
	private Integer remove; // boolean flag
	@ManyToOne
	private Projects projects;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Projects getProjects() {
		return projects;
	}

	public void setProjects(Projects projects) {
		this.projects = projects;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	

	public Integer getRemove() {
		return remove;
	}

	public void setRemove(Integer remove) {
		this.remove = remove;
	}

	@Override
	public String toString() {
		return "ProjectsMeta [id=" + id + ", taskName=" + taskName + ", taskDescription=" + taskDescription
				+ ", status=" + status + ", projects=" + projects + "]";
	}

}
