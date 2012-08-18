package cn.com.hd.dto.navy;

import cn.com.hd.service.BaseDTO;

/**
 * TTransport entity.
 * 
 */

public class TTransport extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String comid;
	private String comname;
	private String trucktypeid;
	private String trucktype;
	private Double deadweight;
	private Integer count;
	private String nearrailway;
	private Double rwdis;
	private String nearport;
	private Double portdis;
	private String nearairport;
	private Double apdis;		

	public String getComid() {
		return comid;
	}

	public void setComid(String comid) {
		this.comid = comid;
	}

	public String getComname() {
		return comname;
	}

	public void setComname(String comname) {
		this.comname = comname;
	}

	public String getTrucktypeid() {
		return trucktypeid;
	}

	public void setTrucktypeid(String trucktypeid) {
		this.trucktypeid = trucktypeid;
	}	
	
	public String getTrucktype() {
		return trucktype;
	}

	public void setTrucktype(String trucktype) {
		this.trucktype = trucktype;
	}

	public Double getDeadweight() {
		return deadweight;
	}

	public void setDeadweight(Double deadweight) {
		this.deadweight = deadweight;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getNearrailway() {
		return nearrailway;
	}

	public void setNearrailway(String nearrailway) {
		this.nearrailway = nearrailway;
	}

	public Double getRwdis() {
		return rwdis;
	}

	public void setRwdis(Double rwdis) {
		this.rwdis = rwdis;
	}

	public String getNearport() {
		return nearport;
	}

	public void setNearport(String nearport) {
		this.nearport = nearport;
	}

	public Double getPortdis() {
		return portdis;
	}

	public void setPortdis(Double portdis) {
		this.portdis = portdis;
	}

	public String getNearairport() {
		return nearairport;
	}

	public void setNearairport(String nearairport) {
		this.nearairport = nearairport;
	}

	public Double getApdis() {
		return apdis;
	}

	public void setApdis(Double apdis) {
		this.apdis = apdis;
	}

}