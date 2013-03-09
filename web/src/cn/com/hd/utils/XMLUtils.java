package cn.com.hd.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

public class XMLUtils {

	public static Document readXML(String path) {
		SAXBuilder sax = new SAXBuilder();
		try {
			Document doc = sax.build(path);
			
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void saveXML(String filepath, String xml) {
		File file = new File(filepath);
		
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			
			fos.write(xml.getBytes("UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
