package com.passion.eclass303.tokenmanager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

public class TokenManager {

	
	public static void makeToken(HttpServletRequest request) {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		String token = sdf.format(now);
		request.getSession().setAttribute("token", token);
	}
	
	public static void makeUUID(HttpServletRequest request) {
		String randomUUID = UUID.randomUUID().toString().replace("-", "");
	}
}
