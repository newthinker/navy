package cn.com.hd.dto.navy;

import cn.com.hd.service.BaseDTO;

/**
 * TProveInfo entity.
 * 
 */

public class TProveInfo extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String supid;
	private String provename;
	private String imageid;

	public String getSupid() {
		return supid;
	}

	public void setSupid(String Supid) {
		this.supid = supid;
	}

	public String getProvename() {
		return provename;
	}

	public void setProvename(String provename) {
		this.provename = provename;
	}

	public String getImageid() {
		return imageid;
	}

	public void setImageid(String imageid) {
		this.imageid = imageid;
	}

}