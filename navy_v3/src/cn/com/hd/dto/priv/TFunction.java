package cn.com.hd.dto.priv;

import java.util.Date;

import cn.com.hd.service.BaseDTO;

/**
 * TFunction entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TFunction extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/* id */
	private String functionid;
	
	/* property */
	private String functionname;
	private String superfunctionid;
	private String validated;
	private String functionurl;
	private String functiontype;
	private Long functionorder;
	private String remark;
	private String creatorid;
	private String creator;
	private Date createdate;
	private String operatorid;
	private String operator;
	private Date opdate;
	private String expinfoa;
	private String expinfob;
	private String expinfoc;
	private String expinfod;
	private String expinfoe;

	/** default constructor */
	public TFunction() {
	}

	public String getFunctionid() {
		return functionid;
	}

	public void setFunctionid(String functionid) {
		this.functionid = functionid;
	}

	public String getFunctionname() {
		return functionname;
	}

	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}

	public String getSuperfunctionid() {
		return superfunctionid;
	}

	public void setSuperfunctionid(String superfunctionid) {
		this.superfunctionid = superfunctionid;
	}

	public String getValidated() {
		return validated;
	}

	public void setValidated(String validated) {
		this.validated = validated;
	}

	public String getFunctionurl() {
		return functionurl;
	}

	public void setFunctionurl(String functionurl) {
		this.functionurl = functionurl;
	}

	public String getFunctiontype() {
		return functiontype;
	}

	public void setFunctiontype(String functiontype) {
		this.functiontype = functiontype;
	}

	public Long getFunctionorder() {
		return functionorder;
	}

	public void setFunctionorder(Long functionorder) {
		this.functionorder = functionorder;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreatorid() {
		return creatorid;
	}

	public void setCreatorid(String creatorid) {
		this.creatorid = creatorid;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
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

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getOpdate() {
		return opdate;
	}

	public void setOpdate(Date opdate) {
		this.opdate = opdate;
	}

	public String getExpinfoa() {
		return expinfoa;
	}

	public void setExpinfoa(String expinfoa) {
		this.expinfoa = expinfoa;
	}

	public String getExpinfob() {
		return expinfob;
	}

	public void setExpinfob(String expinfob) {
		this.expinfob = expinfob;
	}

	public String getExpinfoc() {
		return expinfoc;
	}

	public void setExpinfoc(String expinfoc) {
		this.expinfoc = expinfoc;
	}

	public String getExpinfod() {
		return expinfod;
	}

	public void setExpinfod(String expinfod) {
		this.expinfod = expinfod;
	}

	public String getExpinfoe() {
		return expinfoe;
	}

	public void setExpinfoe(String expinfoe) {
		this.expinfoe = expinfoe;
	}

}