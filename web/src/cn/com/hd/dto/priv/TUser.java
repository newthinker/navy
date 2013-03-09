package cn.com.hd.dto.priv;

import java.util.Date;

import cn.com.hd.service.BaseDTO;

/**
 * TUser entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TUser extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/* id */
	private String userid;
	
	/* property */
	private String deptid;
	private String username;
	private String useralias;
	private String loginname;
	private String loginpass;
	private String remark;
	private String validated;
	private String creatorid;
	private String creator;
	private Date creatordate;
	private String operatorid;
	private String operator;
	private Date opdate;
	private String expinfoa;
	private String expinfob;
	private String expinfoc;
	private String expinfod;
	private String expinfoe;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseralias() {
		return useralias;
	}

	public void setUseralias(String useralias) {
		this.useralias = useralias;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginpass() {
		return loginpass;
	}

	public void setLoginpass(String loginpass) {
		this.loginpass = loginpass;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getValidated() {
		return validated;
	}

	public void setValidated(String validated) {
		this.validated = validated;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreatordate() {
		return creatordate;
	}

	public void setCreatordate(Date creatordate) {
		this.creatordate = creatordate;
	}

	public String getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(String operatorid) {
		this.operatorid = operatorid;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getOpdate() {
		return opdate;
	}

	public void setOpdate(Date opdate) {
		this.opdate = opdate;
	}

	public String getExpinfoa() {
		return expinfoa;
	}

	public void setExpinfoa(String expinfoa) {
		this.expinfoa = expinfoa;
	}

	public String getExpinfob() {
		return expinfob;
	}

	public void setExpinfob(String expinfob) {
		this.expinfob = expinfob;
	}

	public String getExpinfoc() {
		return expinfoc;
	}

	public void setExpinfoc(String expinfoc) {
		this.expinfoc = expinfoc;
	}

	public String getExpinfod() {
		return expinfod;
	}

	public void setExpinfod(String expinfod) {
		this.expinfod = expinfod;
	}

	public String getExpinfoe() {
		return expinfoe;
	}

	public void setExpinfoe(String expinfoe) {
		this.expinfoe = expinfoe;
	}

}