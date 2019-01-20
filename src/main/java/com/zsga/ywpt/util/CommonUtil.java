package com.zsga.ywpt.util;

public class CommonUtil {
	
	/**
	 * 验证码输入时去掉前后空格，以及转换为大写字母
	 * @param str
	 * @return
	 */
	public static String stringUtil(String str) {
		String digital = "0123456789";
		String sletter = "abcdefghijklmnopqrstuvwxyz";
		String bletter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		//去除前后空格
		String result = str.trim();
		char[] ch = result.toCharArray();
		//将小写字符转换为大写字母
		for (int i=0; i<ch.length; i++) {
			if (digital.indexOf(ch[i]) != -1 || bletter.indexOf(ch[i]) != -1) {
				continue;
			} else if (sletter.indexOf(ch[i]) != -1) {
				ch[i] = (char) (ch[i] - 32);
			}
		}
		return new String(ch);
	}
}
