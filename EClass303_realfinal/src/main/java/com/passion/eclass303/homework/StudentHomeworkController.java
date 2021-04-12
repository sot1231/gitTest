package com.passion.eclass303.homework;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.passion.eclass303.member.MemberDao;
import com.passion.eclass303.tokenmanager.TokenManager;

@Controller
public class StudentHomeworkController {
	@Autowired
	private MemberDao MDAO;
	@Autowired
	private HomeworkDAO HDAO;
	@Autowired
	private StudentHomeworkDAO SDAO;

	// 과제 등록 게시판 입장
	@RequestMapping(value = "/student.reg.page", method = RequestMethod.GET)
	public String goStudentRegPage(HttpServletRequest request, Homework hw) {
		MDAO.loginCheck(request);
		TokenManager.makeToken(request);
		request.setAttribute("contentPage", "homework/regStudentHomework.jsp");
		return "index";
	}

	// 과제 등록
	@RequestMapping(value = "/student.homework.reg", method = RequestMethod.POST)
	public String regStudentHomework(HttpServletRequest request, StudentHomework shw) {
		MDAO.loginCheck(request);
		SDAO.studentRegHomework(request, shw);
		HDAO.clearHomeworkDetail(request);
		HDAO.countAllHomework();
		HDAO.clearSearch(request);
		HDAO.clearCategory(request);
		HDAO.clearPerPage(request);
		HDAO.getAllHomework(1, request);
		TokenManager.makeToken(request);
		request.setAttribute("contentPage", "homework/homeworkBoard.jsp");
		return "index";
	}

}
