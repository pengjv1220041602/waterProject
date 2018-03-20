package com.water.pojo;

import java.util.Date;

public class TbCouponsUserVO {
	
	private String id;
	private TbCoupons tbCoupons;
	private TbUser tbUser;
	private Date createTime;
	private Date updateTime;
	private String createUser;
	private String updateUser;
	private Integer couponsNum;
	private String flag ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public TbCoupons getTbCoupons() {
		return tbCoupons;
	}
	public void setTbCoupons(TbCoupons tbCoupons) {
		this.tbCoupons = tbCoupons;
	}
	public TbUser getTbUser() {
		return tbUser;
	}
	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Integer getCouponsNum() {
		return couponsNum;
	}
	public void setCouponsNum(Integer couponsNum) {
		this.couponsNum = couponsNum;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
