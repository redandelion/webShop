package domain;

import java.sql.Date;

public class Comment
{
	private String uid;
	private int cid;
	private String message;
	private Date com_time;
	private int evaluate;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCom_time() {
		return com_time;
	}
	public void setCom_time(Date com_time) {
		this.com_time = com_time;
	}
	public int getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(int evaluate) {
		this.evaluate = evaluate;
	}
	
}
