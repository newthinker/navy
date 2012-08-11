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
				
		if (curName==null) {				// �ڵ�����
			// �������һ���ֵܽڵ����Ϣ
			
			// ���������¼
			
		} else if(afterName==null) {		// �ڵ�ɾ��
			// ɾ���˸��ڵ��¼
			
		} else if (curName!=null && afterName!=null) {		// �ڵ��޸�
			// ֱ�ӽ����޸�
		}
		
		return resp;
	}
}