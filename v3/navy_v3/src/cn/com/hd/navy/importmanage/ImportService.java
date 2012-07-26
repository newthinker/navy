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

public class ImportService extends BaseService implements IService {

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
			
			String impXml = targetPath + "/import.xml";
			String supXml = targetPath + "/supportor.xml";
			String prodXml = targetPath + "/supportor_product.xml";
			String stockXml = targetPath + "/supportor_stock.xml";
			String orgXml = targetPath + "/supportor_org.xml";
			
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
			
			doc = XMLUtils.readXML(impXml);
			List impElemList = doc.getRootElement().getChildren("ROW");
			for (int i = 0; i < impElemList.size(); i ++) {
				Element elem = (Element) impElemList.get(i);
				TImport imp = new TImport();
				imp.fromXMLString(elem);
				String project = imp.getProject();
				
				if (project == null || project.trim().equals("")) {
					continue;
				}
				
				Conditions cons = new Conditions();
				cons.addCondition(new TImport());
				cons.addExpression("PROJECT = '" + project + "'");
				SelectResultSet result = queryResultSet(cons);
				List retList = getDTO(result);
				
				String importid = null;
				if (retList.size() == 0) {
					importid = UUID.randomUUID().toString();
				} else {
					DTO impDTO = (DTO) retList.get(0);
					TImport upimp = new TImport(); 
					getData(impDTO, upimp);
					importid = upimp.getImportid();
				}
				
				imp.setImportid(importid);
				String planid = UUID.randomUUID().toString();
				String compactid = UUID.randomUUID().toString();
				String agreeid = UUID.randomUUID().toString();
				String examineid = UUID.randomUUID().toString();
				String imageid = UUID.randomUUID().toString();
				
				String imgfile = imp.getPlanid();
				String[] imgfiles = imgfile.split("#");
				if (imgfile != null && !imgfile.trim().equals("")) {
					for (int j = 0; j < imgfiles.length; j ++) {
						if (imgfiles[j] != null && !imgfiles[j].trim().equals("")) {
							TImage img = new TImage();
							img.setImageid(UUID.randomUUID().toString());
							img.setImportid(importid);
							img.setImagetypeid(planid);
							img.setImagetype("PLAN");
							img.setImagename(imgfiles[j]);
							img.setImageorder(j + 1);
							img.setImagepath("navy/import/" + importid + "/plan/" + imgfiles[j]);
							
							imgList.add(img);
						}
					}
				}
				
				imgfile = imp.getCompactid();
				imgfiles = imgfile.split("#");
				if (imgfile != null && !imgfile.trim().equals("")) {
					for (int j = 0; j < imgfiles.length; j ++) {
						if (imgfiles[j] != null && !imgfiles[j].trim().equals("")) {
							TImage img = new TImage();
							img.setImageid(UUID.randomUUID().toString());
							img.setImportid(importid);
							img.setImagetypeid(compactid);
							img.setImagetype("COMPACT");
							img.setImagename(imgfiles[j]);
							img.setImageorder(j + 1);
							img.setImagepath("navy/import/" + importid + "/compact/" + imgfiles[j]);
							
							imgList.add(img);
						}
					}
				}

				imgfile = imp.getAgreeid();
				imgfiles = imgfile.split("#");
				if (imgfile != null && !imgfile.trim().equals("")) {
					for (int j = 0; j < imgfiles.length; j ++) {
						if (imgfiles[j] != null && !imgfiles[j].trim().equals("")) {
							TImage img = new TImage();
							img.setImageid(UUID.randomUUID().toString());
							img.setImportid(importid);
							img.setImagetypeid(agreeid);
							img.setImagetype("AGREE");
							img.setImagename(imgfiles[j]);
							img.setImageorder(j + 1);
							img.setImagepath("navy/import/" + importid + "/agree/" + imgfiles[j]);
							
							imgList.add(img);
						}
					}
				}

				imgfile = imp.getExamineid();
				imgfiles = imgfile.split("#");
				if (imgfile != null && !imgfile.trim().equals("")) {
					for (int j = 0; j < imgfiles.length; j ++) {
						if (imgfiles[j] != null && !imgfiles[j].trim().equals("")) {
							TImage img = new TImage();
							img.setImageid(UUID.randomUUID().toString());
							img.setImportid(importid);
							img.setImagetypeid(examineid);
							img.setImagetype("EXAMINE");
							img.setImagename(imgfiles[j]);
							img.setImageorder(j + 1);
							img.setImagepath("navy/import/" + importid + "/examine/" + imgfiles[j]);
							
							imgList.add(img);
						}
					}
				}

				imgfile = imp.getImage();
				imgfiles = imgfile.split("#");
				if (imgfile != null && !imgfile.trim().equals("")) {
					for (int j = 0; j < imgfiles.length; j ++) {
						if (imgfiles[j] != null && !imgfiles[j].trim().equals("")) {
							TImage img = new TImage();
							img.setImageid(UUID.randomUUID().toString());
							img.setImportid(importid);
							img.setImagetypeid(imageid);
							img.setImagetype("IMAGE");
							img.setImagename(imgfiles[j]);
							img.setImageorder(j + 1);
							img.setImagepath("navy/import/" + importid + "/image/" + imgfiles[j]);
							
							imgList.add(img);
						}
					}
				}
				
				imp.setPlanid(planid);
				imp.setCompactid(compactid);
				imp.setAgreeid(agreeid);
				imp.setExamineid(examineid);
				imp.setImage(imageid);
				
				String supid = imp.getSupportorid();
				imp.setSupportorid(supMap.get(supid).getSupid());
				imp.setSupportor(supMap.get(supid).getSupname());
				imp.setSupportoraddr(supMap.get(supid).getAddress());
				
				if (retList.size() == 0) {
					save(imp);
				} else {
					update(imp);
				}
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
			response.setErrorInfo("µ¼ÈëÊ§°Ü");
			return response;
		}
	}

}
