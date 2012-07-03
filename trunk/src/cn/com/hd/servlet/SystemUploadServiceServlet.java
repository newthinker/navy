package cn.com.hd.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import cn.com.hd.database.DBOperator;
import cn.com.hd.error.ErrorProcessor;
import cn.com.hd.manager.SystemServiceManager;
import cn.com.hd.transfer.LoginInfo;
import cn.com.hd.transfer.Request;
import cn.com.hd.transfer.Response;
import cn.com.hd.transfer.SystemParam;
import cn.com.hd.xmlparser.DataXMLParser;

public class SystemUploadServiceServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -434744493964889807L;

	/**
	 * Constructor of the object.
	 */
	public SystemUploadServiceServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String size = request.getParameter("size");
		String encoding = SystemParam.getParam("ENCODING");
		if (encoding == null) {
			encoding = "UTF-8";
		}
		
		request.setCharacterEncoding(encoding);
		
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		
		if (size != null) {
			su.setMaxFileSize(Long.valueOf(size) * 1024 * 1024);
			su.setTotalMaxFileSize(Long.valueOf(size) * 1024 * 1024 * 5);
		}
		
		try {
			su.upload();
		} catch (SmartUploadException ex) {
			ex.printStackTrace();
		} catch (SecurityException ex) {
			Response resp = new Response();
			resp.setErrorInfo("文件大小应小于" + size + "M");
			request.setAttribute("XML_DATA", resp);
			
			String url = request.getParameter("url");
			if (url != null) {
				request.getRequestDispatcher(url).forward(request, response);
			}
			
			return;
		}
		
		String xml = su.getRequest().getParameter("XML_DATA");
		Request req = null;
		List<DBOperator> dbOperatorList = new ArrayList<DBOperator>();;
		try {
			if (xml == null) {
				BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream)request.getInputStream())); 
				String line = null; 
				StringBuilder sb = new StringBuilder(); 
				while((line = br.readLine())!=null){ 
					sb.append(line); 
				}     
				br.close();
				
				xml = sb.toString();
			}
			
			req = DataXMLParser.buildRequest(xml);
			
			req.getDto().put("SESSION", request.getSession());
			req.getDto().put("LOGININFO", new LoginInfo(request));
			req.setUpload(su);
			Response resp = SystemServiceManager.service(req, dbOperatorList);
			
			for (DBOperator dbOperator : dbOperatorList) { 
				dbOperator.commit();
			} 
			
			if (resp == null) {
				resp = new Response();
			}
			
			String sKeyUserid = SystemParam.getParam("SessionUserid");
			if (sKeyUserid == null) {
				sKeyUserid = "USER_ID";
			}
			
			String sKeyUsername = SystemParam.getParam("SessionUserid");
			if (sKeyUsername == null) {
				sKeyUsername = "USER_NAME";
			}
			
			String sKeyDeptid = SystemParam.getParam("SessionUserid");
			if (sKeyDeptid == null) {
				sKeyDeptid = "DEPT_ID";
			}
			
			String sKeyDeptname = SystemParam.getParam("SessionUserid");
			if (sKeyDeptname == null) {
				sKeyDeptname = "DEPT_NAME";
			}
			
			String userid = resp.getDto().getString(sKeyUserid);
			String username = resp.getDto().getString(sKeyUsername);
			String deptid = resp.getDto().getString(sKeyDeptid);
			String deptname = resp.getDto().getString(sKeyDeptname);
			
			if (userid != null) {
				request.getSession().setAttribute(sKeyUserid, userid);
				request.getSession().setAttribute(sKeyUsername, username);
				request.getSession().setAttribute(sKeyDeptid, deptid);
				request.getSession().setAttribute(sKeyDeptname, deptname);
			}
			
			if (req != null && req.getIsremote() != null && req.getIsremote().equalsIgnoreCase("true")) {
				OutputStream os = response.getOutputStream(); 
				os.write(resp.toXMLString().getBytes());
				
				req.setIsremote("false");
				
			} else {
				request.setAttribute("XML_DATA", resp);
				
				if (req != null && req.getDispatcherUrl() != null) {
					request.getRequestDispatcher(req.getDispatcherUrl()).forward(request, response);
				}
			}
			
		} catch (Exception ex) {
			for (DBOperator dbOperator : dbOperatorList) { 
				try {
					dbOperator.rollback();
				} catch (Exception e) {
					ErrorProcessor.prompt(SystemUploadServiceServlet.class.getName(), e.getMessage(), e);
					Response resp = new Response();
					resp.setErrorInfo(e.getMessage());
					if (req != null && req.getIsremote() != null && req.getIsremote().equalsIgnoreCase("true")) {
						OutputStream os = response.getOutputStream(); 
						os.write(resp.toXMLString().getBytes());
						
						req.setIsremote("false");
						
					} else {
						request.setAttribute("XML_DATA", resp);
						
						if (req != null && req.getDispatcherUrl() != null) {
							request.getRequestDispatcher(req.getDispatcherUrl()).forward(request, response);
						}
					}
				}
			}
			ErrorProcessor.prompt(SystemUploadServiceServlet.class.getName(), ex.getMessage(), ex);
			Response resp = new Response();
			resp.setErrorInfo(ex.getMessage());
			if (req != null && req.getIsremote() != null && req.getIsremote().equalsIgnoreCase("true")) {
				OutputStream os = response.getOutputStream(); 
				os.write(resp.toXMLString().getBytes());
				
				req.setIsremote("false");
				
			} else {
				request.setAttribute("XML_DATA", resp);
				
				if (req != null && req.getDispatcherUrl() != null) {
					request.getRequestDispatcher(req.getDispatcherUrl()).forward(request, response);
				}
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
