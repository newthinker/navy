package cn.com.hd.dto.dict;

import java.util.ArrayList;
import java.util.List;

import cn.com.hd.service.BaseDTO;
import cn.com.hd.transfer.DTO;

/**
 * TProductType entity.
 * 
 */

public class TProductType extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/* id */
	private String dictcode;
	
	/* property */
	private String dictname;
	
//	private String fathercode;
//	
//	private List children;

	/** default constructor */
	public TProductType() {
	}

	public String getDictcode() {
		return dictcode;
	}

	public void setDictcode(String value) {
		this.dictcode = value;
	}

	public String getDictname() {
		return dictname;
	}

	public void setDictname(String value) {
		this.dictname = value;
	}

//	public String getFathercode() {
//		return fathercode;
//	}
//
//	public void setFathercode(String value) {
//		this.fathercode = value;
//	}
//
//	public List getChildren() {
//		return children;
//	}
//
//	public void setChildren(DTO value) {
//		if (this.children == null)
//		{
//			this.children = new ArrayList();
//			this.children.add(value);
//		}
//		else
//		{
//			this.children.add(value);
//		}
//	}
//
//	public void setChildren(List value) {
//		this.children = value;
//	}
	
}