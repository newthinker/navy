package cn.com.hd.navy.importmanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.jdom.Document;
import org.jdom.Element;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TAftersaleOrg;
import cn.com.hd.dto.navy.TImage;
import cn.com.hd.dto.navy.TImport;
import cn.com.hd.dto.navy.TStockholder;
import cn.com.hd.dto.navy.TSupProduct;
import cn.com.hd.dto.navy.TSupportor;
import cn.com.hd.dto.navy.TTransport;
import cn.com.hd.error.ErrorProcessor;
import cn.com.hd.service.BaseService;
import cn.com.hd.service.IService;
import cn.com.hd.transfer.Conditions;
import cn.com.hd.transfer.DTO;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import cn.com.hd.transfer.SystemParam;
import cn.com.hd.utils.CompressUtils;
import cn.com.hd.utils.FileUtils;
import cn.com.hd.utils.XMLUtils;

public class SupImportService extends BaseService implements IService {

	@SuppressWarnings("unchecked")
	public Response service(Request request) throws Exception {
		try {
			String folder = UUID.randomUUID().toString();
			String targetPath = SystemParam.getParam("AbsolutePath") + "temp/import/" + folder + "/";
			java.io.File f = new java.io.File(targetPath);
			f.mkdirs();
			
			String target = SystemParam.getParam("AbsolutePath") + "temp/import/" + folder + "/" + folder + ".dat";
			Files files = request.getUpload().getFiles();
			for (int i = 0; i < files.getCount(); i ++) {
				File file = files.getFile(i);
				file.saveAs(target);
			}
			
			CompressUtils.unCompressZip(target, targetPath);
			List<TImage> imgList = new ArrayList<TImage>();
			
			String supXml = targetPath + "/supportor.xml";				// 供应商
			String prodXml = targetPath + "/supportor_product.xml";		// 产品
			String stockXml = targetPath + "/supportor_stock.xml";		// 股东
			String orgXml = targetPath + "/supportor_org.xml";			// 售后
			String tranXml = targetPath + "/supportor_tran.xml";		// 交通运输
			String wayXml = targetPath + "/supportor_highway.xml";		// 高速公路
			
			Map<String, TSupportor> supMap = new HashMap<String, TSupportor>();
			Document doc = XMLUtils.readXML(supXml);
			List supElemList = doc.getRootElement().getChildren("ROW");
			for (int i = 0; i < supElemList.size(); i ++) {
				TSupportor sup = new TSupportor();
				Element elem = (Element) supElemList.get(i);
				sup.fromXMLString(elem);
				String supname = sup.getSupname();
				if (supname == null || supname.trim().equals("")) {
					continue;
				}
				
				String supid = sup.getSupid();
				
				Conditions cons = new Conditions();
				cons.addCondition(new TSupportor());
				cons.addExpression("SUP_NAME = '" + supname + "'");
				
				SelectResultSet rs = queryResultSet(cons);
				List supList = getDTO(rs);
				if (supList.size() == 0) {
					sup.setSupid(UUID.randomUUID().toString());
					save(sup);
				} else {
					TSupportor upsup = new TSupportor();
					DTO supDTO = (DTO) supList.get(0);
					getData(supDTO, upsup);
					sup.setSupid(upsup.getSupid());
					update(sup);
				}
				
				supMap.put(supid, sup);
				
				supid = sup.getSupid();
				TSupProduct prod = new TSupProduct();
				prod.setSupid(supid);
				rs = queryResultSet(prod);
				List list = getDTO(rs);
				for (Object object : list) {
					DTO dto = (DTO) object;
					prod = new TSupProduct();
					getData(dto, prod);
					delete(prod);
				}
				
				TStockholder stock = new TStockholder();
				stock.setSupid(supid);
				rs = queryResultSet(stock);
				list = getDTO(rs);
				for (Object object : list) {
					DTO dto = (DTO) object;
					stock = new TStockholder();
					getData(dto, stock);
					delete(stock);
				}
				
				TAftersaleOrg sale = new TAftersaleOrg();
				sale.setSupid(supid);
				rs = queryResultSet(sale);
				list = getDTO(rs);
				for (Object object : list) {
					DTO dto = (DTO) object;
					sale = new TAftersaleOrg();
					getData(dto, sale);
					delete(sale);
				}
			}
			
			doc = XMLUtils.readXML(prodXml);
			List prodElemList = doc.getRootElement().getChildren("ROW");
			for (int i = 0; i < prodElemList.size(); i ++) {
				Element elem = (Element) prodElemList.get(i);
				TSupProduct prod = new TSupProduct();
				prod.fromXMLString(elem);
				
				prod.setProdid(UUID.randomUUID().toString());
				prod.setSupid(supMap.get(prod.getSupid()).getSupid());
				save(prod);
			}
			
			doc = XMLUtils.readXML(stockXml);
			List stockElemList = doc.getRootElement().getChildren("ROW");
			for (int i = 0; i < stockElemList.size(); i ++) {
				Element elem = (Element) stockElemList.get(i);
				TStockholder stock = new TStockholder();
				stock.fromXMLString(elem);
				
				stock.setStockholderid(UUID.randomUUID().toString());
				stock.setSupid(supMap.get(stock.getSupid()).getSupid());
				save(stock);
			}
			
			doc = XMLUtils.readXML(orgXml);
			List orgElemList = doc.getRootElement().getChildren("ROW");
			for (int i = 0; i < orgElemList.size(); i ++) {
				Element elem = (Element) orgElemList.get(i);
				TAftersaleOrg org = new TAftersaleOrg();
				org.fromXMLString(elem);
				
				org.setOrgid(UUID.randomUUID().toString());
				org.setSupid(supMap.get(org.getSupid()).getSupid());
				save(org);
			}
			
			// 解析交通运输文件
			String comId = null;		// 运输企业
			doc = XMLUtils.readXML(tranXml);
			List tranElemList = doc.getRootElement().getChildren("ROW");
			for (int i = 0; i < tranElemList.size(); i ++) {
				Element elem = (Element) tranElemList.get(i);
				TTransport tran = new TTransport();
				tran.fromXMLString(elem);
				
				tran.setComid(UUID.randomUUID().toString());
				save(tran);
			}
			
			for (TImage img : imgList) {
				String src = targetPath + "/" + img.getImagename();
				String desc = SystemParam.getParam("AbsolutePath") + img.getImagepath();
				try {
					FileUtils.copy(src, desc);
					
					save(img);
				} catch (Exception ex) {
					System.out.println(src);
					System.out.println(desc);
					ex.printStackTrace();
				}
			}
			
			java.io.File tar = new java.io.File(targetPath);
			int filecount = tar.listFiles().length;
			for (int i = 0; i < filecount; i ++) {
				tar.listFiles()[0].delete();
			}
			
			tar.delete();
			
			Response response = new Response();
			
			int result = 1;
			
			response.setResult(result);
			
			return response;
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorProcessor.prompt(this.getClass().getName(), ex.getMessage(), ex);
			Response response = new Response();
			response.setResult(0);
			response.setErrorInfo("导入失败");
			return response;
		}
	}

}
