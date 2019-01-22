package com.tool.wechat;

import com.common.wechat.*;
import java.security.MessageDigest;
import java.util.Arrays;

public class SHA1 {

	public static String getSHA1(String token, String timestamp, String nonce, String encrypt) 
			throws AesException {
		try {
			String[] array = new String[] { token, timestamp, nonce, encrypt };
			StringBuffer sb = new StringBuffer();
			// ×Ö·û´®ÅÅÐò
			Arrays.sort(array);
			for (int i = 0; i < 4; i++) {
				sb.append(array[i]);
			}
			String str = sb.toString();
			// SHA1Ç©ÃûÉú³É
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ComputeSignatureError);
		}
	}
	
	public static String getSHA1New(String token, String timestamp, String nonce) 
			throws AesException {
		try {
			String[] array = new String[] { token, timestamp, nonce };
			StringBuffer sb = new StringBuffer();
			// ×Ö·û´®ÅÅÐò
			Arrays.sort(array);
			for (int i = 0; i < 3; i++) {
				sb.append(array[i]);
			}
			String str = sb.toString();
			// SHA1Ç©ÃûÉú³É
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ComputeSignatureError);
		}
	}
}