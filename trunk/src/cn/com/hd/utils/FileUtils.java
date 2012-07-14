package cn.com.hd.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

	public static String copy(String source, String dest) throws Exception {
		File sourceFile = new File(source);
		File destFile = new File(dest);
		return copy(sourceFile, destFile);
	}
	
	public static String copy(File source, File dest) throws IOException {
		if (!source.exists()) {
			throw new IOException("源文件不存在");
		}
		
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		
		/*
		int i = 1;
		
		
		while (dest.exists()) {
			String filename = dest.getName();
			String name = StringUtils.getFileName(filename);
			String ext = StringUtils.getFileExtName(filename);
			dest = new File(dest.getParentFile().getAbsolutePath() + name + "(" + i ++ +  ")." + ext);
		}
		*/
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int length = 0;
			
			while ((length = fis.read(buf)) != -1) {
				fos.write(buf, 0, length);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new IOException("文件拷备失败");
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException ex) {
				}
			}
			
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException ex) {
				}
			}
		}
		
		return dest.getAbsolutePath().replaceAll("\\\\", "/");
	}
	
	public static void delete(String source) {
		File sourceFile = new File(source);
		sourceFile.delete();
	}
	
}
