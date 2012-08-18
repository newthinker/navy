package cn.com.hd.navy.supmanager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TAftersaleOrg;
import cn.com.hd.dto.navy.THighWay;
import cn.com.hd.dto.navy.TImage;
import cn.com.hd.dto.navy.TImport;
import cn.com.hd.dto.navy.TStockholder;
import cn.com.hd.dto.navy.TSupProduct;
import cn.com.hd.dto.navy.TSupTrans;
import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.dto.navy.TTransport;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.PageInfo;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import cn.com.hd.transfer.SystemParam;
import cn.com.hd.utils.CompressUtils;
import cn.com.hd.utils.FileUtils;
import cn.com.hd.utils.StringUtils;
import cn.com.hd.utils.XMLUtils;

public class SupExportService extends BaseService implements IService {

	@SuppressWarnings({ "unchecked", "static-access" })
	public Response service(Request request) throws Exception {
		Response response = new Response();
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// 调用查询条件
		/// 供应商表查询结果
		TSupportor supportor = new TSupportor();
		super.getQueryData(request.getDto(), supportor);		
		// 供应商名称
		String supname = supportor.getSupname();			
		// 供应商位置
		String l1Area = supportor.getL1Loc();
		String l2Area = supportor.getL2Loc();	
		// 供应商注册资金
		double capital = 0;
		if(supportor.getLiccapital()!=null) {
			capital = supportor.getLiccapital();
		}		
		Conditions cons = new Conditions();
		cons.addCondition(supportor);		
		// 首先根据供应商提交的条件查询出符合范围的供应商
		if (supname != null && !supname.trim().equals("")) {
			supportor.setSupname(null);	
			cons.addExpression("dto1.SUP_NAME like '%" + supname + "%'");
		}
		
		Response resp = new Response();
		if (l1Area!=null) {
			// 将areacode转换成地名
			Request req = new Request();
			req.setResponseSystemName("HDDict");
			req.setResponseSubsystemName("DictManage");
			req.setResponseServiceName("AreaQueryByIDService");
			req.getDto().setString("AREACODE", l1Area);	
			resp = requestService(req);
			String areaName = resp.getDto().getList("RESULT").get(0).getString("AREANAME");
			
			supportor.setL1Loc(areaName);			
		}
		if (l2Area!=null) {
			Request req = new Request();
			req.setResponseSystemName("HDDict");
			req.setResponseSubsystemName("DictManage");
			req.setResponseServiceName("AreaQueryByIDService");
			req.getDto().setString("AREACODE", l2Area);	
			resp = requestService(req);
			String areaName = resp.getDto().getList("RESULT").get(0).getString("AREANAME");
			
			supportor.setL2Loc(areaName);
		}
		if (capital>0 && capital<6) {
			supportor.setLiccapital(null);
			
			if(capital<5 && capital>0) {
				double delt = 0.000001;
				if((capital-1)<delt) {
					cons.addExpression("dto1.LIC_CAPITAL>0 and dto1.LIC_CAPITAL<=50");
				} else if ((capital-2)<delt) {
					cons.addExpression("dto1.LIC_CAPITAL>50 and dto1.LIC_CAPITAL<=200");
				} else if ((capital-3)<delt) {
					cons.addExpression("dto1.LIC_CAPITAL>200 AND dot1.LIC_CAPITAL<=500");
				} else if ((capital-4)<delt) {
					cons.addExpression("dto1.LIC_CAPITAL>500");
				}
			}
		}

		/// 产品表
		TSupProduct supProduct = new TSupProduct();
		super.getQueryData(request.getDto(), supProduct);
		
		// 生产范围--产品类型
		String dictcode = supProduct.getProdid();
		// 产品产能--年产量
		double output = 0;
		if ( supProduct.getAvgoutput()!=null ) {
			output = supProduct.getAvgoutput();
		}
		String exp = null;
		if (dictcode!=null || output>0) {
			exp = "exists (select 1 from T_SUP_PRODUCT dto2 where dto1.SUP_ID=dto2.SUP_ID";
			
			if(dictcode!=null) {
				exp += " and dto2.PROD_ID='" + dictcode + "'";
			}
			if(output>0) {
				exp += " and dto2.AVG_OUTPUT>=" + output;
			}
			
			exp += ")";
		}
		if (exp!=null) {
			cons.addExpression(exp);
		}
		/// 运输表
		TTransport transport = new TTransport();
		super.getQueryData(request.getDto(), transport);		
		// 相应运力
		double capacity = 0;
		if (transport.getDeadweight()!=null) {
			capacity = transport.getDeadweight();		/// 将用户输入的运力条件保存到载重量字段中
		}
		exp = null;
		if (capacity>0) {
			exp = "exists (select 1 from T_SUP_TRANS dto3, T_TRANSPORT dto4 where dto1.SUP_ID=dto3.SUP_ID and dto3.COM_ID=dto4.COM_ID and " + 
				"dto4.DEADWEIGHT*dto4.COUNT>=" + capacity + ")";
		}
		if(exp!=null) {
			cons.addExpression(exp);
		}	
		
		String folder = UUID.randomUUID().toString();
		String base = SystemParam.getParam("AbsolutePath");
		String targetPath = base + "temp/export/" + folder + "/resources/";
		String finalPath = base + "temp/export/" + folder + "/sups/";
		File f = new File(targetPath);
		f.mkdirs();
		f = new File(finalPath);
		f.mkdir();
		
		// 查询供应商并导出查询结果
		SelectResultSet resultset = super.queryResultSet(cons);
		List supList = getDTO(resultset);
		for (int i=0; i<supList.size(); i++) {
			DTO supDTO = (DTO) supList.get(i);
			supportor = new TSupportor();
			getData(supDTO, supportor);
			String supid = supportor.getSupid();
			if(supid==null || supid.equals("")) {
				continue;
			}
			
			// 创建供应商文件夹
			String suptarget = finalPath + supid + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".zip";
			String supPath = targetPath + supid + "/";
			File supFile = new File(supPath);
			supFile.mkdir();
			
			// 导出图片信息			
			String imgfile = null;
			List imgList = new ArrayList<String>();
			if(supportor.getImage()!=null) {
				imgfile = saveImage(supportor.getImage(), supPath);
				supportor.setImage(imgfile);
			}
			if(supportor.getStorehouseimage()!=null) {
				imgfile = saveImage(supportor.getStorehouseimage(), supPath);
				supportor.setStorehouseimage(imgfile);
			}
			if(supportor.getLicbusimage()!=null) {
				imgfile = saveImage(supportor.getLicbusimage(), supPath);
				supportor.setLicbusimage(imgfile);
			}
			if(supportor.getOrgstrimage()!=null) {
				imgfile = saveImage(supportor.getOrgstrimage(), supPath);
				supportor.setOrgstrimage(imgfile);
			}
			if(supportor.getAuditlast3y()!=null) {
				imgfile = saveImage(supportor.getAuditlast3y(), supPath);
				supportor.setAuditlast3y(imgfile);
			}
			if(supportor.getBankProve()!=null) {
				imgfile = saveImage(supportor.getBankProve(), supPath);
				supportor.setBankProve(imgfile);
			}
			if(supportor.getOtherProve()!=null) {
				imgfile = saveImage(supportor.getOtherProve(), supPath);
				supportor.setOtherProve(imgfile);
			}
			if(supportor.getQualityProve()!=null) {
				imgfile = saveImage(supportor.getQualityProve(), supPath);
				supportor.setQualityProve(imgfile);
			}
			// 导出供应商信息
			StringBuffer strXml = new StringBuffer();
			strXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><DTO>");
			strXml.append(supportor.toXMLString());
			strXml.append("</DTO>");	
			XMLUtils.saveXML(supPath + "supportor.xml", strXml.toString());
			
			// 导出供应商股东信息
			strXml = new StringBuffer();
			strXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><DTO>");
			cons = new Conditions();
			cons.addCondition(new TStockholder());
			cons.addExpression("SUP_ID = '" + supid + "'");
			SelectResultSet rs = queryResultSet(cons);
			List list = getDTO(rs);
			for (int j=0; j<list.size(); j++) {
				DTO dto = (DTO) list.get(j);
				TStockholder stock = new TStockholder();
				getData(dto, stock);
				
				strXml.append("<ROW>");
				strXml.append(stock.toXMLString());
				strXml.append("</ROW>");
			}
			strXml.append("</DTO>");
			XMLUtils.saveXML(supPath + "supportor_stock.xml", strXml.toString());

			// 导出供应商售后服务信息
			strXml = new StringBuffer();
			strXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><DTO>");			
			cons = new Conditions();
			cons.addCondition(new TAftersaleOrg());
			cons.addExpression("SUP_ID = '" + supid + "'");
			rs = queryResultSet(cons);
			list = getDTO(rs);
			for (int j = 0; j < list.size(); j ++) {
				DTO dto = (DTO) list.get(j);
				TAftersaleOrg org = new TAftersaleOrg();
				getData(dto, org);
				
				strXml.append("<ROW>");
				strXml.append(org.toXMLString());
				strXml.append("</ROW>");
			}
			strXml.append("</DTO>");
			XMLUtils.saveXML(supPath + "supportor_org.xml", strXml.toString());
			
			// 导出供应商产品信息
			strXml = new StringBuffer();
			strXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><DTO>");			
			cons = new Conditions();
			cons.addCondition(new TSupProduct());
			cons.addExpression("SUP_ID = '" + supid + "'");
			rs = queryResultSet(cons);
			list = getDTO(rs);
			for (int j = 0; j < list.size(); j ++) {
				DTO dto = (DTO) list.get(j);
				TSupProduct prod = new TSupProduct();
				getData(dto, prod);
				
				strXml.append("<ROW>");
				strXml.append(prod.toXMLString());
				strXml.append("</ROW>");
				
				if(prod.getProdimage()!=null) {
					imgfile = saveImage(prod.getProdimage(), supPath);
					supportor.setQualityProve(imgfile);
				}				
			}
			strXml.append("</DTO>");
			XMLUtils.saveXML(supPath + "supportor_product.xml", strXml.toString());
			
			// 导出运输服务信息	
			cons = new Conditions();
			cons.addCondition(new TSupTrans());
			cons.addExpression("SUP_ID = '" + supid + "'");
			rs = queryResultSet(cons);
			list = getDTO(rs);
			for (int j=0; j<(list.size()>0?1:0); j++) {		// 只取一个			
				DTO dto = (DTO) list.get(j);
				TSupTrans supTran = new TSupTrans();
				getData(dto, supTran);
				
				String comid = supTran.getComid();
				if(comid==null || comid.equals("")) {
					continue;
				}
				
				strXml = new StringBuffer();
				strXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><DTO>");	
				Conditions conditions = new Conditions();
				conditions.addCondition(new TTransport());
				conditions.addExpression("COM_ID='" + comid + "'");
				SelectResultSet result = queryResultSet(conditions);
				List lstTrans = getDTO(result);
				for (int k=0; k<lstTrans.size(); k++) {
					DTO dtoTran = (DTO) lstTrans.get(k);
					TTransport tran = new TTransport();
					getData(dtoTran, tran);
					
					strXml.append("<ROW>");
					strXml.append(tran.toXMLString());
					strXml.append("</ROW>");
				}
				strXml.append("</DTO>");
				XMLUtils.saveXML(supPath + "supportor_tran.xml", strXml.toString());
				
				strXml = new StringBuffer();
				strXml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?><DTO>");
				conditions = new Conditions();
				conditions.addCondition(new THighWay());
				conditions.addExpression("COM_ID='" + comid + "'");
				result = queryResultSet(conditions);
				List lstHiw = getDTO(result);
				for (int k=0; k<lstHiw.size(); k++) {
					DTO dtoHiw = (DTO) lstHiw.get(k);
					THighWay hiw = new THighWay();
					getData(dtoHiw, hiw);
					
					strXml.append("<ROW>");
					strXml.append(hiw.toXMLString());
					strXml.append("</ROW>");
				}
				strXml.append("</DTO>");
				XMLUtils.saveXML(supPath + "supportor_highway.xml", strXml.toString());
			}

			// 进行压缩
			CompressUtils.compressZip(supPath, suptarget);
			File file = new File(supPath);
			for (int j = 0; j < file.listFiles().length; j ++) {
				file.listFiles()[j].deleteOnExit();
			}
		}
		File file = new File(targetPath);
		for (int j = 0; j < file.listFiles().length; j ++) {
			file.listFiles()[j].deleteOnExit();
		}
		
//		targetPath = base + "temp/export/" + folder + "/";
		String target = base + "temp/export/" + "SUPS" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".zip";		
		CompressUtils.compressZip(finalPath, target);
		file = new File(finalPath);
		for (int j = 0; j < file.listFiles().length; j ++) {
			file.listFiles()[j].deleteOnExit();
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
		response.setDto(request.getDto());
		response.setResult(2);
		
		response.getDto().put("DOWNLOAD", StringUtils.encrypt(target));
		response.getDto().put("DOWNLOAD_FILENAME", StringUtils.encrypt("SUPS" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".zip"));
		
		return response;
	}

	// 根据图片编号将图片导出并保存到目标目录下
	private String saveImage(String imgid, String dstdir) {
		String imgtype = null;
		String imgfile = null;
		
		Conditions cons = new Conditions();
		TImage img = new TImage();
		img.setImageid(imgid);
		cons.addCondition(img, "IMAGE_ORDER", true);
		
		try {
			SelectResultSet rs = queryResultSet(cons);
			List imgList = getDTO(rs);
			for (Object obj : imgList) {
				DTO dto = (DTO) obj;
				img = new TImage();
				getData(dto, img);
				
				imgfile = img.getImagename();
				if(imgfile==null) {
					imgfile = UUID.randomUUID().toString();
				}
				
				java.sql.Blob blob = img.getImage();
				if(blob==null) {
					return null;
				}
				InputStream ins = blob.getBinaryStream();
				
				File file = new File(dstdir+imgfile);
				if(!file.exists()) {
					file.createNewFile();
				}
				
				FileOutputStream os = new FileOutputStream(file);
				int len;
				byte buf[] = new byte[1024];
				while ((len=ins.read(buf))>0) {
					os.write(buf, 0, len);
				}
				os.flush();
				os.close();
				
				ins.close();
							
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return imgfile;
	}
}
