package com.pushing.app.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Info {
	private int id;
	private String title;
	private String content;
	private Date date;
	
	//��ʶ��
	public int getid(){
		return id;
	}
	public void setid(int id){
		this.id=id;
	}
	//����
	public String getTitle(){
		return content;
	}
	public void setTitle(String title){
		this.title=title;
	}
	//����
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content=content;
	}
	//����
	public Date getDate(){
		return date;
	}
	public void setDate(String str) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.date=sdf.parse(str);
	}
}
