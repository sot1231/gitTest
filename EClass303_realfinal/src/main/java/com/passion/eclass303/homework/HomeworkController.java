package com.passion.eclass303.homework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.passion.eclass303.member.MemberDao;
import com.passion.eclass303.tokenmanager.TokenManager;

@Controller
public class HomeworkController {

	@Autowired
	private MemberDao MDAO;
	@Autowired
	private HomeworkDAO HDAO;
	@Autowired
	private StudentHomeworkDAO SDAO;
	
	// 과제 게시판 입장
	@RequestMapping(value = "/homework.go", method = RequestMethod.GET )
	public String goHomework(HttpServletRequest request, HttpServletResponse response) {
		MDAO.loginCheck(request);
		HDAO.clearSearch(request);
		HDAO.clearCategory(request);
		HDAO.clearPerPage(request);
		HDAO.clearHomeworkDetail(request);
		HDAO.countAllHomework();
		HDAO.getAllHomework(1, request);
		request.setAttribute("contentPage","homework/homeworkBoard.jsp");
		return "index";
	}
	
	// 과제 게시판 페이지 전환
	@RequestMapping(value = "/homework.change", method = RequestMethod.GET )
	public String changePage(HttpServletRequest request) {
		MDAO.loginCheck(request);
		int p = Integer.parseInt(request.getParameter("page"));
		HDAO.getAllHomework(p, request);
		request.setAttribute("contentPage","homework/homeworkBoard.jsp");
		return "index";
	}
	
	// 과제 게시판 검색 기능 사용
	@RequestMapping(value = "/homework.search", method = RequestMethod.GET )
	public String searchHomework(HttpServletRequest request) {
		MDAO.loginCheck(request);
		HDAO.clearCategory(request);
		HDAO.searchHomework(request);
		HDAO.getAllHomework(1, request);
		request.setAttribute("contentPage","homework/homeworkBoard.jsp");
		return "index";
	}

	// 과제 게시판 카테고리 변경
	@RequestMapping(value = "/homework.category", method = RequestMethod.GET )
	public String changeCategory(HttpServletRequest request) {
		MDAO.loginCheck(request);
		HDAO.changeCategory(request);
		HDAO.getAllHomework(1, request);
		request.setAttribute("contentPage","homework/homeworkBoard.jsp");
		return "index";
	}
	
	// 과제 게시판 게시글 갯수 변경
	@RequestMapping(value = "/homework.perpage", method = RequestMethod.GET )
	public String changePerPage(HttpServletRequest request) {
		MDAO.loginCheck(request);
		HDAO.changePerPage(request);
		HDAO.getAllHomework(1, request);
		request.setAttribute("contentPage","homework/homeworkBoard.jsp");
		return "index";
	}
	
	// 과제 게시글 작성 페이지 이동
	@RequestMapping(value = "/homework.reg.page", method = RequestMethod.GET)
	public String goRegHomework(HttpServletRequest request) {
		MDAO.loginCheck(request);
		TokenManager.makeToken(request);
		request.setAttribute("contentPage","homework/regHomework.jsp");
		return "index";
	}
	
	// 과제 게시글 등록
	@RequestMapping(value = "/homework.reg", method = RequestMethod.POST)
	public String regHomework(HttpServletRequest request, Homework hw) {
		MDAO.loginCheck(request);
		HDAO.regHomework(request, hw);
		HDAO.countAllHomework();
		HDAO.clearSearch(request);
		HDAO.clearCategory(request);
		HDAO.clearPerPage(request);
		HDAO.getAllHomework(1, request);
		TokenManager.makeToken(request);
		request.setAttribute("contentPage", "homework/homeworkBoard.jsp");
		return "index";
	}
	
	
	// 과제 제시판 상세 내용
	@RequestMapping(value = "/homework.detail", method = RequestMethod.GET)
	public String goHomeworkDetail(HttpServletRequest request, Homework hw) {
		MDAO.loginCheck(request);
		MDAO.getLoginInfo(request);
		HDAO.selectHomeworkDetail(request, hw);
		SDAO.selectStudentHomework(request, hw);
		TokenManager.makeToken(request);
		request.setAttribute("contentPage","homework/homeworkDetail.jsp");
		return "index";
	}
	
	// 과제 글 삭제
	@RequestMapping(value = "/homework.delete", method = RequestMethod.GET)
	public String deleteHomework(HttpServletRequest request, Homework hw) {
		MDAO.loginCheck(request);
		HDAO.deleteHomework(request, hw);
		HDAO.countAllHomework();
		HDAO.clearSearch(request);
		HDAO.clearCategory(request);
		HDAO.clearPerPage(request);
		HDAO.getAllHomework(1, request);
		TokenManager.makeToken(request);
		request.setAttribute("contentPage","homework/homeworkBoard.jsp");
		return "index";
	}
	
	// 과제 글 수정 페이지 이동
	@RequestMapping(value = "/homework.update.page", method = RequestMethod.GET)
	public String updateHomeworkPage(HttpServletRequest request, Homework hw) {
		MDAO.loginCheck(request);
		HDAO.getHomeworkDetail(request);
		TokenManager.makeToken(request);
		request.setAttribute("contentPage","homework/updateHomework.jsp");
		return "index";
	}
	
	// 과제 글 수정
	@RequestMapping(value = "/homework.update", method = RequestMethod.POST)
	public String updateHomework(HttpServletRequest request, Homework hw) {
		MDAO.loginCheck(request);
		HDAO.updateHomework(request, hw);
		HDAO.countAllHomework();
		HDAO.clearSearch(request);
		HDAO.clearCategory(request);
		HDAO.clearPerPage(request);
		HDAO.getAllHomework(1, request);
		TokenManager.makeToken(request);
		request.setAttribute("contentPage","homework/homeworkBoard.jsp");
		return "index";
	}
	
}
