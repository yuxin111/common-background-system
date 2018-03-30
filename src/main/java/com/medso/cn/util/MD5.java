package com.medso.cn.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class MD5 {
	public static void main(String[] args) {
		String newPassword = new SimpleHash(
	    		"MD5",
	    		"123"
	    	).toString();
		System.out.println(newPassword);
	}
}
