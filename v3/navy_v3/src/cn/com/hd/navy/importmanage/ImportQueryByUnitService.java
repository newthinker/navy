package cn.com.hd.navy.importmanage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.hd.database.DBOperator;
import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TImport;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class ImportQueryByUnitService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		String sqlYear = "SELECT DISTINCT IMPORT_YEAR FROM T_IMPORT ORDER BY IMPORT_YEAR DESC";
		List<Integer>types = new ArrayList<Integer>();
		types.add(DBOperator.VARCHAR2);
		SelectResultSet result = super.queryResultSetBySql(sqlYear, new ArrayList<Object>(), types);
		List yearList = getDTO(result);
		
		Request req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("DictQueryService");
		req.getDto().setString("QUERY_TYPEID", "3");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		Response resp = requestService(req);
		
		List deptList = resp.getDto().getList("RESULT");
		resp = new Response();
		
		TImport navyImp = new TImport();
		super.getQueryData(request.getDto(), navyImp);
		if (navyImp.getImportyear() == null) {
			if (yearList.size() > 0) {
				navyImp.setImportyear(((DTO)yearList.get(0)).getString("IMPORTYEAR"));
			} else {
				navyImp.setImportyear(new SimpleDateFormat("yyyy").format(new Date()));
			}
		}
		
		types = new ArrayList<Integer>();
		types.add(DBOperator.VARCHAR2);
		types.add(DBOperator.VARCHAR2);
		types.add(DBOperator.NUMBER);
		types.add(DBOperator.NUMBER);
		
		Map<String, Object[]> map = new HashMap<String, Object[]>();
		String sql = "SELECT DEPT_ID, DEPT, COUNT(1), SUM(DOLLAR) FROM T_IMPORT WHERE IMPORT_YEAR = '" 
				+ navyImp.getImportyear() + "' AND IMPORT_CLASS_ID = '810000000' GROUP BY DEPT_ID, DEPT";
		
		Map<String, Object[]> mapExa = new HashMap<String, Object[]>();
		String sqlExa = "SELECT DEPT_ID, DEPT, COUNT(1), SUM(DOLLAR) FROM T_IMPORT WHERE IMPORT_YEAR = '" 
			+ navyImp.getImportyear() + "' AND IMPORT_CLASS_ID = '820000000' GROUP BY DEPT_ID, DEPT";
		
		result = super.queryResultSetBySql(sql, new ArrayList<Object>(), types);
		for (int i = 0; i < result.getRowCount(); i ++) {
			Object[] obj = new Object[4];
			obj[0] = result.getStringValue(0, i);
			obj[1] = result.getStringValue(1, i);
			obj[2] = result.getBigDecimalValue(2, i).longValue();
			obj[3] = result.getBigDecimalValue(3, i).longValue();
			map.put((String) obj[1], obj);
		}
		
		result = super.queryResultSetBySql(sqlExa, new ArrayList<Object>(), types);
		for (int i = 0; i < result.getRowCount(); i ++) {
			Object[] obj = new Object[4];
			obj[0] = result.getStringValue(0, i);
			obj[1] = result.getStringValue(1, i);
			obj[2] = result.getBigDecimalValue(2, i).longValue();
			obj[3] = result.getBigDecimalValue(3, i).longValue();
			mapExa.put((String) obj[1], obj);
		}
		
		List<DTO> resultList = new ArrayList<DTO>();
		for (int i = 0; i < deptList.size();i ++) {
			DTO newDTO = new DTO();
			DTO dto = (DTO) deptList.get(i);
			String deptname = dto.getString("DICTNAME");
			
			newDTO.setString("DEPTID", dto.getString("DICTCODE"));
			newDTO.setString("DEPTNAME", deptname);
			
			Long cnt = null;
			Long sum = null;
			Object[] obj = map.get(deptname);
			if (obj == null) {
				cnt = Long.valueOf(0);
				sum = Long.valueOf(0);
			} else {
				cnt = (Long) obj[2];
				sum = (Long) obj[3];
			}
			
			newDTO.setLong("COUNT_DEPT", cnt);
			newDTO.setLong("SUM_COMPACTMONEY", sum);
			
			obj = mapExa.get(deptname);
			if (obj == null) {
				cnt = Long.valueOf(0);
				sum = Long.valueOf(0);
			} else {
				cnt = (Long) obj[2];
				sum = (Long) obj[3];
			}
			
			newDTO.setLong("COUNTEXA_DEPT", cnt);
			newDTO.setLong("SUMEXA_COMPACTMONEY", sum);
			
			resultList.add(newDTO);
		}
		
		resp.getDto().setSelectItems(yearList);
		resp.getDto().setList("RESULT", resultList);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
