package jp.co.ycode.webapp.domain.service.live;

import java.util.List;

import jp.co.ycode.webapp.dao.ProjectDao;
import jp.co.ycode.webapp.domain.Project;
import jp.co.ycode.webapp.domain.ProjectMember;
import jp.co.ycode.webapp.domain.ProjectMemberRole;
import jp.co.ycode.webapp.domain.User;
import jp.co.ycode.webapp.domain.service.ProjectMgmtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectMgmtServiceImpl implements ProjectMgmtService {

	public static final long MAX_NO_OF_PROJECTS_GENERAL = 2;
	public static final long MAX_NO_OF_PROJECTS_PREMIUM = 10;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Override
	public List<Project> getAllProjects() {
		return this.projectDao.getAllProjects();
	}

	@Override
	public Project getProjectById(int id) {
		return this.projectDao.getProjectById(id);
	}

	@Override
	public void saveProject(Project project) {
		this.projectDao.saveProject(project);
	}

	@Override
	public void addNewProject(Project project, User user) {
		project.addPrjectMember(user, ProjectMemberRole.Role.OWNER);
		this.projectDao.saveProject(project);
	}

	@Override
	public List<Project> getAllProjectsByUser(User user) {
		return projectDao.getAllProjectsByUser(user);
	}

	@Override
	public boolean isUserAllowedToAddNewProject(User user) {
		long count = this.projectDao.countOwingProjects(user);
		if (user.isPremiumUser())
			return count < MAX_NO_OF_PROJECTS_PREMIUM;
		else
			return count < MAX_NO_OF_PROJECTS_GENERAL;
	}

	@Override
	public List<ProjectMember> getAllMembersByProjectId(int projectId) {
		return this.projectDao.getAllMembersByProjectId(projectId);
	}

}
