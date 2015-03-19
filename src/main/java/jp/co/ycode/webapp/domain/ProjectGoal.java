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

import org.hibernate.annotations.Type;

@Entity
@Table(name = "project_goal")
public class ProjectGoal implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -8911797282308202212L;

	@Id
	@Column(name = "goal_id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = Const.ID_NOT_ISSUED;
	
	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private Project project;
	
	@Column(name = "goal")
	@Type(type = "org.hibernate.type.TextType")
	private String goal;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "goal")
	private List<ProjectStrategy> strategies;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public List<ProjectStrategy> getStrategies() {
		if (this.strategies == null)
			this.strategies = new ArrayList<ProjectStrategy>();
		return strategies;
	}
	public void setStrategies(List<ProjectStrategy> strategies) {
		this.strategies = strategies;
	}
}
