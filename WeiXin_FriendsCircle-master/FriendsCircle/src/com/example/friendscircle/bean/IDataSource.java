package com.example.friendscircle.bean;

import java.util.List;

public interface IDataSource {

	/**
	 * ˵˵�û���
	 * @return
	 */
	String getUsername();

	/**
	 * ˵˵����
	 * @return
	 */
	long getDate();

	/**
	 * ˵˵Logo
	 * @return
	 */
	int getmLogo();

	/**
	 * �����˵�Logo   ResourceID
	 * @return
	 */
	int[] getZanLogos();

	/**
	 * ������
	 * @return
	 */
	int getZanCount();

	/**
	 * ��������
	 * @return
	 */
	List<CommonBean> getCommonBeans();

	/**
	 * ������
	 * @return
	 */
	int getCommonCount();
	
}
