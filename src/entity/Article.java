package entity;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {

	private int id;
	private int clickNum;
	private String picture;
	private String title;
	private String content;
	private String put_date;
	private int user_id;
	private int articletype_id;
	private String user_name;
	
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public int getClickNum() {
		return clickNum;
	}
	public void setClickNum(int clickNum) {
		this.clickNum = clickNum;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPut_date() {
		return put_date;
	}
	public void setPut_date(String put_date) {
		this.put_date = put_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getArticletype_id() {
		return articletype_id;
	}
	public void setArticletype_id(int articletype_id) {
		this.articletype_id = articletype_id;
	}
	
}
