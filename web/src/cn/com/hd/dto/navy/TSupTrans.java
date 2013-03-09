package cn.com.hd.dto.navy;

import cn.com.hd.service.BaseDTO;

/**
 * TSupTrans entity.
 * 
 */

public class TSupTrans extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String supid;
	private String comid;

	public String getSupid() {
		return supid;
	}

	public void setSupid(String Supid) {
		this.supid = Supid;
	}

	public String getComid() {
		return comid;
	}

	public void setComid(String Comid) {
		this.comid = Comid;
	}

}