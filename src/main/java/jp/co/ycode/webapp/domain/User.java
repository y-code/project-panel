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

@Entity
@Table(name = "app_user")
public class User {
	
	@Id
	@Column(name = "user_id", nullable = false, columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = Const.ID_NOT_ISSUED;
	
	@Column(name = "user_name", nullable = false, unique = true, length = 256)
	private String name;
	
	@Column(name = "email", nullable = false, length = 256)
	private String email;
	
	@Column(name = "password", nullable = false, length = 32)
	private String password;
	
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
	@Column(name = "first_name", nullable = true, length = 256)
	private String firstName;
	
	@Column(name = "last_name", nullable = true, length = 256)
	private String lastName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<UserRole> usersRoles;
	
	@OneToMany(mappedBy = "user")
	private List<ProjectMember> members;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getName() {
		return name;
	}
	public void setName(String userName) {
		this.name = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public List<UserRole> getUserRoles() {
		if (this.usersRoles == null)
			this.usersRoles = new ArrayList<UserRole>();
		return usersRoles;
	}
	public void setUserRoles(List<UserRole> userRole) {
		this.usersRoles = userRole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isPremiumUser()
	{
		UserRole premiumRole = null;
		for (UserRole role : this.getUserRoles())
			if (role.getRoleEnum() == UserRole.Role.PREMIUM)
				premiumRole = role;
		return premiumRole != null;
	}
}
