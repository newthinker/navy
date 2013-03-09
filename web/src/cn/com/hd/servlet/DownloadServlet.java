package cn.com.hd.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.hd.error.Debug;
import cn.com.hd.utils.StringUtils;

public class DownloadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public DownloadServlet() {
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
		String path = StringUtils.decrypt(request.getParameter("download"));
		String filename = StringUtils.decrypt(request.getParameter("filename"));
		
		if (path == null) {
			response.getOutputStream().println("<script language='javascript'>alert('下载失败');</script>");
			return;
		}
		
		File file = new File(path);
		Debug.debugMessage("download file ====== " + file.getAbsolutePath());
		if (!file.exists()) {
			response.getOutputStream().println("<script language='javascript'>alert('未找到文件');</script>");
			return;
		}
		
		if (filename == null || filename.equals("")) {
			filename = StringUtils.getFileName(path);
		}
		
		filename = URLEncoder.encode(filename, "UTF-8");
		if (filename.length() > 150) {
			filename = new String(filename.getBytes("gb2312"), "ISO8859-1");
		}
		
		FileInputStream is = new FileInputStream(file);
		response.addHeader("Content-Disposition","attachment;filename=" + filename);

		try {
			byte[] b = new byte[1024];
			int i = 0;
			
			while((i = is.read(b)) > 0) {
				response.getOutputStream().write(b, 0, i);
			}
	        
			response.getOutputStream().flush();
		} catch(Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
		} finally {
			if (is != null) {
				is.close();
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
