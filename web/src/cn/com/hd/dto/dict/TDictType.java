package cn.com.hd.dto.dict;

import java.util.Date;

import cn.com.hd.service.BaseDTO;

/**
 * TDictType entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TDictType extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/* id */
	private String typeid;
	
	/* property */
	private String typename;
	
	private String typeowner;
	
	private String typeexplain;
	
	private String validated;
	
	private Integer typeorder;
	
	private String creatorid;

	private String creatorname;
	
	private Date createdate;
	
	private String operatorid;
	
	private String operatorname;
	
	private Date operatdate;

	/** default constructor */
	public TDictType() {
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getTypeowner() {
		return typeowner;
	}

	public void setTypeowner(String typeowner) {
		this.typeowner = typeowner;
	}

	public String getTypeexplain() {
		return typeexplain;
	}

	public void setTypeexplain(String typeexplain) {
		this.typeexplain = typeexplain;
	}

	public String getValidated() {
		return validated;
	}

	public void setValidated(String validated) {
		this.validated = validated;
	}

	public Integer getTypeorder() {
		return typeorder;
	}

	public void setTypeorder(Integer typeorder) {
		this.typeorder = typeorder;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getCreatorname() {
		return creatorname;
	}

	public void setCreatorname(String creatorname) {
		this.creatorname = creatorname;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getOperatorid() {
		return operatorid;
	}

	public void setOperatorid(String operatorid) {
		this.operatorid = operatorid;
	}

	public String getOperatorname() {
		return operatorname;
	}

	public void setOperatorname(String operatorname) {
		this.operatorname = operatorname;
	}

	public Date getOperatdate() {
		return operatdate;
	}

	public void setOperatdate(Date operatdate) {
		this.operatdate = operatdate;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	
}