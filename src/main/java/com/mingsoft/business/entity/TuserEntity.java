package com.mingsoft.business.entity;

import java.util.Date;

import com.mingsoft.basic.entity.BasicEntity;
import com.mingsoft.util.PageUtil;
/**
 * 
 * @ClassName: TuserEntity
 * @Description: 用户信息
 * @author: jk
 * @date: 2016年6月21日 下午4:24:42
 *
 */
public class TuserEntity extends BasicEntity {
	private int id;
	private String headPhoto;
	private String name;
	private String sex;
	private String mobile;
	private int point; 
	private String openId;
	private Date createTime;
	private Date modifyTime;//修改时间
	
	private PageUtil page;
	private String orderBy;
	private boolean order;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHeadPhoto() {
		return headPhoto;
	}
	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	public PageUtil getPage() {
		return page;
	}
	public void setPage(PageUtil page) {
		this.page = page;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public boolean isOrder() {
		return order;
	}
	public void setOrder(boolean order) {
		this.order = order;
	}
	
	
}
