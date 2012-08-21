package cn.com.hd.navy.importmanage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TAftersaleOrg;
import cn.com.hd.dto.navy.TImage;
import cn.com.hd.dto.navy.TImport;
import cn.com.hd.dto.navy.TStockholder;
import cn.com.hd.dto.navy.TSupProduct;
import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import cn.com.hd.transfer.SystemParam;
import cn.com.hd.utils.CompressUtils;
import cn.com.hd.utils.FileUtils;
import cn.com.hd.utils.StringUtils;
import cn.com.hd.utils.XMLUtils;

public class ExportService extends BaseService implements IService {

	@SuppressWarnings({ "unchecked", "static-access" })
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		String folder = UUID.randomUUID().toString();
		String base = SystemParam.getParam("AbsolutePath");
		String targetPath = base + "temp/export/" + folder + "/resources/";
		String target = base + "temp/export/" + folder + "/" + "海军战备储备物资信息" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".dat";
		File f = new File(targetPath);
		f.mkdirs();
		
		TImport imp = new TImport();
		getData(request.getDto(), imp);
		SelectResultSet imprs = queryResultSet(imp);
		List impList = getDTO(imprs);
		
		String supids = "";
		int supcount = 0;
		List suplist = new ArrayList<String>();
        
        StringBuffer impXml = new StringBuffer();
        impXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><DTO>");
        
		//导出物资信息及其扫描件并查找供应商
		for (int i = 0; i < impList.size(); i ++) {
			DTO impDTO = (DTO) impList.get(i);
			imp = new TImport();
			getData(impDTO, imp);

			String planImg = "";
			String compactImg = "";
			String agreeImg = "";
			String examineImg = "";
			String projectImg = "";
			
			Conditions cons = new Conditions();
			TImage img = new TImage();
			img.setImportid(imp.getImportid());
			cons.addCondition(img, "IMAGE_ORDER", true);
			
			SelectResultSet rs = queryResultSet(cons);
			List imgList = getDTO(rs);
			for (Object obj : imgList) {
				DTO dto = (DTO) obj;
				img = new TImage();
				getData(dto, img);
				
				if (img.getImagetype().equals("PLAN")) {
					planImg += "#" + img.getImagename();
				} else if (img.getImagetype().equals("COMPACT")) {
					compactImg += "#" + img.getImagename();
				} else if (img.getImagetype().equals("AGREE")) {
					agreeImg += "#" + img.getImagename();
				} else if (img.getImagetype().equals("EXAMINE")) {
					examineImg += "#" + img.getImagename();
				} else if (img.getImagetype().equals("IMAGE")) {
					projectImg += "#" + img.getImagename();
				}
				
				FileUtils.copy(base + img.getImagepath(), targetPath + img.getImagename());
			}
			
			planImg = planImg.replaceFirst("#", "");
			compactImg = compactImg.replaceFirst("#", "");
			agreeImg = agreeImg.replaceFirst("#", "");
			examineImg = examineImg.replaceFirst("#", "");
			projectImg = projectImg.replaceFirst("#", "");
			
			imp.setPlanid(planImg);
			imp.setCompactid(compactImg);
			imp.setAgreeid(agreeImg);
			imp.setExamineid(examineImg);
			imp.setImage(projectImg);
			
			impXml.append("<ROW>");
			impXml.append(imp.toXMLString());
			impXml.append("</ROW>");
			
			supids += ",'" + imp.getSupportorid() + "'";
			++supcount;
			if (supcount == 1000) {
				supids = supids.replaceFirst(",", "");
				suplist.add(supids);
				supids = "";
				supcount = 0;
			}
		}
		if (supcount > 0) {
			supids = supids.replaceFirst(",", "");
			suplist.add(supids);
			supids = "";
			supcount = 0;
		}
		
		impXml.append("</DTO>");
		
		//导出供应商信息
		List list = new ArrayList();
		for (Object obj : suplist) {
			Conditions cons = new Conditions();
			cons.addCondition(new TSupportor());
			cons.addExpression("SUP_ID IN (" + (String)obj + ")");
			SelectResultSet rs = queryResultSet(cons);
			List tmplist = getDTO(rs);
			list.addAll(tmplist);
		}
		
		StringBuffer supXml = new StringBuffer();
		supXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><DTO>");
        
		//导出供应商信息
		for (Object object : list) {
			DTO dto = (DTO) object;
			TSupportor sup = new TSupportor();
			getData(dto, sup);
			
			supXml.append("<ROW>");
			supXml.append(sup.toXMLString());
			supXml.append("</ROW>");
		}
		
		supXml.append("</DTO>");
		
			
		//导出供应商产品信息
		StringBuffer prodXml = new StringBuffer();
		prodXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><DTO>");

		list.clear();
		for (Object obj : suplist) {
			Conditions cons = new Conditions();
			cons.addCondition(new TSupProduct());
			cons.addExpression("SUP_ID IN (" + supids + ")");
			SelectResultSet rs = queryResultSet(cons);
			List tmplist = getDTO(rs);
			list.addAll(tmplist);
		}
		for (int i = 0; i < list.size(); i ++) {
			DTO dto = (DTO) list.get(i);
			TSupProduct prod = new TSupProduct();
			getData(dto, prod);
			
			prodXml.append("<ROW>");
			prodXml.append(prod.toXMLString());
			prodXml.append("</ROW>");
		}
		
		prodXml.append("</DTO>");
			
		//导出供应商股东信息
		StringBuffer stockXml = new StringBuffer();
		stockXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><DTO>");

		list.clear();
		for (Object obj : suplist) {
			Conditions cons = new Conditions();
			cons.addCondition(new TStockholder());
			cons.addExpression("SUP_ID IN (" + supids + ")");
			SelectResultSet rs = queryResultSet(cons);
			List tmplist = getDTO(rs);
			list.addAll(tmplist);
		}
		for (int i = 0; i < list.size(); i ++) {
			DTO dto = (DTO) list.get(i);
			TStockholder stock = new TStockholder();
			getData(dto, stock);
			
			stockXml.append("<ROW>");
			stockXml.append(stock.toXMLString());
			stockXml.append("</ROW>");
		}
		
		stockXml.append("</DTO>");
			
		//导出供应商售后服务信息
		StringBuffer orgXml = new StringBuffer();
		orgXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><DTO>");

		list.clear();
		for (Object obj : suplist) {
			Conditions cons = new Conditions();
			cons.addCondition(new TAftersaleOrg());
			cons.addExpression("SUP_ID IN (" + supids + ")");
			SelectResultSet rs = queryResultSet(cons);
			List tmplist = getDTO(rs);
			list.addAll(tmplist);
		}
		for (int i = 0; i < list.size(); i ++) {
			DTO dto = (DTO) list.get(i);
			TAftersaleOrg org = new TAftersaleOrg();
			getData(dto, org);
			
			orgXml.append("<ROW>");
			orgXml.append(org.toXMLString());
			orgXml.append("</ROW>");
		}
		
		orgXml.append("</DTO>");
		
		XMLUtils.saveXML(targetPath + "import.xml", impXml.toString());
		XMLUtils.saveXML(targetPath + "supportor.xml", supXml.toString());
		XMLUtils.saveXML(targetPath + "supportor_product.xml", prodXml.toString());
		XMLUtils.saveXML(targetPath + "supportor_stock.xml", stockXml.toString());
		XMLUtils.saveXML(targetPath + "supportor_org.xml", orgXml.toString());
		
		CompressUtils.compressZip(targetPath, target);
		
		File file = new File(targetPath);
		for (int i = 0; i < file.listFiles().length; i ++) {
			file.listFiles()[i].deleteOnExit();
		}
		
		response.setDto(request.getDto());
		response.setResult(2);
		
		response.getDto().put("DOWNLOAD", StringUtils.encrypt(target));
		response.getDto().put("DOWNLOAD_FILENAME", StringUtils.encrypt("海军战备储备物资信息" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".dat"));
		
		return response;
	}

}
