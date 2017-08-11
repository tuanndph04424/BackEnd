package com.nguyentuan.api.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
@Table(name = "user")
public class UserEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@Column(name = "UserName")

	private String UserName;
	@Column(name = "Password")

	private String Password;
	@ManyToOne
	@JoinColumn(name = "DepartmentID")

	private DepartmentEntity DepartmentID;

	@Column(name = "Status")

	private boolean Status;
	@Column(name = "Created")

	private Timestamp Created;
	@Column(name = "Actived")

	private boolean Actived;
	@Column(name = "IsLock")

	private boolean IsLock;
	@Column(name = "Name")

	private String Name;
	
	@Column(name = "FullName")

	private String FullName;
	@Column(name = "Team")

	private String Team;
	@Column(name = "Type")

	private int Type;
	@Column(name = "Address")

	private String Address;

	@Column(name = "Email")

	private String Email;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "UserID")

	private Set<UserTimeOut> listUserTimeOut1 = new HashSet<UserTimeOut>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "LeadApproval")

	private Set<UserTimeOut> listUserTimeOut2 = new HashSet<UserTimeOut>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ManagerApproval")

	private Set<UserTimeOut> listUserTimeOut3 = new HashSet<UserTimeOut>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "UserCancal")

	private Set<UserTimeOut> listUserTimeOut4 = new HashSet<UserTimeOut>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "DirectorApproval")

	private Set<UserTimeOut> listUserTimeOut5 = new HashSet<UserTimeOut>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "UserID")

	private Set<UserRolesEntity> listUserRolesEntity = new HashSet<UserRolesEntity>();

	public Set<UserTimeOut> getListUserTimeOut1() {
		return listUserTimeOut1;
	}

	public void setListUserTimeOut1(Set<UserTimeOut> listUserTimeOut1) {
		this.listUserTimeOut1 = listUserTimeOut1;
	}

	public Set<UserTimeOut> getListUserTimeOut2() {
		return listUserTimeOut2;
	}

	public void setListUserTimeOut2(Set<UserTimeOut> listUserTimeOut2) {
		this.listUserTimeOut2 = listUserTimeOut2;
	}

	public Set<UserTimeOut> getListUserTimeOut3() {
		return listUserTimeOut3;
	}

	public void setListUserTimeOut3(Set<UserTimeOut> listUserTimeOut3) {
		this.listUserTimeOut3 = listUserTimeOut3;
	}

	public Set<UserTimeOut> getListUserTimeOut4() {
		return listUserTimeOut4;
	}

	public void setListUserTimeOut4(Set<UserTimeOut> listUserTimeOut4) {
		this.listUserTimeOut4 = listUserTimeOut4;
	}

	public Set<UserTimeOut> getListUserTimeOut5() {
		return listUserTimeOut5;
	}

	public void setListUserTimeOut5(Set<UserTimeOut> listUserTimeOut5) {
		this.listUserTimeOut5 = listUserTimeOut5;
	}

	public Set<UserRolesEntity> getListUserRolesEntity() {
		return listUserRolesEntity;
	}

	public void setListUserRolesEntity(Set<UserRolesEntity> listUserRolesEntity) {
		this.listUserRolesEntity = listUserRolesEntity;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public DepartmentEntity getDepartmentID() {
		return DepartmentID;
	}

	public void setDepartmentID(DepartmentEntity departmentID) {
		DepartmentID = departmentID;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	

	public Timestamp getCreated() {
		return Created;
	}

	public void setCreated(Timestamp created) {
		Created = created;
	}

	public boolean isActived() {
		return Actived;
	}

	public void setActived(boolean actived) {
		Actived = actived;
	}

	public boolean isIsLock() {
		return IsLock;
	}

	public void setIsLock(boolean isLock) {
		IsLock = isLock;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getFullName() {
		return FullName;
	}

	public void setFullName(String fullName) {
		FullName = fullName;
	}

	public String getTeam() {
		return Team;
	}

	public void setTeam(String team) {
		Team = team;
	}

	public int getType() {
		return Type;
	}

	public void setType(int type) {
		Type = type;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public UserEntity() {
		super();
	}

}
