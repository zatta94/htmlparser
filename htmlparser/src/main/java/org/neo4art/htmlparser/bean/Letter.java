package org.neo4art.htmlparser.bean;

public class Letter {
	String luogo="";
	String text="";
	String from="Vincent van Gogh";
	String to="";
	String date="";
	String url="";
	
	public Letter() {
	}
	
	public Letter(String luogo, String text, String from, String to, String date, String url) {
		this.luogo = luogo;
		this.text = text;
		this.from = from;
		this.to = to;
		this.date = date;
		this.url = url;
	}
	public String getLuogo() {
		return luogo;
	}
	public String getUrl(){
		return url;
	}
	public void setUrl(String url){
		this.url = url;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
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
