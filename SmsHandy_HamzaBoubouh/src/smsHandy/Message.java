package smsHandy;

import java.util.Date;

public class Message {

	private String content;
	private Date date;
	private String from;
	private String to;
	
	public Message() {}
	
	public Message(String from, String to, String content, Date date) {
		this.from = from;
		this.to = to;
		this.content = content;
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
	
	@Override
	public String toString() {
		return "Message [content=" + content + ", date=" + date + ", from=" + from + ", to=" + to + "]";
	}
	
	
}
