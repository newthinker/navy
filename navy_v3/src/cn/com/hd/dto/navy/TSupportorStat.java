package cn.com.hd.dto.navy;

import java.util.HashMap;

import cn.com.hd.service.BaseDTO;

public class TSupportorStat extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	// 统计类型，0--初始化，1--供应商个数统计；2-供应商产能统计；3--供应商类型统计
	private Integer statType;
	
	// 产品分类编码
	private String prodCode;
	
	// 各地域列表
	private HashMap<String, String> mapArea;
	
	// 各区域供应商个数统计结果
	private HashMap<String, Integer> mapNum;
	
	// 供应商类型统计结果
	private HashMap<String, Integer> mapType;
	private HashMap<String, Integer> mapEconomy;
	private HashMap<String, Integer> mapPurchase;
	
	// 供应商产品产能统计结果
	private HashMap<String, Double> mapCapacity;
	
	public TSupportorStat() {
	}
	
	public Integer getStattype() {
		return statType;
	}
	public void setStattype(Integer statType) {
		this.statType = statType;
	}

	public String getProdcode() {
		return prodCode;
	}
	public void setProdcode(String prodCode) {
		this.prodCode = prodCode;
	}
	
	public HashMap<String, String> getMaparea() {
		return mapArea;
	}
	public void setMaparea(HashMap<String, String> mapArea) {
		this.mapArea = mapArea;
	}
	
	public HashMap<String, Integer> getMapnum() {
		return mapNum;
	}
	public void setMapnum(HashMap<String, Integer> mapNum) {
		this.mapNum = mapNum;
	}
	
	public HashMap<String, Integer> getMaptype() {
		return  mapType;
	}
	public void setMaptype(HashMap<String, Integer> mapType) {
		this.mapType = mapType;
	}
	
	public HashMap<String, Integer> getMapeconomy() {
		return mapEconomy;
	}
	public void setMapeconomy(HashMap<String, Integer> mapEconomy) {
		this.mapEconomy = mapEconomy;
	}
	
	public HashMap<String, Integer> getMappruchase() {
		return mapPurchase;
	}
	public void setMappurchase(HashMap<String, Integer> mapPurchase) {
		this.mapPurchase = mapPurchase;
	}
	
	public HashMap<String, Double> getMapcapacity() {
		return mapCapacity;
	}
	public void setMapcapacity(HashMap<String, Double> mapCapacity) {
		this.mapCapacity = mapCapacity;
	}
	
}	