package jp.co.ycode.webapp.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import jp.co.ycode.webapp.dao.ProjectDao;
import jp.co.ycode.webapp.domain.Project;
import jp.co.ycode.webapp.domain.ProjectGoal;
import jp.co.ycode.webapp.domain.ProjectMember;
import jp.co.ycode.webapp.domain.ProjectMemberRole;
import jp.co.ycode.webapp.domain.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ProjectDaoImpl implements ProjectDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Project> getAllProjects() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Project").list();
	}

	@Override
	public Project getProjectById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Project) session.get(Project.class, id);
	}

	@Override
	public void addProject(Project project) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(project);
	}

	@Override
	public void saveProject(Project project) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(project);
	}

	@Override
	public void deleteProject(Project project) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(project);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Project> getAllProjectsByUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ProjectMember> members = session
				.createQuery("from ProjectMember m where m.user.id = :userId")
				.setInteger("userId", user.getId())
				.list();
		List<Project> result = new ArrayList<Project>();
		for(ProjectMember membership : members)
			result.add(membership.getProject());
		return result;
	}

	@Override
	public List<Project> getAllProjectsOwnedByUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ProjectMember> members = session
				.createQuery("from ProjectMember m inner join m.roles as r where m.user.id = :userId and r.role = :role")
				.setInteger("userId", user.getId())
				.setString("role", ProjectMemberRole.Role.OWNER.getName())
				.list();
		List<Project> result = new ArrayList<Project>();
		for(ProjectMember membership : members)
			result.add(membership.getProject());
		return result;
	}
	
	public long countOwingProjects(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		return (long) session
				.createQuery("select count(*) from ProjectMember m inner join m.roles as r where m.user.id = :userId and r.role = :role")
				.setInteger("userId", user.getId())
				.setString("role", ProjectMemberRole.Role.OWNER.getName())
				.uniqueResult();
	}

	@Override
	public List<ProjectMember> getAllMembersByProjectId(int projectId) {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<ProjectMember> members = session
				.createQuery("from ProjectMember m where m.project.id = :projectId")
				.setInteger("projectId", projectId)
				.list();
		return members;
	}

	@Override
	public Project getProjectByGoalId(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		ProjectGoal goal = (ProjectGoal) session
				.createQuery("from ProjectGoal g where g.id = :goalId")
				.setInteger("goalId", id)
				.uniqueResult();
		if (goal == null)
			return null;
		return goal.getProject();
	}

	@Override
	public void saveGoal(ProjectGoal goal) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(goal);
	}

}
