package cn.com.hd.dto.navy;

import cn.com.hd.service.BaseDTO;

/**
 * THighWay entity.
 * 
 */

public class THighWay extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String comid;
	private String hiwid;
	private String hiwname;
	private String hiwin;
	private String hiwinid;
	private Double hiwdis;
	
	public THighWay() {
		comid = "";
		hiwname = "";
	}

	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public String getHiwid() {
		return hiwid;
	}

	public void setHiwid(String hiwid) {
		this.hiwid = hiwid;
	}

	public String getHiwname() {
		return hiwname;
	}

	public void setHiwname(String hiwname) {
		this.hiwname = hiwname;
	}

	public String getHiwin() {
		return hiwin;
	}

	public void setHiwin(String hiwin) {
		this.hiwin = hiwin;
	}

	public String getHiwinid() {
		return hiwinid;
	}

	public void setHiwinid(String hiwinid) {
		this.hiwinid = hiwinid;
	}

	public Double getHiwdis() {
		return hiwdis;
	}

	public void setHiwdis(Double hiwdis) {
		this.hiwdis = hiwdis;
	}

}