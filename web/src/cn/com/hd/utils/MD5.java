package cn.com.hd.utils;

/**
 * @(#)MD5.java  1.00 
 * Apr 26, 2008 3:55:28 PM
 * Copyright (c) 2007-2008 __MyCorp 有限公司 版权懿暿
 * __Mycorp Company of China. All rights reserved.
 * 
 * This software is the confidential and proprietary
 * information of __Mycorp Company of China.
 *
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with __Mycorp.
 * 
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 实用java.security.MessageDigest实现MD5的单向加孿
 * 
 * @since BASE 0.1
 */

public class MD5 {

	public MD5() {
	}
	
	public static String encrypt(String orgPass) {
		return getMD5Digest(orgPass);
	}

	/**
	 * 返回将制定的字符串进行MD5单向加密后的结果
	 * 
	 * @param sourceData
	 *            String
	 * @return String 返回将制定的字符串进行MD5单向加密后的结果
	 * @since BASE 0.1
	 */
	public static String getMD5Digest(String sourceData) {
		try {
			MessageDigest alga = MessageDigest.getInstance("MD5");
			// MessageDigest alga=MessageDigest.getInstance("SHA-1");
			alga.update(sourceData.getBytes());
			byte[] digesta = alga.digest();
			return byteToHexString(digesta);
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public static String byteToHexString(byte[] b) { //

		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}

			if (n < b.length - 1)
				hs = hs + "";
		}
		// return hs.toUpperCase();
		return hs;
	}

	public static void main(String[] args) {
		String s = getMD5Digest("976628");
		System.out.println(s);
	}
}
