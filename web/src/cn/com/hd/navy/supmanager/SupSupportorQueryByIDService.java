package cn.com.hd.navy.supmanager;

import java.util.List;
import java.util.UUID;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.THighWay;
import cn.com.hd.dto.navy.TSupTrans;
import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.dto.navy.TTransport;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class SupSupportorQueryByIDService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Request res = new Request();
		res.setResponseSystemName("HDDict");
		res.setResponseSubsystemName("DictManage");
		res.setResponseServiceName("SupSupportorDictQueryService");
		Response response = requestService(res);
		
		Response resp = new Response();
		
		TSupportor supportor = new TSupportor();
		super.getData(request.getDto(), supportor);
		
		if (supportor.getSupid() == null) {
			supportor.setSupid("-1");
		}
		
		SelectResultSet result = super.queryResultSet(supportor);
		
		List list = super.getDTO(result);
		
		if (list.size() == 0) {
			supportor = new TSupportor();
			supportor.setSupid(UUID.randomUUID().toString());
			list.add(getDTO(supportor));
		}
		
		////////////////////////////////////////////////////////////////////////////
		// 查询交通运输信息
		TSupTrans supTrans = new TSupTrans();
		getData(request.getDto(), supTrans);
		
		Conditions cons = new Conditions();
		cons.addCondition(supTrans);
		SelectResultSet rs = queryResultSet(cons);
		List listTrans = getDTO(rs);
		if(listTrans.size()>0) {
			String comid = null;
			for (Object item : listTrans) {
				supTrans = new TSupTrans();
				super.getData((DTO)item, supTrans);
				comid = supTrans.getComid();
			}	
			
			TTransport trans = new TTransport();
			trans.setComid(comid);
			cons.addCondition(trans);
			
			rs = queryResultSet(cons);
			List retList = getDTO(rs);
			if (retList.size() < 1) {
				list.add(new DTO());
			}
			else {
				list.add(retList.get(0));
			}
//			for (Object item : retList) {
//				trans = new TTransport();
//				super.getData((DTO)item, trans);
//				
////				DTO dto = (DTO) list.get(0);
////				dto.setString("COMID", trans.getComid());
////				dto.setString("COMNAME", trans.getComname());
////				dto.setString("TRUCKTYPE", trans.getTrucktype());
////				dto.setDouble("DEADWEIGHT", trans.getDeadweight());
////				dto.setInt("COUNT", trans.getCount());
////				dto.setString("NEARRAILWAY", trans.getNearrailway());
////				dto.setDouble("RWDIS", trans.getRwdis());
////				dto.setString("NEARPORT", trans.getNearport());
////				dto.setDouble("PORTDIS", trans.getPortdis());
////				dto.setString("NEARAIRPORT", trans.getNearairport());
////				dto.setDouble("APDIS", trans.getApdis());
////				
////				list.clear();
////				list.add(dto);
//				
//				list.add(getDTO(trans));
//			}
			
			THighWay hiw = new THighWay();
			hiw.setComid(comid);
			cons = new Conditions();
			cons.addCondition(hiw);
			
			rs = queryResultSet(cons);
			retList = getDTO(rs);
			if (retList.size() < 1) {
				list.add(new DTO());
			}
			else {
				list.add(retList.get(0));
			}
//			for (Object item : retList) {
//				hiw = new THighWay();
//				super.getData((DTO)item, hiw);
//				
////				DTO dto = (DTO) list.get(0);
////				dto.setString("HIWID", hiw.getHiwid());
////				dto.setString("HIWNAME", hiw.getHiwname());
////				dto.setString("HIWIN", hiw.getHiwin());
////				dto.setString("HIWIN_ID", hiw.getHiwinid());
////				dto.setDouble("HIWDIS", hiw.getHiwdis());
////				
////				list.clear();
////				list.add(dto);
//				list.add(getDTO(hiw));
//			}
		}
		
		resp.getDto().setSelectItems(response.getDto().getList("RESULT"));
		resp.getDto().setList("RESULT", list);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
