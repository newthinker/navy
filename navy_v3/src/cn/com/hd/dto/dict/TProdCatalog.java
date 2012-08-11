package cn.com.hd.dto.dict;

import java.util.ArrayList;
import java.util.List;

import cn.com.hd.service.BaseDTO;
import cn.com.hd.transfer.DTO;

/**
 * TProdCatalog entity.
 * 产品分类编目
 */

public class TProdCatalog extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	// 当前节点编码--增/删/改节点所在层级
	private String theCode;
	// 当前节点名称--需修改的节点的名称，如果此为空，表示增加节点
	private String curName;
	// 修改后的名称--修改后的节点名称，如果此为空，表示删除节点，如果两个节点名称都不为空，表示进行节点名称修改
	private String afterName;
	
	/** default constructor */
	public TProdCatalog() {
	}

	public String getThecode() {
		return theCode;
	}
	public void setThecode(String theCode) {
		this.theCode = theCode;
	}

	public String getCurname() {
		return curName;
	}
	public void setCurname(String curName) {
		this.curName = curName;
	}

	public String getAftername() {
		return afterName;
	}
	public void setAfterName(String afterName) {
		this.afterName = afterName;
	}

}