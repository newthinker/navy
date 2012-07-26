package cn.com.hd.dto.navy;

import java.util.Date;

import cn.com.hd.service.BaseDTO;

/**
 * TStockholder entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public class TStockholder extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String stockholderid;
	private String supid;
	private String stockholdername;
	private Double capital;
	private String ratio;
	private Date stockdate;

	public String getStockholderid() {
		return stockholderid;
	}

	public void setStockholderid(String stockholderid) {
		this.stockholderid = stockholderid;
	}

	public String getSupid() {
		return supid;
	}

	public void setSupid(String supid) {
		this.supid = supid;
	}

	public String getStockholdername() {
		return stockholdername;
	}

	public void setStockholdername(String stockholdername) {
		this.stockholdername = stockholdername;
	}

	public Double getCapital() {
		return capital;
	}

	public void setCapital(Double capital) {
		this.capital = capital;
	}

	public String getRatio() {
		return ratio;
	}

	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

	public Date getStockdate() {
		return stockdate;
	}

	public void setStockdate(Date date) {
		this.stockdate = date;
	}

}