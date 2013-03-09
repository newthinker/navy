package cn.com.hd.dto.dict;

import cn.com.hd.service.BaseDTO;

/**
 * TDictType entity.
 * 
 */

public class TDictArea extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/* id */
	private String areacode;
	
	/* property */
	private String areaname;
	
	private String parentcodeid;

	/** default constructor */
	public TDictArea() {
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String value) {
		this.areacode = value;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String value) {
		this.areaname = value;
	}

	public String getParentcodeid() {
		return parentcodeid;
	}

	public void setParentcodeid(String value) {
		this.parentcodeid = value;
	}
	
}