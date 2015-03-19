package jp.co.ycode.webapp.domain;

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
@Table(name = "project_strategy")
public class ProjectStrategy {
	
	@Id
	@Column(name = "strategy_id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = Const.ID_NOT_ISSUED;
	
	@ManyToOne
	@JoinColumn(name = "goal_id", referencedColumnName = "goal_id")
	private ProjectGoal goal;
	
	@Column(name = "strategy")
	@Type(type = "org.hibernate.type.TextType")
	private String strategy;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "strategy")
	private List<ProjectActionPlan> actionPlans;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProjectGoal getGoal() {
		return goal;
	}
	public void setGoalId(ProjectGoal goal) {
		this.goal = goal;
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	public List<ProjectActionPlan> getActionPlans() {
		if (this.actionPlans == null)
			this.actionPlans = new ArrayList<ProjectActionPlan>();
		return actionPlans;
	}
	public void setActionPlans(List<ProjectActionPlan> actionPlans) {
		this.actionPlans = actionPlans;
	}
}
