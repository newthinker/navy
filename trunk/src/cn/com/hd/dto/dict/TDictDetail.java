package cn.com.hd.dto.dict;

import java.util.Date;

import cn.com.hd.service.BaseDTO;

/**
 * TDictDetail entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TDictDetail extends BaseDTO {

	private static final long serialVersionUID = 1L;

	/* id */
	private String dictcode;

	private String typeid;

	/* property */
	private String dictname;

	private String dictowner;

	private String spelling;

	private String fathercode;

	private String relevancecode;

	private Integer dictorder;

	private String dictexplain;

	private String validated;

	private String dictremark;

	private String havechild;

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

	public TDictDetail() {
	}

	public String getDictcode() {
		return dictcode;
	}

	public void setDictcode(String dictcode) {
		this.dictcode = dictcode;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getDictname() {
		return dictname;
	}

	public void setDictname(String dictname) {
		this.dictname = dictname;
	}

	public String getDictowner() {
		return dictowner;
	}

	public void setDictowner(String dictowner) {
		this.dictowner = dictowner;
	}

	public String getSpelling() {
		return spelling;
	}

	public void setSpelling(String spelling) {
		this.spelling = spelling;
	}

	public String getFathercode() {
		return fathercode;
	}

	public void setFathercode(String fathercode) {
		this.fathercode = fathercode;
	}

	public String getRelevancecode() {
		return relevancecode;
	}

	public void setRelevancecode(String relevancecode) {
		this.relevancecode = relevancecode;
	}

	public Integer getDictorder() {
		return dictorder;
	}

	public void setDictorder(Integer dictorder) {
		this.dictorder = dictorder;
	}

	public String getDictexplain() {
		return dictexplain;
	}

	public void setDictexplain(String dictexplain) {
		this.dictexplain = dictexplain;
	}

	public String getValidated() {
		return validated;
	}

	public void setValidated(String validated) {
		this.validated = validated;
	}

	public String getDictremark() {
		return dictremark;
	}

	public void setDictremark(String dictremark) {
		this.dictremark = dictremark;
	}

	public String getHavechild() {
		return havechild;
	}

	public void setHavechild(String havechild) {
		this.havechild = havechild;
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