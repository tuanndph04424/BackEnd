package com.nguyentuan.api.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userfcroles")
public class UserfcRolesEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@ManyToOne
	@JoinColumn(name = "UserID")
	private UserEntity UserID;

	@ManyToOne
	@JoinColumn(name = "DeptID")
	private DepartmentEntity DeptID;

	@ManyToOne
	@JoinColumn(name = "RolesID")
	private RolesEntity RolesID;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public UserEntity getUserID() {
		return UserID;
	}

	public void setUserID(UserEntity userID) {
		UserID = userID;
	}

	public DepartmentEntity getDeptID() {
		return DeptID;
	}

	public void setDeptID(DepartmentEntity deptID) {
		DeptID = deptID;
	}

	public RolesEntity getRolesID() {
		return RolesID;
	}

	public void setRolesID(RolesEntity rolesID) {
		RolesID = rolesID;
	}

}
