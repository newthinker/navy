package cn.com.hd.dto.priv;

import cn.com.hd.service.BaseDTO;

/**
 * TUserRole entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TUserRole extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/* id */
	private String userid;
	private String roleid;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}


}