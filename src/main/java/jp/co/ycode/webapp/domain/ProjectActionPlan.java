package jp.co.ycode.webapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "project_action_plan")
public class ProjectActionPlan implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 4821469294825290301L;

	@Id
	@Column(name = "action_plan_id", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = Const.ID_NOT_ISSUED;
	
	@ManyToOne
	@JoinColumn(name = "strategy_id", referencedColumnName = "strategy_id")
	private ProjectStrategy strategy;
	
	@Column(name = "action_plan")
	@Type(type = "org.hibernate.type.TextType")
	private String action_plan;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProjectStrategy getStrategy() {
		return strategy;
	}
	public void setStrategyId(ProjectStrategy strategy) {
		this.strategy = strategy;
	}
	public String getAction_plan() {
		return action_plan;
	}
	public void setAction_plan(String action_plan) {
		this.action_plan = action_plan;
	}
}
