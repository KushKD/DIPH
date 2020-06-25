package com.dit.himachal.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "users_user_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "users_user_id_seq", sequenceName = "public.users_user_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String userName;


    @Column(name = "password_")
    private String password;
    
    @Column(name = "mobile_number")
    private Long mobileNumber;
    
    @Column(name = "active")
    private boolean active;

    @ManyToMany(mappedBy = "users", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RolesEntity> roles;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<RolesEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RolesEntity> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", userName=" + userName + ", password=" + password + ", mobileNumber="
				+ mobileNumber + ", active=" + active + ", roles=" + roles + "]";
	}

   
}