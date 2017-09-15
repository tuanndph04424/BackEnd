package com.nguyentuan.api.model;

public class DepertmentModel extends status {
	
	private int ID;
	private String Name;
	private String Descriptions;
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
	public String getDescriptions() {
		return Descriptions;
	}
	public void setDescriptions(String descriptions) {
		Descriptions = descriptions;
	}
	public DepertmentModel() {
		super();
	}
	

}
