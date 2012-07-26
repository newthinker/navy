package cn.com.hd.dto.navy;

import cn.com.hd.service.BaseDTO;

/**
 * TSupProduct entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TSupProduct extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String prodid;
	private String supid;
	private String goodname;
	private String prodname;
	private String measurunit;
	private String prodno;
	private String avgoutput;
	private String maxoutput;
	private String singlemaxoutput;
	private String singlemaxdate;
	private String remark;
	private String prodimage;		// ²úÆ·ÕÕÆ¬±àºÅ

	public String getProdid() {
		return prodid;
	}

	public void setProdid(String prodid) {
		this.prodid = prodid;
	}

	public String getSupid() {
		return supid;
	}

	public void setSupid(String supid) {
		this.supid = supid;
	}

	public String getGoodname() {
		return goodname;
	}

	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}

	public String getProdname() {
		return prodname;
	}

	public void setProdname(String prodname) {
		this.prodname = prodname;
	}

	public String getMeasurunit() {
		return measurunit;
	}

	public void setMeasurunit(String measurunit) {
		this.measurunit = measurunit;
	}

	public String getProdno() {
		return prodno;
	}

	public void setProdno(String prodno) {
		this.prodno = prodno;
	}

	public String getAvgoutput() {
		return avgoutput;
	}

	public void setAvgoutput(String avgoutput) {
		this.avgoutput = avgoutput;
	}

	public String getMaxoutput() {
		return maxoutput;
	}

	public void setMaxoutput(String maxoutput) {
		this.maxoutput = maxoutput;
	}

	public String getSinglemaxoutput() {
		return singlemaxoutput;
	}

	public void setSinglemaxoutput(String singlemaxoutput) {
		this.singlemaxoutput = singlemaxoutput;
	}

	public String getSinglemaxdate() {
		return singlemaxdate;
	}

	public void setSinglemaxdate(String singlemaxdate) {
		this.singlemaxdate = singlemaxdate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getProdimage() {
		return prodimage;
	}
	
	public void setProdimage(String prodimage) {
		this.prodimage = prodimage ;
	}
}