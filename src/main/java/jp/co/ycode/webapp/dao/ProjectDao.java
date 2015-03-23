package jp.co.ycode.webapp.dao;

import java.util.List;

import jp.co.ycode.webapp.domain.Project;
import jp.co.ycode.webapp.domain.ProjectGoal;
import jp.co.ycode.webapp.domain.ProjectMember;
import jp.co.ycode.webapp.domain.User;

public interface ProjectDao {
	public List<Project> getAllProjects();
	public Project getProjectById(int id);
	public void addProject(Project project);
	public void saveProject(Project project);
	public void deleteProject(Project project);
	public List<Project> getAllProjectsByUser(User user);
	public List<Project> getAllProjectsOwnedByUser(User user);
	public long countOwingProjects(User user);
	public List<ProjectMember> getAllMembersByProjectId(int projectId);
	public Project getProjectByGoalId(int id);
	public void saveGoal(ProjectGoal goal);
}
