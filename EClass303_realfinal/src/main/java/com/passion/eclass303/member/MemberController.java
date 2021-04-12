package com.passion.eclass303.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.passion.eclass303.tokenmanager.TokenManager;

@Controller
public class MemberController {

	@Autowired
	private MemberDao MDAO;
	
	// 로그인
	@RequestMapping(value = "/member.login", method = RequestMethod.POST)
	public String memberLogin(HttpServletRequest request, Member m) {
		MDAO.login(m, request);
		MDAO.loginCheck(request);
		request.setAttribute("contentPage","home.jsp");
		return "index";
	}
	
	// 회원가입 페이지 이동
	@RequestMapping(value = "/go.reg", method = RequestMethod.GET)
	public String goRegPage(HttpServletRequest request) {
		TokenManager.makeToken(request);
		request.setAttribute("LoginPage", "Member/login.jsp");
		request.setAttribute("contentPage", "Member/RegMember.jsp");
		return "index";
	}

	// 회원가입
	@RequestMapping(value = "/member.reg", method = RequestMethod.POST)
	public String regMember(HttpServletRequest request, Member m) {
		MDAO.regMember(m, request);
		MDAO.loginCheck(request);
		TokenManager.makeToken(request);
		request.setAttribute("contentPage", "home.jsp");
		return "index";
	}

	// 아이디 중복확인
	@RequestMapping(value = "/member.id.check", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody Members checkId(HttpServletRequest request, Member m) {
		return MDAO.checkId(m, request);
	}

	// 인증 메일 보내기
	@RequestMapping(value = "/mailCheck", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody MailNum checkMail(HttpServletRequest request, HttpServletResponse response) {
		response.addHeader("Access-Control-Allow-Origin", "*");
		request.setAttribute("LoginPage", "Member/login.jsp");
		request.setAttribute("contentPage", "Member/RegMember.jsp");
		return MDAO.checkmail(request);
	}
	
	// 회원정보 수정페이지 이동
	@RequestMapping(value = "/go.update", method = RequestMethod.GET)
	public String goUpdatePage(HttpServletRequest request, Member m) {
		MDAO.loginCheck(request);
		MDAO.getMemberInfo(request);
		TokenManager.makeToken(request);
		request.setAttribute("contentPage","Member/UpdateMember.jsp");
		return "index";
	}
	
	// 회원정보 수정
	@RequestMapping(value = "/member.update", method = RequestMethod.POST)
	public String updateMember(HttpServletRequest request, Member m) {
		MDAO.loginCheck(request);
		MDAO.updateMember(m, request);
		TokenManager.makeToken(request);
		request.setAttribute("contentPage","home.jsp");
		return "index";
	}
	
	// 회원탈퇴
	@RequestMapping(value = "/member.delete", method = RequestMethod.GET)
	public String deleteMember(HttpServletRequest request, Member m) {
		MDAO.deleteMember(request);
		MDAO.logOut(request);
		MDAO.loginCheck(request);
		request.setAttribute("contentPage","home.jsp");
		return "index";
	}
	
	// 로그아웃
	@RequestMapping(value = "/member.logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, Member m) {
		MDAO.logOut(request);
		MDAO.loginCheck(request);
		request.setAttribute("contentPage","home.jsp");
		return "index";
	}
	
	// 아이디 비밀번호 찾기 페이지 이동
	@RequestMapping(value = "/go.find", method = RequestMethod.GET)
	public String goFindPage(HttpServletRequest request, Member m) {
		MDAO.loginCheck(request);
		TokenManager.makeToken(request);
		request.setAttribute("contentPage","Member/findIDPW.jsp");
		return "index";
	}
	
	// 아이디 찾기
	@RequestMapping(value = "/find.ID", method = RequestMethod.GET)
	public String findID(HttpServletRequest request, Member m) {
		MDAO.loginCheck(request);
		MDAO.findID(request, m);
		request.setAttribute("contentPage","Member/findIDPW.jsp");
		return "index";
	}
	
	// 비밀번호 찾기
	@RequestMapping(value = "/find.PW", method = RequestMethod.GET)
	public String findPW(HttpServletRequest request, Member m) {
		MDAO.loginCheck(request);
		MDAO.findPW(m, request);
		TokenManager.makeToken(request);
		request.setAttribute("contentPage","home.jsp");
		return "index";
	}
	
}
