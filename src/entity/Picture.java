package entity;

import java.io.Serializable;

public class Picture implements Serializable {
   private int id;
   private String title;
   private String content;
   private String url;
   private int user_id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
   
}
