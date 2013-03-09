package cn.com.hd.navy.importmanage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableWorkbook;

import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import cn.com.hd.transfer.SystemParam;
import cn.com.hd.utils.FileUtils;
import cn.com.hd.utils.StringUtils;

public class ImportQueryByUnitExportService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		
		Request req = new Request();
		req.setDto(request.getDto());
		req.setResponseSystemName("Navy");
		req.setResponseSubsystemName("NavyManage");
		req.setResponseServiceName("ImportQueryByUnitService");
		Response response = requestService(req);
		
		List list = response.getDto().getList("RESULT");
		
		String source = SystemParam.getParam("AbsolutePath") + "templete/dept.xls";
		String target = SystemParam.getParam("AbsolutePath") + "temp/excel/" + UUID.randomUUID().toString() + ".xls";
		FileUtils.copy(source, target);

		Workbook excel = Workbook.getWorkbook(new File(target));
		WritableWorkbook book = Workbook.createWorkbook(new File(target), excel);
		WritableCellFormat fmt = new WritableCellFormat();
		fmt.setAlignment(Alignment.CENTRE);
		for (int i = 0; i < list.size(); i ++) {
			DTO dto = (DTO) list.get(i);
			String deptname = dto.getString("DEPTNAME");
			Long cnt = dto.getLong("COUNT_DEPT");
			Long sum = dto.getLong("SUM_COMPACTMONEY");
			Long cntexa = dto.getLong("COUNTEXA_DEPT");
			Long sumexa = dto.getLong("SUMEXA_COMPACTMONEY");
			
			book.getSheet(0).addCell(new Label(0, i + 3, deptname, fmt));
			book.getSheet(0).addCell(new Label(1, i + 3, String.valueOf(cnt), fmt));
			book.getSheet(0).addCell(new Label(2, i + 3, String.valueOf(sum), fmt));
			book.getSheet(0).addCell(new Label(3, i + 3, String.valueOf(cntexa), fmt));
			book.getSheet(0).addCell(new Label(4, i + 3, String.valueOf(sumexa), fmt));
		}
		
		book.write();
		book.close();
		
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		String filename = "海军物资按单位汇总分析" + fmtDate.format(new Date()) + ".xls";
		resp.getDto().setList("RESULT", list);
		resp.getDto().put("DOWNLOAD", StringUtils.encrypt(target));
		resp.getDto().put("DOWNLOAD_FILENAME", StringUtils.encrypt(filename));
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
