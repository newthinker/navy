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
	private String dictcode;
	private String prodname;
	private String measurunit;
	private String prodno;
	private Double avgoutput;
	private Double maxoutput;
	private Double singlemaxoutput;
	private String singlemaxdate;
	private String remark;
	private String prodimage;		// 产品照片编号

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
	
	public String getDictcode() {
		return dictcode;
	}

	public void setDictcode(String dictcode) {
		this.dictcode = dictcode;
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

	public Double getAvgoutput() {
		return avgoutput;
	}

	public void setAvgoutput(Double avgoutput) {
		this.avgoutput = avgoutput;
	}

	public Double getMaxoutput() {
		return maxoutput;
	}

	public void setMaxoutput(Double maxoutput) {
		this.maxoutput = maxoutput;
	}

	public Double getSinglemaxoutput() {
		return singlemaxoutput;
	}

	public void setSinglemaxoutput(Double singlemaxoutput) {
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