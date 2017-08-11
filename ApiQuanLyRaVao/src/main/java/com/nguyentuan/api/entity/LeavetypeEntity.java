package com.nguyentuan.api.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "leavetype")
public class LeavetypeEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@Column(name = "Name")
	private String Name;
	@Column(name = "Description")
	private String Description;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "DepartmentID")

	private Set<UserEntity> listnhanvien = new HashSet<UserEntity>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "TimekeepingType")

	private Set<UserTimeOut> listUserTimeOut = new HashSet<UserTimeOut>();

	public Set<UserEntity> getListnhanvien() {
		return listnhanvien;
	}

	public void setListnhanvien(Set<UserEntity> listnhanvien) {
		this.listnhanvien = listnhanvien;
	}

	public Set<UserTimeOut> getListUserTimeOut() {
		return listUserTimeOut;
	}

	public void setListUserTimeOut(Set<UserTimeOut> listUserTimeOut) {
		this.listUserTimeOut = listUserTimeOut;
	}

	public LeavetypeEntity() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
