package cn.com.hd.dto.navy;

import java.util.Date;

import cn.com.hd.service.BaseDTO;

/**
 * TImport entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TImport extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/* id */
	private String importid;
	
	/* property */
	private String typecode;
	private String typename;
	private String importyear;
	private String planid;
	private String plan;
	private Date plandateBefore;
	private Date plandate;
	private Date plandateAfter;
	private String compactid;
	private String compact;
	private Date compactdateBefore;
	private Date compactdate;
	private Date compactdateAfter;
	private String unitid;
	private String unit;
	private String deptid;
	private String dept;
	private String classid;
	private String classname;
	private String project;
	private Double budget;
	private Double compactmoney;
	private String currencyid;
	private String currency;
	private Double rate;
	private Double rmbrate;
	private Double dollar;
	private Double rmb;
	private Double economize;
	private String modeid;
	private String modename;
	private Date deliverydate;
	private String agentid;
	private String agent;
	private String agreeid;
	private String agree;
	private String productor;
	private String supportorid;
	private String supportor;
	private String supportoraddr;
	private String examineid;
	private String examineno;
	private String importclassid;
	private String importclass;
	private String directoryid;
	private String directory;
	private String storeaddr;
	private Date usedate;
	private String useunit;
	private String usestate;
	private String image;
	private Date passdate;
	private String storetype;

	public String getImportid() {
		return importid;
	}

	public void setImportid(String importid) {
		this.importid = importid;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getImportyear() {
		return importyear;
	}

	public void setImportyear(String importyear) {
		this.importyear = importyear;
	}

	public String getPlanid() {
		return planid;
	}

	public void setPlanid(String planid) {
		this.planid = planid;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public Date getPlandate() {
		return plandate;
	}

	public void setPlandate(Date plandate) {
		this.plandate = plandate;
	}

	public String getCompactid() {
		return compactid;
	}

	public void setCompactid(String compactid) {
		this.compactid = compactid;
	}

	public String getCompact() {
		return compact;
	}

	public void setCompact(String compact) {
		this.compact = compact;
	}

	public Date getCompactdate() {
		return compactdate;
	}

	public void setCompactdate(Date compactdate) {
		this.compactdate = compactdate;
	}

	public String getUnitid() {
		return unitid;
	}

	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getClassid() {
		return classid;
	}

	public void setClassid(String classid) {
		this.classid = classid;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

	public Double getCompactmoney() {
		return compactmoney;
	}

	public void setCompactmoney(Double compactmoney) {
		this.compactmoney = compactmoney;
	}

	public String getCurrencyid() {
		return currencyid;
	}

	public void setCurrencyid(String currencyid) {
		this.currencyid = currencyid;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public Double getDollar() {
		return dollar;
	}

	public void setDollar(Double dollar) {
		this.dollar = dollar;
	}

	public Double getRmb() {
		return rmb;
	}

	public void setRmb(Double rmb) {
		this.rmb = rmb;
	}

	public Double getEconomize() {
		return economize;
	}

	public void setEconomize(Double economize) {
		this.economize = economize;
	}

	public String getModeid() {
		return modeid;
	}

	public void setModeid(String modeid) {
		this.modeid = modeid;
	}

	public String getModename() {
		return modename;
	}

	public void setModename(String modename) {
		this.modename = modename;
	}

	public Date getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getAgentid() {
		return agentid;
	}

	public void setAgentid(String agentid) {
		this.agentid = agentid;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getAgreeid() {
		return agreeid;
	}

	public void setAgreeid(String agreeid) {
		this.agreeid = agreeid;
	}

	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public String getSupportorid() {
		return supportorid;
	}

	public void setSupportorid(String supportorid) {
		this.supportorid = supportorid;
	}

	public String getSupportor() {
		return supportor;
	}

	public void setSupportor(String supportor) {
		this.supportor = supportor;
	}

	public String getSupportoraddr() {
		return supportoraddr;
	}

	public void setSupportoraddr(String supportoraddr) {
		this.supportoraddr = supportoraddr;
	}

	public String getExamineid() {
		return examineid;
	}

	public void setExamineid(String examineid) {
		this.examineid = examineid;
	}

	public String getExamineno() {
		return examineno;
	}

	public void setExamineno(String examineno) {
		this.examineno = examineno;
	}

	public String getImportclassid() {
		return importclassid;
	}

	public void setImportclassid(String importclassid) {
		this.importclassid = importclassid;
	}

	public String getImportclass() {
		return importclass;
	}

	public void setImportclass(String importclass) {
		this.importclass = importclass;
	}

	public String getDirectoryid() {
		return directoryid;
	}

	public void setDirectoryid(String directoryid) {
		this.directoryid = directoryid;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getStoreaddr() {
		return storeaddr;
	}

	public void setStoreaddr(String storeaddr) {
		this.storeaddr = storeaddr;
	}

	public Date getUsedate() {
		return usedate;
	}

	public void setUsedate(Date usedate) {
		this.usedate = usedate;
	}

	public String getUseunit() {
		return useunit;
	}

	public void setUseunit(String useunit) {
		this.useunit = useunit;
	}

	public String getUsestate() {
		return usestate;
	}

	public void setUsestate(String usestate) {
		this.usestate = usestate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getPlandateBefore() {
		return plandateBefore;
	}

	public void setPlandateBefore(Date plandateBefore) {
		this.plandateBefore = plandateBefore;
	}

	public Date getPlandateAfter() {
		return plandateAfter;
	}

	public void setPlandateAfter(Date plandateAfter) {
		this.plandateAfter = plandateAfter;
	}

	public Date getCompactdateBefore() {
		return compactdateBefore;
	}

	public void setCompactdateBefore(Date compactdateBefore) {
		this.compactdateBefore = compactdateBefore;
	}

	public Date getCompactdateAfter() {
		return compactdateAfter;
	}

	public void setCompactdateAfter(Date compactdateAfter) {
		this.compactdateAfter = compactdateAfter;
	}

	public Date getPassdate() {
		return passdate;
	}

	public void setPassdate(Date passdate) {
		this.passdate = passdate;
	}

	public String getStoretype() {
		return storetype;
	}

	public void setStoretype(String storetype) {
		this.storetype = storetype;
	}

	public Double getRmbrate() {
		return rmbrate;
	}

	public void setRmbrate(Double rmbrate) {
		this.rmbrate = rmbrate;
	}

}