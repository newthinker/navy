package cn.com.hd.navy.supportormanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.dict.TDictArea;
import cn.com.hd.dto.dict.TDictDetail;
import cn.com.hd.dto.navy.TSupProduct;
import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.dto.navy.TSupportorStat;
import cn.com.hd.error.Debug;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.PageInfo;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupSupportorCountStatService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		
		TSupportorStat supStat = new TSupportorStat();
		super.getQueryData(request.getDto(), supStat);
		
		/// 获取输入参数
		// 产品分类编码
		String prodCode = supStat.getProdcode();		// "DICT_LIST"
		
		// 首先查询所有省/区信息
		HashMap<String, String> mapArea = provQuery();
		if(mapArea.size()>0) {
			HashMap<String, Integer> rs1;		
			HashMap<String, Integer> rs2;
			HashMap<String, Integer> rs3;
			HashMap<String, Integer> rs4;
			HashMap<String, Double>  rs5;
			
			// 各省/区供应商个数统计
			rs1 = supStatPerProvince(mapArea);
			supStat.setMapnum(rs1);
			
			supStat.setMaparea(mapArea);
		}
		
		resp.getDto().setObject("RESULT", supStat);
		
		return resp;
	}
	
	// 各省/区供应商个数统计
	public HashMap<String, Integer> supStatPerProvince(HashMap<String, String> mapArea) {
		HashMap<String, Integer> res = null;
		
		if(mapArea==null) {
			return null;
		}
		
		// 遍历地区map
		Set<Entry<String, String>> entrySet = mapArea.entrySet(); 
		for (Entry<String, String> area : entrySet) {
			String dictCode = area.getKey();
			String areaName = area.getValue();
			if(dictCode==null || areaName==null) {
				continue;
			}
			
			TSupportor supportor = new TSupportor();
			supportor.setL1Loc(areaName);
			
			try {
				SelectResultSet result = super.queryResultSet(supportor);
				Integer count = result.getRowCount();
				
				if(res==null) {
					res = new HashMap<String, Integer>();
				}
				
				res.put(areaName, count);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		
		return res;
	}
	
	// 查询全国所有的省/区
	private HashMap<String, String> provQuery() {
		HashMap<String, String> res = new HashMap<String, String>();

		TDictArea area = new TDictArea();
		area.setParentcodeid("0");			
		
		SelectResultSet result;
		try {
			result = super.queryResultSet(area);

			List list = super.getDTO(result);	
			// 遍历list，取出所有省数据
			for (int i=0; i<list.size();i++) {
				super.getData((DTO) list.get(i), area);
				
				String dictCode = area.getAreacode();
				String areaName = area.getAreaname();
				
				if (dictCode!=null && areaName!=null) {
					res.put(dictCode, areaName);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return res;
	}

}