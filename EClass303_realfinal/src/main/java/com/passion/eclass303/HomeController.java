package com.passion.eclass303;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.passion.eclass303.member.MemberDao;
import com.passion.eclass303.snsboard.SNSBoardDao;

@Controller
public class HomeController {

	@Autowired
	private MemberDao mDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		mDao.loginCheck(request);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	@RequestMapping(value = "/index.go", method = RequestMethod.GET)
	public String home2(HttpServletRequest request) {
		return home(request);
	}

}
