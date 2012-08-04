package cn.com.hd.dto.priv;

import cn.com.hd.service.BaseDTO;

/**
 * TRoleFunc entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TRoleFunc extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/* id */
	private String roleid;
	private String functionid;

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getFunctionid() {
		return functionid;
	}

	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}

}