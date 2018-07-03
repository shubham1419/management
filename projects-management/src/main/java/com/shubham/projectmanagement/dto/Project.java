package com.shubham.projectmanagement.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String projectName;
	@OneToMany(mappedBy="project")
	private List<Developer> developersId = new ArrayList<>();
	private int teamLeadId;
	private boolean status;
	@OneToMany(mappedBy="project")
	private List<Task> task = new ArrayList<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getTeamLeadId() {
		return teamLeadId;
	}
	public void setTeamLeadId(int teamLeadId) {
		this.teamLeadId = teamLeadId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<Task> getTask() {
		return task;
	}
	public void setTask(List<Task> task) {
		this.task = task;
	}
	public List<Developer> getDevelopersId() {
		return developersId;
	}
	public void setDevelopersId(List<Developer> developersId) {
		this.developersId = developersId;
	}
	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", developersId=" + developersId + ", teamLeadId="
				+ teamLeadId + ", status=" + status + ", task=" + task + "]";
	}
	
	
}
