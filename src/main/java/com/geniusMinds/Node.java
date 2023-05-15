package com.geniusMinds;

public class Node {
	String id;
	String type;
	int data;
	
	public Node() {
		
	}

	public Node(String id, String type, int data) {
		super();
		this.id = id;
		this.type = type;
		this.data = data;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Node [id=" + id + ", type=" + type + ", data=" + data + "]";
	}
	
}
