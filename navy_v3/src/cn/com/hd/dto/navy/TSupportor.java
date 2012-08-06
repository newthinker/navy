package cn.com.hd.dto.navy;

import java.util.Date;

import cn.com.hd.service.BaseDTO;

/**
 * TSupportor entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TSupportor extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	/* id */
	private String supid;
	
	/* property */
	private String supname;
	private String supenname;
	private Date createdate;
	private String abbreviation;
	private String address;
	private String postcode;
	private String netaddr;
	private String organizecode;
	private String economy;
	private String typecode;
	private String type;
	private String bankid;
	private String bank;
	private String account;
	private String creditid;
	private String credit;
	private String creditorg;
	private Date creditdate;
	private String insurance;
	private String illegal;
	private String corporation;
	private String corpphone;
	private String corpmobile;
	private String contact;
	private String contactphone;
	private String contactmobile;
	private String contactfax;
	private String contactemail;
	private String licno;
	private String licorg;
	private Double liccapital;
	private String licaddr;
	private Date licvalstart;
	private Date licvalend;
	private Date licexadate;
	private String licmainopt;
	private String licotheropt;
	private String statetaxno;
	private String localtaxno;
	private String statetaxorg;
	private String localtaxorg;
	private Date statetaxvalstart;
	private Date statetaxvalend;
	private Date localtaxvalstart;
	private Date localtaxvalend;
	private String ifstatetax;
	private String iflocaltax;
	private String suptypecode;
	private String suptype;
	private String location;
	private String summary;
	private String image;
	private String productsclass;
	private String manufacturercontact;
	private String manufacturerphone;
	private String manufacturerfax;
	private String manufactureremail;
	private String manufactureraddress;
	private String manufacturerperformance;
	private String manufacturersummary;
	private String manufacturer;
	
	private String l1loc;					// 供应商所在省/地区
	private String l2loc;					// 供应商所在市
	private String longitude;				// 经度
	private String latitude;				// 纬度
	private Double storehousearea;			// 仓库总面积
	private Double warehousearea;			// 货场总面积
	private String storehouseimage;			// 仓库照片
	private String auditlast3y;				// 近三年审计报告压缩文件
	private String licbusimage;				// 营业执照扫描件
	private String orgstrimage;				// 组织结构代码证扫描件
	private String purchasetype;			// 采购方式
	private String ifturnover;				// 是否成交

	public String getSupid() {
		return supid;
	}

	public void setSupid(String supid) {
		this.supid = supid;
	}

	public String getSupname() {
		return supname;
	}

	public void setSupname(String supname) {
		this.supname = supname;
	}

	public String getSupenname() {
		return supenname;
	}

	public void setSupenname(String supenname) {
		this.supenname = supenname;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getNetaddr() {
		return netaddr;
	}

	public void setNetaddr(String netaddr) {
		this.netaddr = netaddr;
	}

	public String getOrganizecode() {
		return organizecode;
	}

	public void setOrganizecode(String organizecode) {
		this.organizecode = organizecode;
	}

	public String getEconomy() {
		return economy;
	}

	public void setEconomy(String economy) {
		this.economy = economy;
	}

	public String getTypecode() {
		return typecode;
	}

	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBankid() {
		return bankid;
	}

	public void setBankid(String bankid) {
		this.bankid = bankid;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCreditid() {
		return creditid;
	}

	public void setCreditid(String creditid) {
		this.creditid = creditid;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getCreditorg() {
		return creditorg;
	}

	public void setCreditorg(String creditorg) {
		this.creditorg = creditorg;
	}

	public Date getCreditdate() {
		return creditdate;
	}

	public void setCreditdate(Date creditdate) {
		this.creditdate = creditdate;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public String getIllegal() {
		return illegal;
	}

	public void setIllegal(String illegal) {
		this.illegal = illegal;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public String getCorpphone() {
		return corpphone;
	}

	public void setCorpphone(String corpphone) {
		this.corpphone = corpphone;
	}

	public String getCorpmobile() {
		return corpmobile;
	}

	public void setCorpmobile(String corpmobile) {
		this.corpmobile = corpmobile;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getContactphone() {
		return contactphone;
	}

	public void setContactphone(String contactphone) {
		this.contactphone = contactphone;
	}

	public String getContactmobile() {
		return contactmobile;
	}

	public void setContactmobile(String contactmobile) {
		this.contactmobile = contactmobile;
	}

	public String getContactfax() {
		return contactfax;
	}

	public void setContactfax(String contactfax) {
		this.contactfax = contactfax;
	}

	public String getContactemail() {
		return contactemail;
	}

	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}

	public String getLicno() {
		return licno;
	}

	public void setLicno(String licno) {
		this.licno = licno;
	}

	public String getLicorg() {
		return licorg;
	}

	public void setLicorg(String licorg) {
		this.licorg = licorg;
	}

	public Double getLiccapital() {
		return liccapital;
	}

	public void setLiccapital(Double liccapital) {
		this.liccapital = liccapital;
	}

	public String getLicaddr() {
		return licaddr;
	}

	public void setLicaddr(String licaddr) {
		this.licaddr = licaddr;
	}

	public Date getLicvalstart() {
		return licvalstart;
	}

	public void setLicvalstart(Date licvalstart) {
		this.licvalstart = licvalstart;
	}

	public Date getLicvalend() {
		return licvalend;
	}

	public void setLicvalend(Date licvalend) {
		this.licvalend = licvalend;
	}

	public Date getLicexadate() {
		return licexadate;
	}

	public void setLicexadate(Date licexadate) {
		this.licexadate = licexadate;
	}

	public String getLicmainopt() {
		return licmainopt;
	}

	public void setLicmainopt(String licmainopt) {
		this.licmainopt = licmainopt;
	}

	public String getLicotheropt() {
		return licotheropt;
	}

	public void setLicotheropt(String licotheropt) {
		this.licotheropt = licotheropt;
	}

	public String getStatetaxno() {
		return statetaxno;
	}

	public void setStatetaxno(String statetaxno) {
		this.statetaxno = statetaxno;
	}

	public String getLocaltaxno() {
		return localtaxno;
	}

	public void setLocaltaxno(String localtaxno) {
		this.localtaxno = localtaxno;
	}

	public String getStatetaxorg() {
		return statetaxorg;
	}

	public void setStatetaxorg(String statetaxorg) {
		this.statetaxorg = statetaxorg;
	}

	public String getLocaltaxorg() {
		return localtaxorg;
	}

	public void setLocaltaxorg(String localtaxorg) {
		this.localtaxorg = localtaxorg;
	}

	public Date getStatetaxvalstart() {
		return statetaxvalstart;
	}

	public void setStatetaxvalstart(Date statetaxvalstart) {
		this.statetaxvalstart = statetaxvalstart;
	}

	public Date getStatetaxvalend() {
		return statetaxvalend;
	}

	public void setStatetaxvalend(Date statetaxvalend) {
		this.statetaxvalend = statetaxvalend;
	}

	public Date getLocaltaxvalstart() {
		return localtaxvalstart;
	}

	public void setLocaltaxvalstart(Date localtaxvalstart) {
		this.localtaxvalstart = localtaxvalstart;
	}

	public Date getLocaltaxvalend() {
		return localtaxvalend;
	}

	public void setLocaltaxvalend(Date localtaxvalend) {
		this.localtaxvalend = localtaxvalend;
	}

	public String getIfstatetax() {
		return ifstatetax;
	}

	public void setIfstatetax(String ifstatetax) {
		this.ifstatetax = ifstatetax;
	}

	public String getIflocaltax() {
		return iflocaltax;
	}

	public void setIflocaltax(String iflocaltax) {
		this.iflocaltax = iflocaltax;
	}

	public String getSuptypecode() {
		return suptypecode;
	}

	public void setSuptypecode(String suptypecode) {
		this.suptypecode = suptypecode;
	}

	public String getSuptype() {
		return suptype;
	}

	public void setSuptype(String suptype) {
		this.suptype = suptype;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLocation() {
		return this.location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getProductsclass() {
		return productsclass;
	}

	public void setProductsclass(String productsclass) {
		this.productsclass = productsclass;
	}

	public String getManufacturercontact() {
		return manufacturercontact;
	}

	public void setManufacturercontact(String manufacturercontact) {
		this.manufacturercontact = manufacturercontact;
	}

	public String getManufacturerphone() {
		return manufacturerphone;
	}

	public void setManufacturerphone(String manufacturerphone) {
		this.manufacturerphone = manufacturerphone;
	}

	public String getManufacturerfax() {
		return manufacturerfax;
	}

	public void setManufacturerfax(String manufacturerfax) {
		this.manufacturerfax = manufacturerfax;
	}

	public String getManufactureremail() {
		return manufactureremail;
	}

	public void setManufactureremail(String manufactureremail) {
		this.manufactureremail = manufactureremail;
	}

	public String getManufactureraddress() {
		return manufactureraddress;
	}

	public void setManufactureraddress(String manufactureraddress) {
		this.manufactureraddress = manufactureraddress;
	}

	public String getManufacturerperformance() {
		return manufacturerperformance;
	}

	public void setManufacturerperformance(String manufacturerperformance) {
		this.manufacturerperformance = manufacturerperformance;
	}

	public String getManufacturersummary() {
		return manufacturersummary;
	}

	public void setManufacturersummary(String manufacturersummary) {
		this.manufacturersummary = manufacturersummary;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	////////////////////////////////////////////////////////////////////////////
	public String getL1Loc() {
		return l1loc;
	}
	
	public void setL1Loc(String l1loc) {
		this.l1loc = l1loc;
	}
	
	public String getL2Loc() {
		return l2loc;
	}
	
	public void setL2Loc(String l2loc) {
		this.l2loc = l2loc;
	}	

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}	
	
	public Double getStorehousearea() {
		return storehousearea;
	}
	
	public void setStorehousearea ( Double storehousearea ) {
		this.storehousearea = storehousearea;
	}
	
	public Double getWarehousearea () {
		return warehousearea;
	}
	
	public void setWarehousearea ( Double warehousearea ) {
		this.warehousearea = warehousearea;
	}
	
	public String getStorehouseimage () {
		return storehouseimage;
	}
	
	public void setStorehouseimage ( String storehouseimage ) {
		this.storehouseimage = storehouseimage;
	}
	
	public String getAuditlast3y () {
		return auditlast3y;
	}
	
	public void setAuditlast3y ( String auditlast3y ) {
		this.auditlast3y = auditlast3y;
	}
	
	public String getLicbusimage () {
		return licbusimage;
	}
	
	public void setLicbusimage ( String licbusimage ) {
		this.licbusimage = licbusimage;
	}
	
	public String getOrgstrimage () {
		return orgstrimage;
	}
	
	public void setOrgstrimage ( String orgstrimage ) {
		this.orgstrimage = orgstrimage;
	}
	
	public String getPurchasetype () {
		return purchasetype;
	}
	
	public void setPurchasetype ( String purchasetype ) {
		this.purchasetype = purchasetype;
	}
	
	public String getIfturnover () {
		return ifturnover;
	}
	
	public void setIfturnover ( String iftureover ) {
		this.ifturnover = ifturnover;
	}
}