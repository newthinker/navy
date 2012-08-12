package cn.com.hd.dict.dictmanage;

import cn.com.hd.database.SelectResultSet;
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
		
		if (theCode==null) {
			return null;
		}
		if (curName==null && afterName==null) {
			return null;
		}
				
		if (curName==null) {				// 增加节点
			// 查找最后一个兄弟节点
			
			// 增加节点记录
			
		} else if(afterName==null) {		// 删除节点
			// 删除节点记录
			
		} else if (curName!=null && afterName!=null) {		// 修改节点
			// 修改节点记录
		}
		
		return resp;
	}
}