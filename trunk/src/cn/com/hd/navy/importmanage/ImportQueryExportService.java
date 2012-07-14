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

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TImport;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import cn.com.hd.transfer.SystemParam;
import cn.com.hd.utils.FileUtils;
import cn.com.hd.utils.StringUtils;

public class ImportQueryExportService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		Response resp = new Response();
		
		TImport navyImp = new TImport();
		super.getQueryData(request.getDto(), navyImp);
		
		SelectResultSet result = super.queryResultSet(navyImp);
		
		List list = super.getDTO(result);
		
		String source = SystemParam.getParam("AbsolutePath") + "templete/import.xls";
		String target = SystemParam.getParam("AbsolutePath") + "temp/excel/" + UUID.randomUUID().toString() + ".xls";
		FileUtils.copy(source, target);

		Workbook excel = Workbook.getWorkbook(new File(target));
		WritableWorkbook book = Workbook.createWorkbook(new File(target), excel);
		WritableCellFormat fmt = new WritableCellFormat();
		fmt.setAlignment(Alignment.CENTRE);
		SimpleDateFormat fmtDate = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < list.size(); i ++) {
			DTO dto = (DTO) list.get(i);
			super.getData(dto, navyImp);
			
			book.getSheet(0).addCell(new Label(0, i + 1, String.valueOf(i + 1), fmt));//A
			book.getSheet(0).addCell(new Label(1, i + 1, navyImp.getProject(), fmt));//B
			book.getSheet(0).addCell(new Label(2, i + 1, navyImp.getTypename(), fmt));//C
			book.getSheet(0).addCell(new Label(3, i + 1, navyImp.getImportyear(), fmt));//D
			book.getSheet(0).addCell(new Label(4, i + 1, navyImp.getPlan(), fmt));//E
			book.getSheet(0).addCell(new Label(5, i + 1, navyImp.getPlandate() == null ? "" : fmtDate.format(navyImp.getPlandate()), fmt));//F
			book.getSheet(0).addCell(new Label(6, i + 1, navyImp.getModename(), fmt));//G
			book.getSheet(0).addCell(new Label(7, i + 1, navyImp.getDept(), fmt));//H
			book.getSheet(0).addCell(new Label(8, i + 1, navyImp.getClassname(), fmt));//I
			book.getSheet(0).addCell(new Label(9, i + 1, navyImp.getUnit(), fmt));//J
			book.getSheet(0).addCell(new Label(10, i + 1, navyImp.getBudget() == null ? "" : navyImp.getBudget().toString(), fmt));//K
			book.getSheet(0).addCell(new Label(11, i + 1, navyImp.getCompact(), fmt));//L
			book.getSheet(0).addCell(new Label(12, i + 1, navyImp.getCompactdate() == null ? "" : fmtDate.format(navyImp.getCompactdate()), fmt));//M
			book.getSheet(0).addCell(new Label(13, i + 1, navyImp.getDeliverydate() == null ? "" : fmtDate.format(navyImp.getDeliverydate()), fmt));//N
			book.getSheet(0).addCell(new Label(14, i + 1, navyImp.getCompactmoney() == null ? "" : navyImp.getCompactmoney().toString(), fmt));//O
			book.getSheet(0).addCell(new Label(15, i + 1, navyImp.getCurrency(), fmt));//P
			book.getSheet(0).addCell(new Label(16, i + 1, navyImp.getRate() == null ? "" : navyImp.getRate().toString(), fmt));//Q
			book.getSheet(0).addCell(new Label(17, i + 1, navyImp.getDollar() == null ? "" : navyImp.getDollar().toString(), fmt));//R
			book.getSheet(0).addCell(new Label(18, i + 1, navyImp.getRmb() == null ? "" : navyImp.getRmb().toString(), fmt));//S
			book.getSheet(0).addCell(new Label(19, i + 1, navyImp.getEconomize() == null ? "" : navyImp.getEconomize().toString(), fmt));//T
			book.getSheet(0).addCell(new Label(20, i + 1, navyImp.getAgent(), fmt));//U
			book.getSheet(0).addCell(new Label(21, i + 1, navyImp.getAgree(), fmt));//V
			book.getSheet(0).addCell(new Label(22, i + 1, navyImp.getProductor(), fmt));//W
			book.getSheet(0).addCell(new Label(23, i + 1, navyImp.getSupportor(), fmt));//X
			book.getSheet(0).addCell(new Label(24, i + 1, navyImp.getSupportoraddr(), fmt));//Y
			book.getSheet(0).addCell(new Label(25, i + 1, navyImp.getExamineno(), fmt));//Z
			book.getSheet(0).addCell(new Label(26, i + 1, navyImp.getImportclass(), fmt));//AA
			book.getSheet(0).addCell(new Label(27, i + 1, navyImp.getDirectory(), fmt));//AB
			book.getSheet(0).addCell(new Label(28, i + 1, navyImp.getStoretype(), fmt));//AC
			book.getSheet(0).addCell(new Label(29, i + 1, navyImp.getStoreaddr(), fmt));//AD
			book.getSheet(0).addCell(new Label(30, i + 1, navyImp.getUsedate() == null ? "" : fmtDate.format(navyImp.getUsedate()), fmt));//AE
			book.getSheet(0).addCell(new Label(31, i + 1, navyImp.getUseunit(), fmt));//AF
			book.getSheet(0).addCell(new Label(32, i + 1, navyImp.getUsestate(), fmt));//AG
			book.getSheet(0).addCell(new Label(33, i + 1, navyImp.getPassdate() == null ? "" : fmtDate.format(navyImp.getPassdate()), fmt));//AH
			book.getSheet(0).addCell(new Label(34, i + 1, "", fmt));//AI
		}
		
		book.write();
		book.close();
		
		String filename = "海军物资查询分析" + fmtDate.format(new Date()) + ".xls";
		resp.getDto().setList("RESULT", list);
		resp.getDto().put("DOWNLOAD", StringUtils.encrypt(target));
		resp.getDto().put("DOWNLOAD_FILENAME", StringUtils.encrypt(filename));
		resp.setRequestParam(request.getDto());
		
		return resp;
	}

}
