package com.water.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TbCoupons {
    private String id;

    private String couponsName;

    private String couponsTimeOwn;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date couponsBeginTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date couponsEndTime;
    
    private Integer overNum;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date useEndTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date useBeginTime;

    private String couponsDesc;

    private Integer couponsNum;

    private Integer couponsPrice;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String updateUser;

    private String flag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCouponsName() {
        return couponsName;
    }

    public void setCouponsName(String couponsName) {
        this.couponsName = couponsName == null ? null : couponsName.trim();
    }

    public String getCouponsTimeOwn() {
        return couponsTimeOwn;
    }

    public void setCouponsTimeOwn(String couponsTimeOwn) {
        this.couponsTimeOwn = couponsTimeOwn == null ? null : couponsTimeOwn.trim();
    }

    public Date getCouponsBeginTime() {
        return couponsBeginTime;
    }

    public void setCouponsBeginTime(Date couponsBeginTime) {
        this.couponsBeginTime = couponsBeginTime;
    }

    public Date getCouponsEndTime() {
        return couponsEndTime;
    }

    public void setCouponsEndTime(Date couponsEndTime) {
        this.couponsEndTime = couponsEndTime;
    }

    public Date getUseEndTime() {
        return useEndTime;
    }

    public void setUseEndTime(Date useEndTime) {
        this.useEndTime = useEndTime;
    }

    public Date getUseBeginTime() {
        return useBeginTime;
    }

    public void setUseBeginTime(Date useBeginTime) {
        this.useBeginTime = useBeginTime;
    }

    public String getCouponsDesc() {
        return couponsDesc;
    }

    public void setCouponsDesc(String couponsDesc) {
        this.couponsDesc = couponsDesc == null ? null : couponsDesc.trim();
    }

    public Integer getCouponsNum() {
        return couponsNum;
    }

    public void setCouponsNum(Integer couponsNum) {
        this.couponsNum = couponsNum;
    }

    public Integer getCouponsPrice() {
        return couponsPrice;
    }

    public void setCouponsPrice(Integer couponsPrice) {
        this.couponsPrice = couponsPrice;
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
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

	public Integer getOverNum() {
		return overNum;
	}

	public void setOverNum(Integer overNum) {
		this.overNum = overNum;
	}
    
}