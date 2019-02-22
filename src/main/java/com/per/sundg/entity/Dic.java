package com.per.sundg.entity;

import java.io.Serializable;
import java.util.Date;

public class Dic implements Serializable {
	private int dicId;
    private String dicType;
    private String dicName;
    private String dicKey;
    private double dicValue;
    private int createBy;
    private Date createDate;
    private int lastUpdateBy;
    private Date LastUpdateDate;
	public int getDicId() {
		return dicId;
	}
	public void setDicId(int dicId) {
		this.dicId = dicId;
	}
	public String getDicType() {
		return dicType;
	}
	public void setDicType(String dicType) {
		this.dicType = dicType;
	}
	public String getDicName() {
		return dicName;
	}
	public void setDicName(String dicName) {
		this.dicName = dicName;
	}
	public String getDicKey() {
		return dicKey;
	}
	public void setDicKey(String dicKey) {
		this.dicKey = dicKey;
	}
	public double getDicValue() {
		return dicValue;
	}
	public void setDicValue(double dicValue) {
		this.dicValue = dicValue;
	}
	public int getCreateBy() {
		return createBy;
	}
	public void setCreateBy(int createBy) {
		this.createBy = createBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getLastUpdateBy() {
		return lastUpdateBy;
	}
	public void setLastUpdateBy(int lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	public Date getLastUpdateDate() {
		return LastUpdateDate;
	}
	public void setLastUpdateDate(Date lastUpdateDate) {
		LastUpdateDate = lastUpdateDate;
	}
    
    
}
