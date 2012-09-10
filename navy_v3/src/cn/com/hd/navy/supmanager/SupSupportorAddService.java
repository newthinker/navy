package cn.com.hd.navy.supmanager;

import java.util.UUID;

import cn.com.hd.dto.navy.THighWay;
import cn.com.hd.dto.navy.TSupTrans;
import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.dto.navy.TTransport;
import cn.com.hd.error.Debug;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupSupportorAddService extends BaseService implements IService {

	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		//获取数据
		TSupportor supportor = new TSupportor();
		super.getData(request.getDto(), supportor);
		
		Debug.debugMessage(1, request, supportor.toString());
		
		Conditions cons = new Conditions();
		cons.addCondition(new TSupportor());
		cons.addExpression("SUP_NAME = '" + supportor.getSupname() + "' OR SUP_EN_NAME = '" + supportor.getSupenname() + "'");
		
		if (queryResultSet(cons).getRowCount() > 0) {
			Request res = new Request();
			res.setResponseSystemName("HDDict");
			res.setResponseSubsystemName("DictManage");
			res.setResponseServiceName("SupportorDictQueryService");
			Response resp = requestService(res);
			
			response.getDto().setSelectItems(resp.getDto().getList("RESULT"));
			response.setRequestParam(request.getDto());
			response.getDto().setList("RESULT", getDTO(supportor));
			response.setErrorInfo("供应商名称已存在");
			response.setResult(0);
			
			return response;
		}
		
		cons = new Conditions();
		cons.addCondition(new TSupportor());
		cons.addExpression("ORGANIZE_CODE = '" + supportor.getOrganizecode() + "'");
		
		if (queryResultSet(cons).getRowCount() > 0) {
			Request res = new Request();
			res.setResponseSystemName("HDDict");
			res.setResponseSubsystemName("DictManage");
			res.setResponseServiceName("SupportorDictQueryService");
			Response resp = requestService(res);
			
			response.getDto().setSelectItems(resp.getDto().getList("RESULT"));
			response.setRequestParam(request.getDto());
			response.getDto().setList("RESULT", getDTO(supportor));
			response.setErrorInfo("组织机构代码已存在");
			response.setResult(0);
			
			return response;
		}
		
		if (supportor.getSupid() == null) {
			supportor.setSupid(UUID.randomUUID().toString());
		}

		// 供应商位置
		String l1Area = supportor.getL1Loc();
		if (l1Area!=null) {
			// 将areacode转换成地名
			Request req = new Request();
			req.setResponseSystemName("HDDict");
			req.setResponseSubsystemName("DictManage");
			req.setResponseServiceName("AreaQueryByIDService");
			req.getDto().setString("AREACODE", l1Area);	
			Response resp = requestService(req);
			String areaName = resp.getDto().getList("RESULT").get(0).getString("AREANAME");
			supportor.setL1Loc(areaName);			
		}
		String l2Area = supportor.getL2Loc();
		if (l2Area!=null) {
			Request req = new Request();
			req.setResponseSystemName("HDDict");
			req.setResponseSubsystemName("DictManage");
			req.setResponseServiceName("AreaQueryByIDService");
			req.getDto().setString("AREACODE", l2Area);	
			Response resp = requestService(req);
			String areaName = resp.getDto().getList("RESULT").get(0).getString("AREANAME");
			supportor.setL2Loc(areaName);
		}
		
		//保存供应商数据
		int result = super.save(supportor);
		
		//////////////////////////////////////////////////////////////////////////////////////////////////
		// 保存运输相关信息
		TSupTrans supTrans = new TSupTrans();
		super.getData(request.getDto(), supTrans);
		if(supTrans.getComid()!=null) {
			Request res = new Request();
			res.setResponseSystemName("HDDict");
			res.setResponseSubsystemName("DictManage");
			res.setResponseServiceName("SupportorDictQueryService");
			Response resp = requestService(res);
			
			response.getDto().setSelectItems(resp.getDto().getList("RESULT"));
			response.setRequestParam(request.getDto());
			response.getDto().setList("RESULT", getDTO(supportor));
			response.setErrorInfo("供应商-运输服务企业对应关系已存在");
			response.setResult(0);
			
			return response;
		}
		supTrans.setComid(UUID.randomUUID().toString());
		super.save(supTrans);	
		
		TTransport trans = new TTransport();
		super.getData(request.getDto(), trans);
		cons = new Conditions();
		cons.addCondition(trans);
		cons.addExpression("COM_NAME='" + trans.getComname() + "' AND COM_ID!='" + supTrans.getComid() + "'");
		if(queryResultSet(cons).getRowCount()>0) {
			Request res = new Request();
			res.setResponseSystemName("HDDict");
			res.setResponseSubsystemName("DictManage");
			res.setResponseServiceName("SupportorDictQueryService");
			Response resp = requestService(res);
			
			response.getDto().setSelectItems(resp.getDto().getList("RESULT"));
			response.setRequestParam(request.getDto());
			response.getDto().setList("RESULT", getDTO(supportor));
			response.setErrorInfo("运输服务企业已存在");
			response.setResult(0);
			
			return response;			
		}
		trans.setComid(supTrans.getComid());
		super.save(trans);
		
		THighWay hiw = new THighWay();
		super.getData(request.getDto(), hiw);
		cons = new Conditions();
		cons.addCondition(hiw);
		cons.addExpression("COM_ID='" + supTrans.getComid() + "'");
		if(queryResultSet(cons).getRowCount()==0) {
			hiw.setComid(supTrans.getComid());
			super.save(hiw);
		}		
		
		response.setRequestParam(request.getDto());
		response.getDto().setList("RESULT", getDTO(supportor));
		response.setResult(result);
		
		return response;
	}

}
