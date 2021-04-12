package com.passion.eclass303.member;

import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDao {

	@Autowired
	private SqlSession ss;

	@Autowired
	private JavaMailSender mailSender;
	
	// 로그인 체크
	public boolean loginCheck(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		if (m != null) {
			request.setAttribute("LoginPage", "Member/loginSuccess.jsp");
			return true;
		} else {
			request.setAttribute("LoginPage", "Member/login.jsp");
			return false;
		}
	}
	
	// 로그인 정보 attribute로 가져오기
	public void getLoginInfo(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		request.setAttribute("l", m);
	}
	
	// 로그인
	public void login(Member inputM, HttpServletRequest request) {
		try {
			List<Member> dbms = ss.getMapper(MemberMapper.class).getMemeberById(inputM);
			if (dbms.size() != 0) {
				Member dbM = dbms.get(0);
				if (dbM.getM_pw().equals(inputM.getM_pw())) {
					request.getSession().setAttribute("loginMember", dbM);
					request.getSession().setMaxInactiveInterval(10 * 60);
				} else {
					request.setAttribute("result", "비밀번호가 일치하지 않습니다.");
				}
			} else {
				request.setAttribute("result", "가입되지 않은 ID 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "DB 점검중입니다.");
		}
	}
	
	// 회원가입
	public void regMember(Member m, HttpServletRequest request) {
		try {
			String path = request.getSession().getServletContext().getRealPath("resources/profileImg");
			MultipartRequest mr = new MultipartRequest(request, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
			String paraToken = mr.getParameter("token");
			String token = (String) request.getSession().getAttribute("token");

			if (paraToken.equals(token)) {
				m.setM_id(mr.getParameter("m_id"));
				m.setM_pw(mr.getParameter("m_pw"));
				m.setM_name(mr.getParameter("m_name"));

				String year = mr.getParameter("reg_year");
				int month = Integer.parseInt(mr.getParameter("reg_month"));
				int day = Integer.parseInt(mr.getParameter("reg_day"));
				String m_birth = String.format("%s%02d%02d", year, month, day);
				m.setM_birth(m_birth);

				String addr1 = mr.getParameter("addr1");
				String addr2 = mr.getParameter("addr2");
				String addr3 = mr.getParameter("addr3");
				String m_addr = addr2 + "@" + addr3 + "@" + addr1;
				m.setM_addr(m_addr);

				String mail = mr.getParameter("reg_mail");
				String domain = mr.getParameter("reg_domain");
				String m_mail = mail + domain;
				m.setM_mail(m_mail);

				String reg_img = mr.getFilesystemName("reg_img");
				String m_img = URLEncoder.encode(reg_img, "utf-8").replace("+", " ");
				m.setM_img(m_img);

				m.setM_role("s");
				ss.getMapper(MemberMapper.class).regMember(m);
				request.setAttribute("result", "회원가입 완료");
			} else {
				request.setAttribute("result", "새로고침");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "회원가입 실패");
		}
	}
	
	// ID 중복체크
	public Members checkId(Member m, HttpServletRequest request) {
		return new Members(ss.getMapper(MemberMapper.class).checkId(m));
	}
	
	// 메일 인증
	public MailNum checkmail(HttpServletRequest request) {
		String email = request.getParameter("email");
		String randomUUID = UUID.randomUUID().toString().replace("-", "").substring(0, 5);

		String setFrom = "sot1231@naver.com";
		String toMail = email;
		String title = "회원가입 인증 이메일 입니다.";
		String content = "홈페이지를 방문해주셔서 감사합니다." + "<br><br>" + "인증 번호는 " + randomUUID + "입니다." + "<br>"
				+ "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
			helper.setFrom(setFrom);
			helper.setTo(toMail);
			helper.setSubject(title);
			helper.setText(content, true);
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		MailNum mn = new MailNum(randomUUID);
		return mn;
	}
	
	// 회원정보 가져오기
	public void getMemberInfo(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");

		String birth = m.getM_birth();
		String yyyy = birth.substring(0, 4);
		String mm = birth.substring(4, 6);
		String dd = birth.substring(6, 8);

		String addr1 = m.getM_addr().split("@")[0];
		String addr3 = m.getM_addr().split("@")[1];
		String addr2 = m.getM_addr().split("@")[2];

		request.setAttribute("yyyy", yyyy);
		request.setAttribute("mm", mm);
		request.setAttribute("dd", dd);
		request.setAttribute("addr1", addr1);
		request.setAttribute("addr2", addr2);
		request.setAttribute("addr3", addr3);
	}
	
	// 회원정보 수정
	public void updateMember(Member m, HttpServletRequest request) {
		try {
			String path = request.getSession().getServletContext().getRealPath("resources/profileImg");
			MultipartRequest mr = new MultipartRequest(request, path, 10485760, "utf-8", new DefaultFileRenamePolicy());

			String paraToken = mr.getParameter("token");
			String token = (String) request.getSession().getAttribute("token");

			if (paraToken.equals(token)) {
				m.setM_id(mr.getParameter("m_id"));
				m.setM_pw(mr.getParameter("m_pw"));
				m.setM_name(mr.getParameter("m_name"));

				String year = mr.getParameter("reg_year");
				int month = Integer.parseInt(mr.getParameter("reg_month"));
				int day = Integer.parseInt(mr.getParameter("reg_day"));
				String m_birth = String.format("%s%02d%02d", year, month, day);
				m.setM_birth(m_birth);

				String addr1 = mr.getParameter("addr1");
				String addr2 = mr.getParameter("addr2");
				String addr3 = mr.getParameter("addr3");
				String m_addr = addr2 + "@" + addr3 + "@" + addr1;
				m.setM_addr(m_addr);

				String mail = mr.getParameter("reg_mail");
				String domain = mr.getParameter("reg_domain");
				String m_mail = mail + domain;
				m.setM_mail(m_mail);

				String reg_img = mr.getFilesystemName("reg_img");
				String m_img = URLEncoder.encode(reg_img, "utf-8").replace("+", " ");
				m.setM_img(m_img);

				m.setM_role("s");

				if (ss.getMapper(MemberMapper.class).updateMember(m) == 1) {
					request.getSession().setAttribute("loginMember", m);
					request.setAttribute("result", "회원 정보 수정 성공");
				}
			} else {
				request.setAttribute("result", "새로고침");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "회원 정보 수정 실패");
		}
	}

	// 회원 탈퇴
	public void deleteMember(HttpServletRequest request) {
		try {
			if (ss.getMapper(MemberMapper.class)
					.deleteMember((Member) request.getSession().getAttribute("loginMember")) == 1) {
				request.setAttribute("result", "탈퇴 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "탈퇴 실패");
		}
	}
	
	// 로그아웃
	public void logOut(HttpServletRequest request) {
		request.getSession().setAttribute("loginMember", null);
	}
	
	// 아이디 찾기
	public void findID(HttpServletRequest request, Member m) {
		List<Member> find = ss.getMapper(MemberMapper.class).findMemberID(m);
		request.setAttribute("foundID", find.get(0));
	}
	
	// 비밀번호 찾기
	public void findPW(Member m, HttpServletRequest request) {
		String paraToken = request.getParameter("token");
		String token = (String) request.getSession().getAttribute("token");

		if (paraToken.equals(token)) {
			String m_id = request.getParameter("m_id");
			String m_mail = request.getParameter("m_mail");
			String m_pw = UUID.randomUUID().toString().replace("-", "").substring(0, 5);

			String setFrom = "sot1231@naver.com";
			String toMail = m_mail;
			String title = "임시 비밀 번호 전달드립니다.";
			String content = "홈페이지를 방문해주셔서 감사합니다." + "<br>   <br>" + "임시 비밀번호는 " + m_pw + "입니다." + "<br>"
					+ "해당 비밀번호로 로그인해주세요.";

			try {
				MimeMessage message = mailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
				helper.setFrom(setFrom);
				helper.setTo(toMail);
				helper.setSubject(title);
				helper.setText(content, true);
				mailSender.send(message);
			} catch (Exception e) {
				e.printStackTrace();
			}

			m.setM_id(m_id);
			m.setM_mail(m_mail);
			m.setM_pw(m_pw);

			ss.getMapper(MemberMapper.class).findMemberPW(m);
			request.setAttribute("result", "임시 비밀번호 지급완료");
		} else {
			request.setAttribute("result", "새로고침");
		}
	}















}
