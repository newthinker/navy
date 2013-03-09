package cn.com.hd.dto.priv;

import java.util.Date;

import cn.com.hd.service.BaseDTO;

/**
 * TDept entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TDept extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String deptid;
	private String deptname;
	private String spelling;
	private String superdeptid;
	private Long deptorder;
	private String remark;
	private String validated;
	private String creatorid;
	private String creatorname;
	private Date createdate;
	private String operatorid;
	private String operatorname;
	private Date operatdate;
	private String expinfoa;
	private String expinfob;
	private String expinfoc;
	private String expinfod;
	private String expinfoe;

	// Constructors

	/** default constructor */
	public TDept() {
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getSpelling() {
		return spelling;
	}

	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}

	public String getSuperdeptid() {
		return superdeptid;
	}

	public void setSuperdeptid(String superdeptid) {
		this.superdeptid = superdeptid;
	}

	public Long getDeptorder() {
		return deptorder;
	}

	public void setDeptorder(Long deptorder) {
		this.deptorder = deptorder;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getValidated() {
		return validated;
	}

	public void setValidated(String validated) {
		this.validated = validated;
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