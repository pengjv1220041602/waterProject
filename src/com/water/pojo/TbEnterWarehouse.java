package com.water.pojo;

import java.util.Date;

import com.water.validate.Required;

public class TbEnterWarehouse {
    private String id;

//    private String proId;
    private TbProduct tbProduct;
    
    @Required
//    @RegValidate(regValidate="/^\\+?[1-9]\\d*$/")
    private Integer enterWarehouseNum;

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

    /*public String getProId() {
        return proId;
    }

    public void setProId(String proId) {
        this.proId = proId == null ? null : proId.trim();
    }*/

    public Integer getEnterWarehouseNum() {
        return enterWarehouseNum;
    }

    public void setEnterWarehouseNum(Integer enterWarehouseNum) {
        this.enterWarehouseNum = enterWarehouseNum;
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

	public TbProduct getTbProduct() {
		return tbProduct;
	}

	public void setTbProduct(TbProduct tbProduct) {
		this.tbProduct = tbProduct;
	}
    
}