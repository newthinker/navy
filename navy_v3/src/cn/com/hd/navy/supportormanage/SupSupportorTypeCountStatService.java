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

public class SupSupportorTypeCountStatService extends BaseService implements IService {
	
	private int supType = 11;
	private int supEconomy = 14;
	private int supPurchase = 6;

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		

		
		TSupportorStat supStat = new TSupportorStat();
		super.getQueryData(request.getDto(), supStat);
		
		/// 获取输入参数
		// 产品分类编码
		String prodCode = supStat.getProdcode();		// "DICT_LIST"
		
		// 首先查询所有省/区信息
		HashMap<String, Integer> rs1;		
		HashMap<String, Integer> rs2;
		HashMap<String, Integer> rs3;
		
		// 供应商类型统计
		rs1 = supStatOfType(supType);
		rs2 = supStatOfType(supEconomy);
		rs3 = supStatOfType(supPurchase);
		supStat.setMaptype(rs1);
		supStat.setMapeconomy(rs2);
		supStat.setMappurchase(rs3);
		supStat.setStattype(3);
		
		resp.getDto().setObject("RESULT", supStat);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}
		
	// 供应商统计，type=11，供应商类型；14，经济性质，6，采购方式；
	public HashMap<String, Integer> supStatOfType(Integer type) throws Exception {
		HashMap<String, Integer> res = null;
		// 首先查询对应类别种类
		if (type!=supType && type!=supEconomy && type!=supPurchase) {
			Debug.debugMessage("Invalid type:"+type);	
			return  null;
		}
		
		Response resp = new Response();
		Request req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", type.toString());
		req.getDto().setString("QUERY_VALIDATED", "Y");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		resp = requestService(req);
		List list = resp.getDto().getList("RESULT");
		// 遍历查询记录
		for (int i=0; i<list.size();i++) {
			DTO record = (DTO) list.get(i);
			String dictName = record.getString("DICTNAME");
			
			TSupportor supportor = new TSupportor();
			if (type==11)
				supportor.setType(dictName);
			else if (type==14)
				supportor.setEconomy(dictName);
			else if (type==6)
				supportor.setPurchasetype(dictName);
			
			SelectResultSet result = super.queryResultSet(supportor);
			Integer count = result.getRowCount();
			
			if(res==null) {
				res = new HashMap<String, Integer>();
			}
			
			res.put(dictName, count);
			
		}
		
		return res;
	}

}