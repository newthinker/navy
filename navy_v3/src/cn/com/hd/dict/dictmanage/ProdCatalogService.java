package cn.com.hd.dict.dictmanage;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.dict.TDictArea;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.PageInfo;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import java.util.List;

public class ProdCatalogService extends BaseService implements IService {
	public Response service(Request request) throws Exception {
		TProdCatalog prodcata = new TProdCatalog();

		super.getQueryData(request.getDto(), prodcata);

		String theCode = prodcata.getThecode();
		String curName = prodcata.getCurname();
		String afterName = prodcata.getAftername;
		
		if (theCode==null) {
			return null;
		}
		if (curName==null && afterName==null) {
			return null;
		}
				
		if (curName==null) {				// 节点增加
			// 查找最后一个兄弟节点的信息
			
			// 插入此条记录
			
		} else if(afterName==null) {		// 节点删除
			// 删除此个节点记录
			
		} else if (curName!=null && afterName!=null) {		// 节点修改
			// 直接进行修改
		}
		
		return resp;
	}
}