package cn.com.hd.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertUtils {

	public static String parseString(String value) {
		return value;
	}
	
	public static Integer parseInt(String value) {
		if (value == null) {
			return null;
		}
		
		Integer number = null;
		
		try {
			number = Integer.valueOf(value);
		} catch (Exception ex) {
			System.out.println("error in convert Integer from " + value);
		}
		
		return number;
	}
	
	public static Date parseDate(String value) {
		if (value == null) {
			return null;
		}
		
		Date date = null;
		
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(value);
		} catch (Exception ex) {
			System.out.println("error in convert Integer from " + value);
		}
		
		return date;
	}
	
	public static Double parseDouble(String value) {
		if (value == null) {
			return null;
		}
		
		Double number = null;
		
		try {
			number = Double.valueOf(value);
		} catch (Exception ex) {
			System.out.println("error in convert Integer from " + value);
		}
		
		return number;
	}
	
	public static Float parseFloat(String value) {
		if (value == null) {
			return null;
		}
		
		Float number = null;
		
		try {
			number = Float.valueOf(value);
		} catch (Exception ex) {
			System.out.println("error in convert Integer from " + value);
		}
		
		return number;
	}
	
	public static Long parseLong(String value) {
		if (value == null) {
			return null;
		}
		
		Long number = null;
		
		try {
			number = Long.valueOf(value);
		} catch (Exception ex) {
			System.out.println("error in convert Integer from " + value);
		}
		
		return number;
	}
}
