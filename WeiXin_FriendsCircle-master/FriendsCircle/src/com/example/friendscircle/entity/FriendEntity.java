package com.example.friendscircle.entity;

public class FriendEntity {
	private int otherlayout;  //0����һ�� 1������һ��
	private String name;
	private int images;  //ͷ��
	private int contentimages;  //ͷ��
	private String content; //����
	private String date;   //����ʱ��
	private String praise;  //������
	private String commentary; //���� 
	public int getImages() {
		return images;
	}
	public void setImages(int images) {
		this.images = images;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPraise() {
		return praise;
	}
	public void setPraise(String praise) {
		this.praise = praise;
	}
	public String getCommentary() {
		return commentary;
	}
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOtherlayout() {
		return otherlayout;
	}
	public void setOtherlayout(int otherlayout) {
		this.otherlayout = otherlayout;
	}
	public int getContentimages() {
		return contentimages;
	}
	public void setContentimages(int contentimages) {
		this.contentimages = contentimages;
	}
	
}
