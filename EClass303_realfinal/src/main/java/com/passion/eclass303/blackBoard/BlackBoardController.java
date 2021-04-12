package com.passion.eclass303.blackBoard;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.passion.eclass303.member.MemberDao;

@Controller
public class BlackBoardController {

	@Autowired
	private MemberDao mDao;

	@RequestMapping(value = "/go.blackboard", method = RequestMethod.GET)
	public String goBlackBoard(HttpServletRequest request) {
		mDao.loginCheck(request);
		request.setAttribute("contentPage", "BlackBoard/blackBoard.jsp");
		return "index";
	}

}
