package cn.com.hd.dict;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.dict.TDictArea;
import cn.com.hd.dto.dict.TDictDetail;
import cn.com.hd.dto.dict.TProductType;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class ProductTypeQueryService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Conditions cons = new Conditions();
		cons.addCondition(new TDictDetail());
		cons.addExpression("type_id = '15' order by dict_code asc");
		SelectResultSet result = super.queryResultSet(cons);
		List listtmp = super.getDTO(result);
		HashMap<String, List> mapDict = new HashMap<String, List>();
		for (Object item : listtmp) {
			DTO itemdto = (DTO)item;
			TDictDetail dictdetail = new TDictDetail();
			super.getData(itemdto, dictdetail);
			List listDict = mapDict.get(dictdetail.getFathercode());
			if (listDict == null)
			{
				listDict = new ArrayList();
				listDict.add(dictdetail);
				mapDict.put(dictdetail.getFathercode(), listDict);
			}
			else
			{
				listDict.add(dictdetail);
			}
		}

		List dictlist = new ArrayList();
		List listl1 = mapDict.get("-1");
		if (listl1 != null)
		{
			for (int i=0; i<listl1.size(); i++)
			{
				TDictDetail td1 = (TDictDetail)listl1.get(i);
				TProductType tp1 = new TProductType();
				tp1.setDictname(td1.getDictname());
				tp1.setDictcode(td1.getDictcode());
				tp1.setFathercode(td1.getFathercode());

				List listl2 = mapDict.get(tp1.getDictcode());
				if (listl2 != null)
				{
					for (int j=0; j<listl2.size(); j++)
					{
						TDictDetail td2 = (TDictDetail)listl2.get(j);
						TProductType tp2 = new TProductType();
						tp2.setDictname(td2.getDictname());
						tp2.setDictcode(td2.getDictcode());
						tp2.setFathercode(td2.getFathercode());

						List listl3 = mapDict.get(tp2.getDictcode());
						if (listl3 != null)
						{
							for (int k=0; k<listl3.size(); k++)
							{
								TDictDetail td3 = (TDictDetail)listl3.get(k);
								TProductType tp3 = new TProductType();
								tp3.setDictname(td3.getDictname());
								tp3.setDictcode(td3.getDictcode());
								tp3.setFathercode(td3.getFathercode());
								tp2.setChildren(super.getDTO(tp3));
							}
						}
						tp1.setChildren(super.getDTO(tp2));
					}
				}
				dictlist.add(super.getDTO(tp1));
			}
		}
		
		DTO dictDTO = new DTO();
		dictDTO.setList("RESULT", dictlist);
		
		List dictList = new ArrayList();
		dictList.add(dictDTO);
		
		Response resp = new Response();
		resp.getDto().setSelectItems(dictList);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
