package cn.com.hd.navy.importmanage;

import java.util.List;
import java.util.UUID;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TImage;
import cn.com.hd.dto.navy.TImport;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;

public class ImportQueryByIDService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Request req = new Request();
		req.setResponseSystemName("HDDict");
		req.setResponseSubsystemName("DictManage");
		req.setResponseServiceName("ImportDictQueryService");
		Response response = requestService(req);
		
		req = new Request();
		req.setResponseSystemName("Navy");
		req.setResponseSubsystemName("NavyManage");
		req.setResponseServiceName("SupportorQueryService");
		req.getDto().setInt("ROWNUMBER", Integer.MAX_VALUE);
		Response supResp = requestService(req);
		response.getDto().getList("RESULT").add(supResp.getDto());
		
		Response resp = new Response();
		
		TImport navyImp = new TImport();
		
		super.getData(request.getDto(), navyImp);
		
		SelectResultSet result = super.queryResultSet(navyImp);
		
		List list = super.getDTO(result);
		if (list.size() == 0) {
			navyImp = new TImport();
			
			if (navyImp.getImportid() == null) {
				navyImp.setImportid(UUID.randomUUID().toString());
			}
			
			if (navyImp.getPlanid() == null) {
				navyImp.setPlanid(UUID.randomUUID().toString());
			}
			
			if (navyImp.getCompactid() == null) {
				navyImp.setCompactid(UUID.randomUUID().toString());
			}
			
			if (navyImp.getAgreeid() == null) {
				navyImp.setAgreeid(UUID.randomUUID().toString());
			}
			
			if (navyImp.getExamineid() == null) {
				navyImp.setExamineid(UUID.randomUUID().toString());
			}
			
			if (navyImp.getImage() == null) {
				navyImp.setImage(UUID.randomUUID().toString());
			}
			
			list.add(getDTO(navyImp));
		} else {
			navyImp = new TImport();
			getData((DTO) list.get(0), navyImp);
		}
			
		TImage image = new TImage();
		image.setImportid(navyImp.getImportid());
		image.setImagetypeid(navyImp.getPlanid());
		image.setImagetype("PLAN");
		SelectResultSet rs = queryResultSet(image);
		int iPlanCount = rs.getRowCount();
		
		image = new TImage();
		image.setImportid(navyImp.getImportid());
		image.setImagetypeid(navyImp.getCompactid());
		image.setImagetype("COMPACT");
		rs = queryResultSet(image);
		int iCompactCount = rs.getRowCount();
		
		image = new TImage();
		image.setImportid(navyImp.getImportid());
		image.setImagetypeid(navyImp.getAgreeid());
		image.setImagetype("AGREE");
		rs = queryResultSet(image);
		int iAgreeCount = rs.getRowCount();
		
		image = new TImage();
		image.setImportid(navyImp.getImportid());
		image.setImagetypeid(navyImp.getExamineid());
		image.setImagetype("EXAMINE");
		rs = queryResultSet(image);
		int iExamineCount = rs.getRowCount();
		
		image = new TImage();
		image.setImportid(navyImp.getImportid());
		image.setImagetypeid(navyImp.getImage());
		image.setImagetype("IMAGE");
		rs = queryResultSet(image);
		int iImageCount = rs.getRowCount();
		
		resp.getDto().setInt("PLAN_COUNT", iPlanCount);
		resp.getDto().setInt("COMPACT_COUNT", iCompactCount);
		resp.getDto().setInt("AGREE_COUNT", iAgreeCount);
		resp.getDto().setInt("EXAMINE_COUNT", iExamineCount);
		resp.getDto().setInt("IMAGE_COUNT", iImageCount);
		resp.getDto().setSelectItems(response.getDto().getList("RESULT"));
		resp.getDto().setList("RESULT", list);
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
