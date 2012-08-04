/*******************************************************************************
 * 文件名：StringUtils.java
 * 
 * Copyright 2007 HD Co.[www.huadi.com.cn]
 * 
 * 作者：Huadi
 * 
 * 创建日期：2007-09-11
 * 
 * 说明：主要设计类为StringUtils
 ******************************************************************************/
package cn.com.hd.utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * 类为处理字符串的工具
 * 
 * @author Huadi
 * 
 * @version 1.0 2007-09-11
 */
public class StringUtils {

	/**
	 * 登陆密码密钥
	 */
	private static final String PASSWORD_CRYPT_KEY = "huadifgw";

	/**
	 * DES
	 */
	private final static String DES = "DES";

	/**
	 * 二进制转字符串
	 * 
	 * @param b 二进制
	 * 
	 * @return 字符串
	 */
	public static String byte2hex(byte[] b) {
		String hs = "";

		String stmp = "";

		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));

			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}

		return hs.toUpperCase();
	}

	/**
	 * 解密
	 * 
	 * @param src 数据源
	 * 
	 * @param key 密钥，长度必须是8的倍数
	 * 
	 * @return 返回解密后的原始数据
	 * 
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] src, byte[] key) throws Exception {
		//DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		//从原始密匙数据创建一个DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		//创建一个密匙工厂，然后用它把DESKeySpec对象转换成，一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		//Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(DES);

		//用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

		// 现在，获取数据并解密

		return cipher.doFinal(src);

	}

	/**
	 * 密码解密
	 * 
	 * @param data 源字符
	 * 
	 * @return 解密后字符
	 * 
	 * @throws Exception
	 */
	public final static String decrypt(String data) {
		try {
			return new String(decrypt(hex2byte(data.getBytes()),
			PASSWORD_CRYPT_KEY.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 加密
	 * 
	 * @param src 数据源
	 * 
	 * @param key 密钥，长度必须是8的倍数
	 * 
	 * @return 返回加密后的数据
	 * 
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] src, byte[] key) throws Exception {
		//DES算法要求有一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		//从原始密匙数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		//创建一个密匙工厂，然后用它把DESKeySpec转换成，一个SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		//Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);

		//用密匙初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

		//现在，获取数据并加密

		return cipher.doFinal(src);
	}

	/**
	 * 加密
	 * 
	 * @param password 源字符
	 * 
	 * @return 加密后字符
	 * 
	 * @throws Exception
	 */
	public final static String encrypt(String password) {
		try {
			return byte2hex(encrypt(password.getBytes(), PASSWORD_CRYPT_KEY
					.getBytes()));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 获得文件扩展名
	 * 
	 * @param name 名称全路径
	 * 
	 * @return 文件扩展名
	 */
	public static String getFileExtName(String name) {
		int index = name.lastIndexOf(".");
		if (index == -1) {
			return name;
		}
		
		return name.substring(index + 1, name.length());
	}

	/**
	 * 获得文件名称
	 * 
	 * @param name 文件名称
	 * @param pattern 路径分隔符
	 *  
	 * @return 文件名称
	 */
	public static String getFileFullName(String name, String pattern) {
		int index = name.lastIndexOf(pattern);
		
		if (index == -1) {
			return name;
		}
		
		return name.substring(index + 1, name.length());
	}
	
	/**
	 * 获得文件路径
	 * 
	 * @param name 文件路径
	 *  
	 * @return 文件路径
	 */
	public static String getFileFullPath(String name, String pattern) {
		int index = name.lastIndexOf(pattern);
		if (index == -1) {
			return name;
		}
		
		return name.substring(0, index);
	}
	
	/**
	 * 获得文件名称
	 * 
	 * @param name 名称全路径
	 * @return 文件名称
	 */
	public static String getFileName(String name) {
		int index = name.lastIndexOf(".");
		if (index == -1) {
			return name;
		}
		
		return name.substring(0, index);
	}
	
	/**
	 * hex转为字节
	 * 
	 * @param b 源数据
	 * 
	 * @return 处理后数据
	 */
	public static byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0) {
			throw new IllegalArgumentException("长度不是偶数");
		}

		byte[] b2 = new byte[b.length / 2];

		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);

			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}

		return b2;
	}
	
	/**
	 * 字符串首字母小写
	 * 
	 * @param string 源字符串
	 * 
	 * @return 处理后字符
	 */
	public static String toCapitalLower(String string) {
		String first = new String(new char[] {string.charAt(0)});
		return string.replaceFirst(first, first.toLowerCase());
	}
	
	/**
	 * 字符串首字母大写
	 * 
	 * @param string 源字符串
	 * 
	 * @return 处理后字符
	 */
	public static String toCapitalUpper(String string) {
		String first = new String(new char[] {string.charAt(0)});
		return string.replaceFirst(first, first.toUpperCase());
	}
	
	public static int realLength(String str) {
		int i, len, ret;
		if (str == null) {
			return 0;
		}

		str = "" + str;
		len = str.length();

		ret = 0;
		for (i = 0; i < len; i++) {
			if (str.charAt(i) < 0x80) {
				ret ++;
			} else {
				ret += 2;
			}
		}

		return ret;
	}
	
}
