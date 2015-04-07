package org.neo4art.htmlparser.bean;

public class Letter {
	String title="";
	String text="";
	String from="";
	String to="";
	String date="";
	
	public Letter() {
	}
	
	public Letter(String title, String text, String from, String to, String date) {
		this.title = title;
		this.text = text;
		this.from = from;
		this.to = to;
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
