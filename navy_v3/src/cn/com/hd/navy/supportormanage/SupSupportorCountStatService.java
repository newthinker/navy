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
		Request req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("AreaQueryService");
		req.getDto().setString("QUERY_PARENTCODEID", "0");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		Response res = requestService(req);
		
		List lstArea = res.getDto().getList("RESULT");
		if(lstArea.size()>0) {
			HashMap<String, Integer> rs1;		
			
			// 各省/区供应商个数统计
			rs1 = supStatPerProvince(lstArea);
			supStat.setMapnum(rs1);	
			supStat.setStattype(1);
		}
		
		resp.getDto().setObject("RESULT", supStat);
		
		return resp;
	}
	
	// 各省/区供应商个数统计
	public HashMap<String, Integer> supStatPerProvince(List lstArea) throws Exception {
		HashMap<String, Integer> res = null;
		
		if(lstArea==null) {
			return null;
		}
		
		// 遍历地区map
		for (Object item : lstArea) {
			TDictArea dictArea = new TDictArea();
			super.getData((DTO)item, dictArea);

			String dictCode = dictArea.getAreacode();
			String areaName = dictArea.getAreaname();
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
	
}