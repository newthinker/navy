package cn.com.hd.navy.supmanager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.jdom.Document;
import org.jdom.Element;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;

import cn.com.hd.database.SelectResultSet;
import cn.com.hd.dto.navy.TAftersaleOrg;
import cn.com.hd.dto.navy.THighWay;
import cn.com.hd.dto.navy.TImage;
import cn.com.hd.dto.navy.TImport;
import cn.com.hd.dto.navy.TProveInfo;
import cn.com.hd.dto.navy.TStockholder;
import cn.com.hd.dto.navy.TSupProduct;
import cn.com.hd.dto.navy.TSupTrans;
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

			String targetDir = SystemParam.getParam("AbsolutePath") + "temp/import/" + 
					new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "_" + UUID.randomUUID().toString() + "/";
			java.io.File f = new java.io.File(targetDir);
			if(!f.exists())
				f.mkdirs();
			
			// 首先判断是单条还是多个记录，如果是多个进行解压
			List arrTarget = new ArrayList<String>();
			Files files = request.getUpload().getFiles();
			for (int i = 0; i < files.getCount(); i ++) {
				File file = files.getFile(i);
				String folder = file.getFileName();
				String target = targetDir + folder;				
				file.saveAs(target);	
				
				String fileExt = file.getFileExt();
				if(fileExt.toLowerCase().equals("zip")) {
					CompressUtils.unCompressZip(target, targetDir);
					FileUtils.delete(file.getFilePathName());
				} else {
					System.out.println("文件格式不正确，请检查！");
					return null;
				}
				
				// 遍历打包文件并保存文件名
				if(f!=null) {
				String[] lf = f.list();
					for (int j = 0; j < lf.length; j ++) {
						String fileName = lf[j];
						if(fileName.substring(fileName.indexOf(".") + 1, fileName.length()).toLowerCase().equals("dat")) 
							arrTarget.add(fileName.substring(0, fileName.indexOf(".")));
					}
				}
			}
			
			// 遍历数组
			Iterator it = arrTarget.iterator();
			while (it.hasNext()) {
				// 首先解压
				String folder = it.next().toString();
				String targetPath = targetDir + folder + "/";
				java.io.File file = new java.io.File(targetPath);
				if(!file.exists()) 	// 创建文件夹
					file.mkdir();
				
				String target = targetDir + folder + ".dat";
				file = new java.io.File(target);
				if(!file.exists())		// 判断文件是否存在
					continue;
				
				CompressUtils.unCompressZip(target, targetPath);
				List<TImage> imgList = new ArrayList<TImage>();
				
				String supXml = targetPath + "supportor.xml";				// 供应商
				String prodXml = targetPath + "supportor_product.xml";		// 产品
				String stockXml = targetPath + "supportor_stock.xml";		// 股东
				String orgXml = targetPath + "supportor_org.xml";			// 售后
				String tranXml = targetPath + "supportor_tran.xml";		// 交通运输
				String wayXml = targetPath + "supportor_highway.xml";		// 高速公路
				String proveXml = targetPath + "supportor_prove.xml";	
				
				// 处理供应商文件
				file = new java.io.File(supXml);		// 如果供应商文件不存在，就处理下一个
				if(!file.exists())
					continue;
				
//				Map<String, TSupportor> supMap = new HashMap<String, TSupportor>();
				String supid = null;
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
					
					supid = sup.getSupid();

					// 供应商信息
					if ( sup.getImage()!=null ) {
						TImage img = new TImage();
						img.setImageid(UUID.randomUUID().toString());
						img.setImagename(sup.getImage());
						
						imgList.add(img);
						sup.setImage(img.getImageid());
					}
					if ( sup.getStorehouseimage()!=null ) {			// 产品图片
						TImage img = new TImage();
						img.setImageid(UUID.randomUUID().toString());
						img.setImagename(sup.getStorehouseimage());
						
						imgList.add(img);
						sup.setStorehouseimage(img.getImageid());
					}
					if ( sup.getLicbusimage()!=null ) {				// 营业执照扫描件
						TImage img = new TImage();
						img.setImageid(UUID.randomUUID().toString());
						img.setImagename(sup.getLicbusimage());
						
						imgList.add(img);
						sup.setLicbusimage(img.getImageid());
					}
					if ( sup.getOrgstrimage()!=null ) {				// 组织结构代码证扫描件
						TImage img = new TImage();
						img.setImageid(UUID.randomUUID().toString());
						img.setImagename(sup.getOrgstrimage());
						
						imgList.add(img);
						sup.setOrgstrimage(img.getImageid());
					}
					if ( sup.getAuditlast3y()!=null ) {				// 近三年审计报告压缩文件--当作图片处理
						TImage img = new TImage();
						img.setImageid(UUID.randomUUID().toString());
						img.setImagename(sup.getAuditlast3y());
						
						imgList.add(img);
						sup.setAuditlast3y(img.getImageid());
					}
					if ( sup.getBankProve()!=null ) {				// 银行资信证明文件扫描件
						TImage img = new TImage();
						img.setImageid(UUID.randomUUID().toString());
						img.setImagename(sup.getBankProve());
						
						imgList.add(img);
						sup.setBankProve(img.getImageid());					
					}				
					if ( sup.getOtherProve()!=null ) {				// 其它证明压缩文件
						TImage img = new TImage();
						img.setImageid(UUID.randomUUID().toString());
						img.setImagename(sup.getOtherProve());
						
						imgList.add(img);
						sup.setOtherProve(img.getImageid());					
					}
					if ( sup.getQualityProve()!=null ) {				// 银行资信证明文件扫描件
						TImage img = new TImage();
						img.setImageid(UUID.randomUUID().toString());
						img.setImagename(sup.getQualityProve());
						
						imgList.add(img);
						sup.setQualityProve(img.getImageid());					
					}				
					
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
					
//					supMap.put(supid, sup);

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
				// 安全检查
				if(supid==null) {
					continue;
				}
				
				// 产品
				file = new java.io.File(prodXml);
				if(file.exists()) {
					doc = XMLUtils.readXML(prodXml);
					List prodElemList = doc.getRootElement().getChildren("ROW");
					for (int i = 0; i < prodElemList.size(); i ++) {
						Element elem = (Element) prodElemList.get(i);
						TSupProduct prod = new TSupProduct();
						prod.fromXMLString(elem);
						
						// 产品
						if ( prod.getProdimage()!=null ) {				// 组织结构代码证扫描件
							TImage img = new TImage();
							img.setImageid(UUID.randomUUID().toString());
							img.setImagename(prod.getProdimage());
							
							imgList.add(img);
							prod.setProdimage(img.getImageid());
						}
						
						prod.setProdid(UUID.randomUUID().toString());
						prod.setSupid(supid);
						save(prod);
					}
				}
				
				// 股东
				file = new java.io.File(stockXml);
				if(file.exists()) {
					doc = XMLUtils.readXML(stockXml);
					List stockElemList = doc.getRootElement().getChildren("ROW");
					for (int i = 0; i < stockElemList.size(); i ++) {
						Element elem = (Element) stockElemList.get(i);
						TStockholder stock = new TStockholder();
						stock.fromXMLString(elem);
						
						stock.setStockholderid(UUID.randomUUID().toString());
						stock.setSupid(supid);
						save(stock);
					}
				}
				
				// 售后
				file = new java.io.File(orgXml);
				if (file.exists()) {
					doc = XMLUtils.readXML(orgXml);
					List orgElemList = doc.getRootElement().getChildren("ROW");
					for (int i = 0; i < orgElemList.size(); i ++) {
						Element elem = (Element) orgElemList.get(i);
						TAftersaleOrg org = new TAftersaleOrg();
						org.fromXMLString(elem);
						
						org.setOrgid(UUID.randomUUID().toString());
						org.setSupid(supid);
						save(org);
					}
				}
				
				// 运输服务
				file = new java.io.File(tranXml);
				if (file.exists()) {
					String comId = null;		// 运输企业
					doc = XMLUtils.readXML(tranXml);
					List tranElemList = doc.getRootElement().getChildren("ROW");
					for (int i = 0; i < tranElemList.size(); i ++) {
						Element elem = (Element) tranElemList.get(i);
						TTransport tran = new TTransport();
						tran.fromXMLString(elem);
						
						// 根据企业名称查询是否已经入库				
						String comName = tran.getComname();
						if ( comName!=null ) {
							TTransport temp = new TTransport();
							temp.setComname(tran.getComname());
							SelectResultSet rs = queryResultSet(temp);
							List list = getDTO(rs);
							if ( list.size()>0 ) {	// 已经录入
								DTO dto = (DTO) list.get(0);
								getData(dto, temp);
								comId = temp.getComid();
							} else {	// 新运输服务企业
								comId = UUID.randomUUID().toString();
								tran.setComid(comId);
								save(tran);
							}						
						} 					
	
					}
								
					if ( comId!=null ) {
						// 建立供应商和运输服务企业间的联系
						TSupTrans supTrans = new TSupTrans();
						supTrans.setSupid(supid);
						supTrans.setComid(comId);
						// 查询是否已经有记录
						SelectResultSet rs = queryResultSet(supTrans);
						List list = getDTO(rs);
						if ( list.size()==0 ) {		// 没有录入
							save(supTrans);
						}				
										
						// 解析高速公路文件 
						// 首先查找数据库中是否已经存在此条记录
						THighWay temp = new THighWay();
						temp.setComid(comId);
						rs = queryResultSet(temp);
						list = getDTO(rs);
						if( list.size()==0 ) {
							doc = XMLUtils.readXML(wayXml);
							List wayElemList = doc.getRootElement().getChildren("ROW");
							for (int i = 0; i < wayElemList.size(); i++) {
								Element elem = (Element) wayElemList.get(i);
								THighWay way = new THighWay();
								way.fromXMLString(elem);
								
								way.setComid(comId);
								save(way);
							}
						}			
					}
				}
				
				// 图片处理
				for (TImage img : imgList) {
					// 从文件名中获取文件类型
					String imgName = img.getImagename();
					String imgType = imgName.substring(imgName.lastIndexOf('.')+1);
					img.setImagetype(imgType);
					String src = targetPath + imgName;
					
					imgName = img.getImageid() + "." + imgType;
					img.setImagename(imgName);
					
					String desc = SystemParam.getParam("AbsolutePath") + "ImgDir";
					file = new java.io.File(desc);
					if (!file.exists())
						file.mkdir();
					desc = desc + "/" + imgName;
					
					try {						
						file = new java.io.File(src);
						if(!file.exists())
							continue;
						
						FileUtils.copy(src, desc);
						
						save(img);
					} catch (Exception ex) {
						System.out.println(src);
						System.out.println(desc);
						ex.printStackTrace();
					}
				}	
				
				// 删除文件
				java.io.File tar = new java.io.File(targetPath);
				int filecount = tar.listFiles().length;
				for (int i = 0; i < filecount; i ++) {
					tar.listFiles()[0].delete();
				}
				
				tar.delete();
								
			}
			
			// 将源文件删除
			f = new java.io.File(targetDir);
			int count = f.listFiles().length;
			for(int i=0; i<count; i++) {
				f.listFiles()[0].delete();
			}
			f.delete();
			
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
