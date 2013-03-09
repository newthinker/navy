package cn.com.hd.dict.dictmanage;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.dict.TDictDetail;
import cn.com.hd.dto.dict.TProdCatalog;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import java.util.List;

public class ProdCatalogService extends BaseService implements IService {
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		TProdCatalog prodcata = new TProdCatalog();

		super.getQueryData(request.getDto(), prodcata);

		String theCode = prodcata.getThecode();
		String curName = prodcata.getCurname();
		String afterName = prodcata.getAftername();
		
		String parentCode = null;		// 上级产品分类编码
		
		// 安全检查
		if (theCode==null) {
			return null;
		} else {	// 编码类型检查
			Request req = new Request();
			req.setResponseSystemName("HDDict");
			req.setResponseSubsystemName("DictManage");
			req.setResponseServiceName("DictQueryService");
			req.getDto().setString("QUERY_DICTCODE", theCode);
			req.getDto().setString("QUERY_VALIDATED", "Y");
			resp = requestService(req);	
			
			String theType = resp.getDto().getList("RESULT").get(0).getString("TYPE_ID");
			if(!theType.equals("15")) {
				System.out.println("Invalid input dict_code");
				return null;
			}
			
			parentCode = resp.getDto().getList("RESULT").get(0).getString("FATHER_CODE");
		}
		if (curName==null && afterName==null) {
			return null;
		}
		
		TDictDetail detail = new TDictDetail();
		Conditions cons = new Conditions();
		String exp = null;
		if (curName==null) {				// 增加节点
			// 查找最后一个兄弟节点
			detail.setTypeid("15");
			detail.setFathercode(parentCode);
			cons.addCondition(detail);
			
			exp = "dto1.DICT_ORDER=(select MAX(dto2.dict_order) from t_dict_detail dto2 where dto2.type_id=15 and dto2.father_code='" + 
					parentCode + "')";
			cons.addExpression(exp);
			
			SelectResultSet result = super.queryResultSet(cons);
			TDictDetail newDetail = new TDictDetail();
			super.getData((DTO) super.getDTO(result).get(0), newDetail);
			
			// 增加节点记录
			newDetail.setDictname(afterName);
			newDetail.setDictorder(newDetail.getDictorder()+1);
			
			theCode = newDetail.getDictcode();
			int count = 1;
			while(2*count<theCode.length()) {
				String sub = theCode.substring(theCode.length()-2*count);
//				theCode = theCode.substring(0, theCode.length()-2*count-1);
				if(!(sub.equals("00"))) {
					int asc1 = (int)sub.charAt(0);
					int asc2 = (int)sub.charAt(1);
					if((asc2+1)>90) {
						asc1 = asc1+1;
						asc2 = 0;
						sub = String.valueOf((char)asc1) + "0"; 
					} else {
						asc2 = asc2+1;
						sub = String.valueOf((char)asc1) + String.valueOf((char)asc2);						
					}
					
					theCode = theCode.substring(0, theCode.length()-(count+1)*2-1) + sub + theCode.substring(theCode.length()-count*2-1);
					
					break;
				}
				count++;
			}
			
			newDetail.setDictcode(theCode);
			super.save(newDetail);
			
		} else if(afterName==null) {		// 删除节点
			// 删除节点记录
			detail.setTypeid("15");
			detail.setDictcode(theCode);
			cons.addCondition(detail);
						
			SelectResultSet result = super.queryResultSet(cons);
			TDictDetail theDetail = new TDictDetail();
			super.getData((DTO) super.getDTO(result).get(0), theDetail);	
			
			super.delete(theDetail);			
		} else if (curName!=null && afterName!=null) {		// 修改节点
			// 修改节点记录
			detail.setTypeid("15");
			detail.setDictcode(theCode);
			cons.addCondition(detail);
						
			SelectResultSet result = super.queryResultSet(cons);
			TDictDetail theDetail = new TDictDetail();
			super.getData((DTO) super.getDTO(result).get(0), theDetail);
			theDetail.setDictname(afterName);
						
			super.save(theDetail);			
		}
		
		return resp;
	}
}