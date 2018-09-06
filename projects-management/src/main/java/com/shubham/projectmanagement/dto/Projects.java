package com.shubham.projectmanagement.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Projects {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String projectName;
	private boolean status = true;
	@OneToMany(mappedBy="projects")
	private List<ProjectsMeta> projectMetaId;
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
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<ProjectsMeta> getProjectId() {
		return projectMetaId;
	}
	public void setProjectId(List<ProjectsMeta> projectMetaId) {
		this.projectMetaId = projectMetaId;
	}
	@Override
	public String toString() {
		return "Projects [id=" + id + ", projectName=" + projectName + ", status=" + status + ", projectId=" + projectMetaId
				+ "]";
	}
	
	
}
