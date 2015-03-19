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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "project_member_role", uniqueConstraints = { @UniqueConstraint(columnNames = { "member_id", "role" }) })
public class ProjectMemberRole implements Serializable {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 2296379295716850094L;
	
	//TODO: Firstly see http://www.gabiaxel.com/2011/01/better-enum-mapping-with-hibernate.html
	//See this too. It's also good to know. : http://java.dzone.com/articles/annotating-custom-types 
	private static final String ROLE_OWNER = "OWNER";
	private static final String ROLE_MEMBER = "MEMBER";
	public enum Role {
		OWNER(ROLE_OWNER),
		MEMBER(ROLE_MEMBER);
		
		private String name;
		
		Role(String name)
		{
			this.name = name;
		}
		
		public String getName()
		{
			return this.name;
		}
		
		static Role getRole(String name)
		{
			switch(name){
			case ROLE_OWNER:
				return OWNER;
			case ROLE_MEMBER:
				return MEMBER;
			default:
				return MEMBER;
			}
		}
	}
	
	@Id
	@Column(name = "member_role_id", nullable = false, columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = Const.ID_NOT_ISSUED;
	
	@ManyToOne
	@JoinColumn(name = "member_id", referencedColumnName = "member_id", nullable = false)
	private ProjectMember member;
	
	@Column(name = "role", nullable = false)
	private String role;
	
	public ProjectMemberRole()
	{
	}
	
	public ProjectMemberRole(ProjectMember member, Role role) {
		this.member = member;
		this.role = role.getName();
	}
	
	public int getId() {
		return id;
	}
	public ProjectMember getMember() {
		return member;
	}
	public String getRole() {
		return role;
	}
	public Role getRoleEnum() {
		return Role.getRole(this.getRole());
	}
}
