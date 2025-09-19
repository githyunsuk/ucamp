package com.ucamp.mission.day4;

public class Employee {

	private String id;
	private String name;
	private String password;
	private String dname;

	public Employee() {
		super();
	}

	public Employee(String id, String name, String password, String dname) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.dname = dname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return id + " - " + name + " - " + dname; 
	}

}
