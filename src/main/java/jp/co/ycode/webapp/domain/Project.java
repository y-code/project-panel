package jp.co.ycode.webapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;


@TypeDefs({
	@TypeDef(name = "text", typeClass = org.hibernate.type.TextType.class)
})

@Entity
@Table(name = "project")
public class Project {
	
	@Id
	@Column(name = "project_id", nullable = false, columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = Const.ID_NOT_ISSUED;
	
	@Column(name = "name", nullable = false, length = 256)
	private String name;
	
	@Column(name = "vision", length = 1000) //The length is used from JSP.
	@Type(type = "org.hibernate.type.TextType")
	private String vision;
	
	@Column(name = "mission", length = 1000) //The length is used from JSP.
	@Type(type = "org.hibernate.type.TextType")
	private String mission;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ProjectGoal> goals;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<ProjectMember> members;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVision() {
		return vision;
	}
	public void setVision(String vision) {
		this.vision = vision;
	}
	public String getMission() {
		return mission;
	}
	public void setMission(String mission) {
		this.mission = mission;
	}
	public List<ProjectGoal> getGoals() {
		if (this.goals == null)
			this.goals = new ArrayList<ProjectGoal>();
		return goals;
	}
	public List<ProjectMember> getMembers() {
		if (this.members == null)
			this.members = new ArrayList<ProjectMember>();
		return members;
	}
	
	public boolean isNew()
	{
		return this.getId() == Const.ID_NOT_ISSUED;
	}
	
	public ProjectMember addPrjectMember(User user, ProjectMemberRole.Role role)
	{
		ProjectMember member = new ProjectMember(this, user);
		member.addRole(role);
		this.getMembers().add(member);
		return member;
	}
	
	public ProjectMember getMember(int userId)
	{
		for (ProjectMember member : this.getMembers())
			if (member.getUser().getId() == userId)
				return member;
		return null;
	}
	
	public ProjectGoal getGoal(int goalId)
	{
		for (ProjectGoal goal : this.getGoals())
			if (goal.getId() == goalId)
				return goal;
		return null;
	}
}
