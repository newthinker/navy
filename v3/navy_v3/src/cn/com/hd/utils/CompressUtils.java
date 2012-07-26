package cn.com.hd.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Enumeration;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

public class CompressUtils {

	public static void compressZip(String source, String destination) throws Exception {
		ZipOutputStream zos = null;
		try {
			zos = new ZipOutputStream(new FileOutputStream(destination));
			File files = new File(source);
			for (int i = 0; i < files.listFiles().length; i ++) {
				File file = files.listFiles()[i];
				FileInputStream fis = new FileInputStream(file);
				ZipEntry entry = new ZipEntry(file.getName());
				zos.putNextEntry(entry);
				byte[] buf = new byte[1024];
				int len = 0;
				while ((len = fis.read(buf)) != -1) {
					zos.write(buf, 0, len);
				}
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (zos != null) {
				zos.close();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void unCompressZip(String source, String destination) throws Exception {
		try {
			ZipFile zipFile = new ZipFile(source);
			Enumeration emu = zipFile.getEntries();
			while (emu.hasMoreElements()) {
				ZipEntry entry = (ZipEntry) emu.nextElement();

				if (entry.isDirectory()) {
					new File(destination + entry.getName()).mkdirs();
					continue;
				}
				
				BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(entry));
				File file = new File(destination + entry.getName());
				
				File parent = file.getParentFile();
				if (parent != null && (!parent.exists())) {
					parent.mkdirs();
				}
				
				FileOutputStream fos = new FileOutputStream(file);
				BufferedOutputStream bos = new BufferedOutputStream(fos, 1024);
				int count;
				byte data[] = new byte[1024];
				while ((count = bis.read(data)) != -1) {
					bos.write(data, 0, count);
				}
				
				bos.flush();
				bos.close();
				bis.close();
			}
			
			zipFile.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}
