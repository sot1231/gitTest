package com.passion.eclass303.attendance;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.passion.eclass303.member.MemberDao;
import com.passion.eclass303.tokenmanager.TokenManager;

@Controller
public class AttendanceController {

	@Autowired
	private MemberDao MDao;
	@Autowired
	private AttendanceDAO ADao;
	
	
		@RequestMapping(value = "/go.attendance", method = RequestMethod.GET )
		public String goAttendancePage(HttpServletRequest request, Attendance ad) {
			MDao.loginCheck(request);
			MDao.getLoginInfo(request);
			ADao.makeSessionAttendance(request, ad);
			ADao.makeDateArea(request);
			TokenManager.makeToken(request);
			System.out.println("안녕하세요");
			request.setAttribute("contentPage","attendance/attendance.jsp");
			return "index";
		}
		
		@RequestMapping(value = "/check.attendance", method = RequestMethod.GET )
		public String checkAttendance(HttpServletRequest request, Attendance ad) {
			MDao.loginCheck(request);
			MDao.getLoginInfo(request);
			ADao.checkAttendace(request, ad);
			ADao.makeSessionAttendance(request, ad);
			ADao.makeDateArea(request);
			TokenManager.makeToken(request);
			request.setAttribute("contentPage","attendance/attendance.jsp");
			return "index";
		}
}
