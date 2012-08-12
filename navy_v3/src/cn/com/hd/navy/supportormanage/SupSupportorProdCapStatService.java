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

public class SupSupportorProdCapStatService extends BaseService implements IService {

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
			HashMap<String, Double> rs1;
			
			// 供应商产能统计
			if (prodCode!=null) {
				rs1 = supStatOfProduct(prodCode, lstArea);
				supStat.setMapcapacity(rs1);
			}	
			supStat.setStattype(2);
		}
		
		resp.getDto().setObject("RESULT", supStat);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}
	
	// 供应商产品产能统计
	public HashMap<String, Double> supStatOfProduct(String prodType, List lstArea) throws Exception {
		HashMap<String, Double> res = null;
		
		if (lstArea==null) {
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
			
			TSupProduct product = new TSupProduct();
			product.setProdtype(prodType);
			Conditions cons = new Conditions();
			cons.addCondition(product);
			// 组织查询语句
			String exp = "exists (select 1 from T_SUPPORTOR dto2 where dto1.SUP_ID=dto2.SUP_ID and dto2.L1_LOC='" + areaName + "')";
			cons.addExpression(exp);
			
			SelectResultSet result = super.queryResultSet(cons);
			// 求和
			double sum = 0;
			for (int i=0; i<result.getRowCount(); i++) {
				sum += result.getDoubleValue(6, i);
			}
			
			if (res==null) {
				res = new HashMap<String, Double>();
			}
			
			res.put(areaName, sum);			
		}
		
		return res;
	}
	
}