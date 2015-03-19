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
@Table(name = "app_user_role", uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id", "role" }) })
public class UserRole implements Serializable {
	
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -8344638036459723184L;

	//TODO: Firstly see http://www.gabiaxel.com/2011/01/better-enum-mapping-with-hibernate.html
	//See this too. It's also good to know. : http://java.dzone.com/articles/annotating-custom-types
	private static final String ROLE_GENERAL = "ROLE_GENERAL";
	private static final String ROLE_PREMIUM = "ROLE_PREMIUM";
	public enum Role {
		GENERAL(ROLE_GENERAL),
		PREMIUM(ROLE_PREMIUM);
		
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
			case ROLE_GENERAL:
				return GENERAL;
			case ROLE_PREMIUM:
				return PREMIUM;
			default:
				return GENERAL;
			}
		}
	}
	
	public UserRole()
	{
	}
	
	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role.getName();
	}
	
	@Id
	@Column(name = "user_role_id", nullable = false, columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = Const.ID_NOT_ISSUED;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
	private User user;
	
	@Column(name = "role", nullable = false)
	private String role;
	
	public int getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public String getRole() {
		return role;
	}
	
	public Role getRoleEnum() {
		return Role.getRole(this.getRole());
	}
}
