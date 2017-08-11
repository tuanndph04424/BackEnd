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
@Table(name = "roles")
public class RolesEntity implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	@Column(name = "Name")

	private String Name;
	@Column(name = "Status")

	private boolean Status;
	@Column(name = "Descriptions")

	private String Descriptions;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "RolesID")

	private Set<UserRolesEntity> listUserRolesEntity = new HashSet<UserRolesEntity>();

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

	public boolean isStatus() {
		return Status;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public String getDescriptions() {
		return Descriptions;
	}

	public void setDescriptions(String descriptions) {
		Descriptions = descriptions;
	}

	public RolesEntity(int iD, String name, boolean status, String descriptions) {
		super();
		ID = iD;
		Name = name;
		Status = status;
		Descriptions = descriptions;
	}

	public RolesEntity() {
		super();
	}

}
