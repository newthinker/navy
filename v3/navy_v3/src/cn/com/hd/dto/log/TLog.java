package cn.com.hd.dto.log;

import java.util.Date;

import cn.com.hd.service.BaseDTO;

/**
 * TDictInfo generated by MyEclipse Persistence Tools
 */

public class TLog extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String logid;
	private String systemname;
	private String subsystemname;
	private String servicename;
	private String classname;
	private String operatorid;
	private String operatorname;
	private String operatordept;
	private String logtype;
	private Date logdate;
	private String logcontent;
	private String attributea;
	private String attributeb;
	private String attributec;
	private String attributed;
	private String attributee;

	/** default constructor */
	public TLog() {
	}

	public String getLogid() {
		return logid;
	}

	public void setLogid(String logid) {
		this.logid = logid;
	}

	public String getSystemname() {
		return systemname;
	}

	public void setSystemname(String systemname) {
		this.systemname = systemname;
	}

	public String getSubsystemname() {
		return subsystemname;
	}

	public void setSubsystemname(String subsystemname) {
		this.subsystemname = subsystemname;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
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

	public String getOperatordept() {
		return operatordept;
	}

	public void setOperatordept(String operatordept) {
		this.operatordept = operatordept;
	}

	public String getLogtype() {
		return logtype;
	}

	public void setLogtype(String logtype) {
		this.logtype = logtype;
	}

	public Date getLogdate() {
		return logdate;
	}

	public void setLogdate(Date logdate) {
		this.logdate = logdate;
	}

	public String getLogcontent() {
		return logcontent;
	}

	public void setLogcontent(String logcontent) {
		this.logcontent = logcontent;
	}

	public String getAttributea() {
		return attributea;
	}

	public void setAttributea(String attributea) {
		this.attributea = attributea;
	}

	public String getAttributeb() {
		return attributeb;
	}

	public void setAttributeb(String attributeb) {
		this.attributeb = attributeb;
	}

	public String getAttributec() {
		return attributec;
	}

	public void setAttributec(String attributec) {
		this.attributec = attributec;
	}

	public String getAttributed() {
		return attributed;
	}

	public void setAttributed(String attributed) {
		this.attributed = attributed;
	}

	public String getAttributee() {
		return attributee;
	}

	public void setAttributee(String attributee) {
		this.attributee = attributee;
	}

}