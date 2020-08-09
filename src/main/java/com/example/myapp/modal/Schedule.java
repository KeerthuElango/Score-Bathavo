package com.example.myapp.modal;

public class Schedule {
	private String unique_id;
	private String name;
	private String date;
	private String description;
	
	public Schedule(String unique_id, String name, String date) {
		super();
		this.unique_id = unique_id;
		this.name = name;
		this.date = date;
	}
	
	public Schedule(String description) {
		super();
		this.description = description;
	}

	public String getUnique_id() {
		return unique_id;
	}
	public String getName() {
		return name;
	}
	public String getDate() {
		return date;
	}
	public String getDescription() {
		return description;
	}

}
