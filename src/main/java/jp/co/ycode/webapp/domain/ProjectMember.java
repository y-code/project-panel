package jp.co.ycode.webapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "project_member")
public class ProjectMember implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 4086188557981542344L;
	
	@Id
	@Column(name = "member_id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = Const.ID_NOT_ISSUED;
	
	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	@LazyCollection(LazyCollectionOption.FALSE)
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ProjectMemberRole> roles;
	
	public ProjectMember()
	{
	}
	
	public ProjectMember(Project project, User user)
	{
		this.project = project;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public Project getProject() {
		return project;
	}
	public List<ProjectMemberRole> getRoles() {
		if (this.roles == null)
			this.roles = new ArrayList<ProjectMemberRole>();
		return roles;
	}
	
	public ProjectMemberRole addRole(ProjectMemberRole.Role role)
	{
		ProjectMemberRole memberRole = new ProjectMemberRole(this, role);
		this.getRoles().add(memberRole);
		return memberRole;
	}
	
	public boolean isProjectOwner()
	{
		ProjectMemberRole ownerRole = null;
		for (ProjectMemberRole role : this.getRoles())
			if (role.getRoleEnum() == ProjectMemberRole.Role.OWNER)
				ownerRole = role;
		return ownerRole != null;
	}
	
}
