package com.pojo;

public class TestObject {
	
	private String name;
	private String description;
	private int id;

	public TestObject(String name, String description, int id) {
		this.name = name;
		this.description = description;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "TestObject [name=" + name + ", description=" + description + ", id=" + id + "]";
	}

}
