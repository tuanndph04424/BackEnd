package com.nguyentuan.api.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "usertimeout")
public class UserTimeOut implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int ID;

	@ManyToOne
	@JoinColumn(name = "TimekeepingType")

	private LeavetypeEntity TimekeepingType;

	@Column(name = "Offdate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String Offdate;

	@Column(name = "EndDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String EndDate;

	@Column(name = "NumberDay")

	private String NumberDay;

	@Column(name = "Descriptions")

	private String Descriptions;

	@Column(name = "Status")

	private int Status;

	@Column(name = "Type")

	private int Type;

	@Column(name = "TimeIn")

	private String TimeIn;
	@Column(name = "TimeOut")

	private String TimeOut;

	@Column(name = "SecurityTimeIn")

	private String SecurityTimeIn;

	@Column(name = "SecurityTimeOut")

	private String SecurityTimeOut;
	@Column(name = "Created")

	private String Created;

	@ManyToOne
	@JoinColumn(name = "DeptID")

	private DepartmentEntity DeptID;

	@ManyToOne
	@JoinColumn(name = "UserID")

	private UserEntity UserID;

	@ManyToOne
	@JoinColumn(name = "LeadApproval")

	private UserEntity LeadApproval;

	@Column(name = "LeadApprovalDate")

	private String LeadApprovalDate;

	@ManyToOne
	@JoinColumn(name = "ManagerApproval")

	private UserEntity ManagerApproval;

	@Column(name = "ManagerApprovalDate")
	private String ManagerApprovalDate;

	@ManyToOne
	@JoinColumn(name = "DirectorApproval")

	private UserEntity DirectorApproval;

	@ManyToOne
	@JoinColumn(name = "UserCancal")

	private UserEntity UserCancal;

	@Column(name = "UserCancalDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String UserCancalDate;

	@Column(name = "CancalDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String CancalDate;

	@Column(name = "ManagerApprovalStatus")

	private int ManagerApprovalStatus;

	@Column(name = "DirectorApprovalStatus")

	private int DirectorApprovalStatus;

	@Column(name = "DirectorApprovalCannel")

	private String DirectorApprovalCannel;

	@Column(name = "DirectorApprovalDate")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String DirectorApprovalDate;
	@Column(name = "ManagerApprovalCanel")

	private String ManagerApprovalCanel;

	public String getDirectorApprovalCannel() {
		return DirectorApprovalCannel;
	}

	public void setDirectorApprovalCannel(String directorApprovalCannel) {
		DirectorApprovalCannel = directorApprovalCannel;
	}

	public String getDirectorApprovalDate() {
		return DirectorApprovalDate;
	}

	public void setDirectorApprovalDate(String directorApprovalDate) {
		DirectorApprovalDate = directorApprovalDate;
	}

	public String getManagerApprovalCanel() {
		return ManagerApprovalCanel;
	}

	public void setManagerApprovalCanel(String managerApprovalCanel) {
		ManagerApprovalCanel = managerApprovalCanel;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public LeavetypeEntity getTimekeepingType() {
		return TimekeepingType;
	}

	public void setTimekeepingType(LeavetypeEntity timekeepingType) {
		TimekeepingType = timekeepingType;
	}

	public String getOffdate() {
		return Offdate;
	}

	public void setOffdate(String offdate) {
		Offdate = offdate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public String getNumberDay() {
		return NumberDay;
	}

	public void setNumberDay(String numberDay) {
		NumberDay = numberDay;
	}

	public String getDescriptions() {
		return Descriptions;
	}

	public void setDescriptions(String descriptions) {
		Descriptions = descriptions;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public int getType() {
		return Type;
	}

	public void setType(int type) {
		Type = type;
	}

	public String getTimeIn() {
		return TimeIn;
	}

	public void setTimeIn(String timeIn) {
		TimeIn = timeIn;
	}

	public String getTimeOut() {
		return TimeOut;
	}

	public void setTimeOut(String timeOut) {
		TimeOut = timeOut;
	}

	public String getSecurityTimeIn() {
		return SecurityTimeIn;
	}

	public void setSecurityTimeIn(String securityTimeIn) {
		SecurityTimeIn = securityTimeIn;
	}

	public String getSecurityTimeOut() {
		return SecurityTimeOut;
	}

	public void setSecurityTimeOut(String securityTimeOut) {
		SecurityTimeOut = securityTimeOut;
	}

	public String getCreated() {
		return Created;
	}

	public void setCreated(String created) {
		Created = created;
	}

	public DepartmentEntity getDeptID() {
		return DeptID;
	}

	public void setDeptID(DepartmentEntity deptID) {
		DeptID = deptID;
	}

	public UserEntity getUserID() {
		return UserID;
	}

	public void setUserID(UserEntity userID) {
		UserID = userID;
	}

	public UserEntity getLeadApproval() {
		return LeadApproval;
	}

	public void setLeadApproval(UserEntity leadApproval) {
		LeadApproval = leadApproval;
	}

	public String getLeadApprovalDate() {
		return LeadApprovalDate;
	}

	public void setLeadApprovalDate(String leadApprovalDate) {
		LeadApprovalDate = leadApprovalDate;
	}

	public UserEntity getManagerApproval() {
		return ManagerApproval;
	}

	public void setManagerApproval(UserEntity managerApproval) {
		ManagerApproval = managerApproval;
	}

	public String getManagerApprovalDate() {
		return ManagerApprovalDate;
	}

	public void setManagerApprovalDate(String managerApprovalDate) {
		ManagerApprovalDate = managerApprovalDate;
	}

	public UserEntity getDirectorApproval() {
		return DirectorApproval;
	}

	public void setDirectorApproval(UserEntity directorApproval) {
		DirectorApproval = directorApproval;
	}

	public UserEntity getUserCancal() {
		return UserCancal;
	}

	public void setUserCancal(UserEntity userCancal) {
		UserCancal = userCancal;
	}

	public String getUserCancalDate() {
		return UserCancalDate;
	}

	public void setUserCancalDate(String userCancalDate) {
		UserCancalDate = userCancalDate;
	}

	public String getCancalDate() {
		return CancalDate;
	}

	public void setCancalDate(String cancalDate) {
		CancalDate = cancalDate;
	}

	public int getManagerApprovalStatus() {
		return ManagerApprovalStatus;
	}

	public void setManagerApprovalStatus(int managerApprovalStatus) {
		ManagerApprovalStatus = managerApprovalStatus;
	}

	public int getDirectorApprovalStatus() {
		return DirectorApprovalStatus;
	}

	public void setDirectorApprovalStatus(int directorApprovalStatus) {
		DirectorApprovalStatus = directorApprovalStatus;
	}

	public UserTimeOut() {
		super();
	}

	public UserTimeOut(LeavetypeEntity timekeepingType, String offdate, String endDate, String numberDay,
			String descriptions, int status, int type, String timeIn, String timeOut, String securityTimeIn,
			String securityTimeOut, String created, DepartmentEntity deptID, UserEntity userID, UserEntity leadApproval,
			String leadApprovalDate, UserEntity managerApproval, String managerApprovalDate,
			UserEntity directorApproval, UserEntity userCancal, String userCancalDate, String cancalDate,
			int managerApprovalStatus, int directorApprovalStatus) {
		super();
		TimekeepingType = timekeepingType;
		Offdate = offdate;
		EndDate = endDate;
		NumberDay = numberDay;
		Descriptions = descriptions;
		Status = status;
		Type = type;
		TimeIn = timeIn;
		TimeOut = timeOut;
		SecurityTimeIn = securityTimeIn;
		SecurityTimeOut = securityTimeOut;
		Created = created;
		DeptID = deptID;
		UserID = userID;
		LeadApproval = leadApproval;
		LeadApprovalDate = leadApprovalDate;
		ManagerApproval = managerApproval;
		ManagerApprovalDate = managerApprovalDate;
		DirectorApproval = directorApproval;
		UserCancal = userCancal;
		UserCancalDate = userCancalDate;
		CancalDate = cancalDate;
		ManagerApprovalStatus = managerApprovalStatus;
		DirectorApprovalStatus = directorApprovalStatus;
	}

}
