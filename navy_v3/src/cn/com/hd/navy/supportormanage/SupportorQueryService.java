﻿package cn.com.hd.navy.supportormanage;

import java.util.List;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.PageInfo;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupportorQueryService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		
		TSupportor supportor = new TSupportor();
		super.getQueryData(request.getDto(), supportor);
		
		PageInfo page = super.getPageInfo();
		
		// 供应商名称
		String supname = supportor.getSupname();
		supportor.setSupname(null);
		
		// 供应商位置
//		String l1Area = supportor.getL1Area;
//		String l2Area = supportor.getL2Area;
		
		// 供应商注册资金
		double capital = supportor.getLiccapital();
		
		Conditions cons = new Conditions();
		cons.addCondition(supportor);
		
		// 首先根据供应商提交的条件查询出符合范围的供应商
		if (supname != null && !supname.trim().equals("")) {
			cons.addExpression("SUP_NAME like '%" + supname + "%' OR SUP_EN_NAME like '%" + supname + "%'");
		}
		SelectResultSet result = super.queryResultSet(page, cons);
		
		List list = super.getDTO(result);

		// 生产范围
		
		// 产品产能
		
		// 相应运力

		resp.getDto().setList("RESULT", list);
		resp.setPageInfo(page);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
