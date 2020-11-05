package com.bouvet.web.jdbc;

public class Todo {
	private int id;
	private String descrip;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	@Override
	public String toString() {
		return "Todo [id=" + id + ", descrip=" + descrip + "]";
	}
	public Todo(int id, String descrip) {
		super();
		this.id = id;
		this.descrip = descrip;
	}
}
