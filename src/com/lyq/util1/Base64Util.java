package com.lyq.util1;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Util {
	public static String getBase64(String s) {
		if (s == null) {
			return null;
		}
		return (new BASE64Encoder()).encode(s.getBytes());

	}
	public static String getFromBase64(String string) {
		if (string==null) {
			return null;
		}
		BASE64Decoder decoder=new BASE64Decoder();
		try {		
			byte[] bytes=decoder.decodeBuffer(string);
			return new String(bytes);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
