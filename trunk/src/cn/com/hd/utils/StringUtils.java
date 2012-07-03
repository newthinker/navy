/*******************************************************************************
 * �ļ�����StringUtils.java
 * 
 * Copyright 2007 HD Co.[www.huadi.com.cn]
 * 
 * ���ߣ�Huadi
 * 
 * �������ڣ�2007-09-11
 * 
 * ˵������Ҫ�����ΪStringUtils
 ******************************************************************************/
package cn.com.hd.utils;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * ��Ϊ�����ַ����Ĺ���
 * 
 * @author Huadi
 * 
 * @version 1.0 2007-09-11
 */
public class StringUtils {

	/**
	 * ��½������Կ
	 */
	private static final String PASSWORD_CRYPT_KEY = "huadifgw";

	/**
	 * DES
	 */
	private final static String DES = "DES";

	/**
	 * ������ת�ַ���
	 * 
	 * @param b ������
	 * 
	 * @return �ַ���
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
	 * ����
	 * 
	 * @param src ����Դ
	 * 
	 * @param key ��Կ�����ȱ�����8�ı���
	 * 
	 * @return ���ؽ��ܺ��ԭʼ����
	 * 
	 * @throws Exception
	 */
	public static byte[] decrypt(byte[] src, byte[] key) throws Exception {
		//DES�㷨Ҫ����һ�������ε������Դ
		SecureRandom sr = new SecureRandom();

		//��ԭʼ�ܳ����ݴ���һ��DESKeySpec����
		DESKeySpec dks = new DESKeySpec(key);

		//����һ���ܳ׹�����Ȼ��������DESKeySpec����ת���ɣ�һ��SecretKey����
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		//Cipher����ʵ����ɽ��ܲ���
		Cipher cipher = Cipher.getInstance(DES);

		//���ܳ׳�ʼ��Cipher����
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

		// ���ڣ���ȡ���ݲ�����

		return cipher.doFinal(src);

	}

	/**
	 * �������
	 * 
	 * @param data Դ�ַ�
	 * 
	 * @return ���ܺ��ַ�
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
	 * ����
	 * 
	 * @param src ����Դ
	 * 
	 * @param key ��Կ�����ȱ�����8�ı���
	 * 
	 * @return ���ؼ��ܺ������
	 * 
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] src, byte[] key) throws Exception {
		//DES�㷨Ҫ����һ�������ε������Դ
		SecureRandom sr = new SecureRandom();

		//��ԭʼ�ܳ����ݴ���DESKeySpec����
		DESKeySpec dks = new DESKeySpec(key);

		//����һ���ܳ׹�����Ȼ��������DESKeySpecת���ɣ�һ��SecretKey����
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		//Cipher����ʵ����ɼ��ܲ���
		Cipher cipher = Cipher.getInstance(DES);

		//���ܳ׳�ʼ��Cipher����
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

		//���ڣ���ȡ���ݲ�����

		return cipher.doFinal(src);
	}

	/**
	 * ����
	 * 
	 * @param password Դ�ַ�
	 * 
	 * @return ���ܺ��ַ�
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
	 * ����ļ���չ��
	 * 
	 * @param name ����ȫ·��
	 * 
	 * @return �ļ���չ��
	 */
	public static String getFileExtName(String name) {
		int index = name.lastIndexOf(".");
		if (index == -1) {
			return name;
		}
		
		return name.substring(index + 1, name.length());
	}

	/**
	 * ����ļ�����
	 * 
	 * @param name �ļ�����
	 * @param pattern ·���ָ���
	 *  
	 * @return �ļ�����
	 */
	public static String getFileFullName(String name, String pattern) {
		int index = name.lastIndexOf(pattern);
		
		if (index == -1) {
			return name;
		}
		
		return name.substring(index + 1, name.length());
	}
	
	/**
	 * ����ļ�·��
	 * 
	 * @param name �ļ�·��
	 *  
	 * @return �ļ�·��
	 */
	public static String getFileFullPath(String name, String pattern) {
		int index = name.lastIndexOf(pattern);
		if (index == -1) {
			return name;
		}
		
		return name.substring(0, index);
	}
	
	/**
	 * ����ļ�����
	 * 
	 * @param name ����ȫ·��
	 * @return �ļ�����
	 */
	public static String getFileName(String name) {
		int index = name.lastIndexOf(".");
		if (index == -1) {
			return name;
		}
		
		return name.substring(0, index);
	}
	
	/**
	 * hexתΪ�ֽ�
	 * 
	 * @param b Դ����
	 * 
	 * @return ���������
	 */
	public static byte[] hex2byte(byte[] b) {
		if ((b.length % 2) != 0) {
			throw new IllegalArgumentException("���Ȳ���ż��");
		}

		byte[] b2 = new byte[b.length / 2];

		for (int n = 0; n < b.length; n += 2) {
			String item = new String(b, n, 2);

			b2[n / 2] = (byte) Integer.parseInt(item, 16);
		}

		return b2;
	}
	
	/**
	 * �ַ�������ĸСд
	 * 
	 * @param string Դ�ַ���
	 * 
	 * @return ������ַ�
	 */
	public static String toCapitalLower(String string) {
		String first = new String(new char[] {string.charAt(0)});
		return string.replaceFirst(first, first.toLowerCase());
	}
	
	/**
	 * �ַ�������ĸ��д
	 * 
	 * @param string Դ�ַ���
	 * 
	 * @return ������ַ�
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
