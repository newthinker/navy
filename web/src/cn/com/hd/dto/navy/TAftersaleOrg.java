package cn.com.hd.dto.navy;

import cn.com.hd.service.BaseDTO;

/**
 * TAftersaleOrg entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TAftersaleOrg extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String orgid;
	private String supid;
	private String orgname;
	private String orgtype;
	private String location;
	private String director;
	private String phone;
	private String orgtypeid;

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getSupid() {
		return supid;
	}

	public void setSupid(String supid) {
		this.supid = supid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getOrgtype() {
		return orgtype;
	}

	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrgtypeid() {
		return orgtypeid;
	}

	public void setOrgtypeid(String orgtypeid) {
		this.orgtypeid = orgtypeid;
	}

}