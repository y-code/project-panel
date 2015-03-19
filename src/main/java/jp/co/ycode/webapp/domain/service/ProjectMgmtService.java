package jp.co.ycode.webapp.domain.service;

import java.util.List;

import jp.co.ycode.webapp.domain.Project;
import jp.co.ycode.webapp.domain.ProjectMember;
import jp.co.ycode.webapp.domain.User;

public interface ProjectMgmtService {
	public List<Project> getAllProjects();
	public List<Project> getAllProjectsByUser(User user);
	public Project getProjectById(int projectId);
	public void saveProject(Project project);
	public void addNewProject(Project project, User user);
	public boolean isUserAllowedToAddNewProject(User user);
	public List<ProjectMember> getAllMembersByProjectId(int projectId);
}
