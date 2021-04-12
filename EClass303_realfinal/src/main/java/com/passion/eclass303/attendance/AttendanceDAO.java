package com.passion.eclass303.attendance;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passion.eclass303.member.Member;

@Service
public class AttendanceDAO {

	@Autowired
	private SqlSession ss;

	public void checkAttendace(HttpServletRequest request, Attendance ad) {
		try {
			String paraToken = (String) request.getParameter("token");
			String token = (String) request.getSession().getAttribute("token");
			
			if (paraToken.equals(token)) {
				Member m = (Member) request.getSession().getAttribute("loginMember");
				String a_id = m.getM_id();
				ad.setA_id(a_id);
				ss.getMapper(AttendanceMapper.class).checkAttendance(ad);
				request.setAttribute("result", "출석 체크 성공");
			}else {
				request.setAttribute("result", "새로고침");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "출석 체크 실패");
		}
	}

	public void makeSessionAttendance(HttpServletRequest request, Attendance ad) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		String a_id = m.getM_id();
		ad.setA_id(a_id);
		if (ss.getMapper(AttendanceMapper.class).selectAttendance(ad) != null) {
			request.setAttribute("check", "o");
		} else {
			request.setAttribute("check", "x");
		}
	}

	public void makeDateArea(HttpServletRequest request) {
		try {
			Member m = (Member) request.getSession().getAttribute("loginMember");

			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date mon = null;

			String now = sdf.format(new Date());
			Date sysDate = sdf.parse(now);

			mon = sdf.parse("2021-04-05");
			cal.setTime(mon);

			if (mon.compareTo(sysDate) == 0) {
				cal.add(Calendar.DATE, 7);
				mon = cal.getTime();
				request.setAttribute("mon", mon);
			} else {
				request.setAttribute("mon", mon);
			}

			Attendance ad = new Attendance();
			ad.setA_date(mon);
			ad.setA_id(m.getM_id());
			if (mon.after(sysDate)) {
				request.setAttribute("monA", "null.png");
			} else if (ss.getMapper(AttendanceMapper.class).getAttendanceDataCount(ad) == 0) {
				request.setAttribute("monA", "notA.png");
			} else if (ss.getMapper(AttendanceMapper.class).getAttendanceDataCount(ad) != 0) {
				request.setAttribute("monA", "A.png");
			}

			cal.add(Calendar.DATE, 1);
			Date tue = cal.getTime();
			request.setAttribute("tue", tue);
			ad.setA_date(tue);
			if (tue.after(sysDate)) {
				request.setAttribute("tueA", "null.png");
			} else if (ss.getMapper(AttendanceMapper.class).getAttendanceDataCount(ad) == 0) {
				request.setAttribute("tueA", "notA.png");
			} else if (ss.getMapper(AttendanceMapper.class).getAttendanceDataCount(ad) != 0) {
				request.setAttribute("tueA", "A.png");
			}

			cal.add(Calendar.DATE, 1);
			Date wen = cal.getTime();
			request.setAttribute("wen", wen);
			ad.setA_date(wen);
			if (wen.after(sysDate)) {
				request.setAttribute("wenA", "null.png");
			} else if (ss.getMapper(AttendanceMapper.class).getAttendanceDataCount(ad) == 0) {
				request.setAttribute("wenA", "notA.png");
			} else if (ss.getMapper(AttendanceMapper.class).getAttendanceDataCount(ad) != 0) {
				request.setAttribute("wenA", "A.png");
			}

			cal.add(Calendar.DATE, 1);
			Date thu = cal.getTime();
			request.setAttribute("thu", thu);
			ad.setA_date(thu);
			if (thu.after(sysDate)) {
				request.setAttribute("thuA", "null.png");
			} else if (ss.getMapper(AttendanceMapper.class).getAttendanceDataCount(ad) == 0) {
				request.setAttribute("thuA", "notA.png");
			} else if (ss.getMapper(AttendanceMapper.class).getAttendanceDataCount(ad) != 0) {
				request.setAttribute("thuA", "A.png");
			}

			cal.add(Calendar.DATE, 1);
			Date fri = cal.getTime();
			request.setAttribute("fri", fri);
			ad.setA_date(fri);
			if (fri.after(sysDate)) {
				request.setAttribute("friA", "null.png");
			} else if (ss.getMapper(AttendanceMapper.class).getAttendanceDataCount(ad) == 0) {
				request.setAttribute("friA", "notA.png");
			} else if (ss.getMapper(AttendanceMapper.class).getAttendanceDataCount(ad) != 0) {
				request.setAttribute("friA", "A.png");
			}

			makeTeacherDataArea(request, sysDate, mon, tue, wen, thu, fri);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void makeTeacherDataArea(HttpServletRequest request, Date sysDate, Date mon, Date tue, Date wen, Date thu,
			Date fri) {

		String allMemberCount = ss.getMapper(AttendanceMapper.class).getAllMemberCount() + "";

		int attendanceCount = 0;
		if (mon.after(sysDate)) {
			request.setAttribute("countMon", "");
		} else {
			attendanceCount = ss.getMapper(AttendanceMapper.class).getAttendanceCount(mon);
			request.setAttribute("countMon", attendanceCount + " / " + allMemberCount + "명");
			List<Member> ms = ss.getMapper(AttendanceMapper.class).NotExistMembers(mon);
			request.setAttribute("neMon", ms);
		}

		if (tue.after(sysDate)) {
			request.setAttribute("countTue", "");
		} else {
			attendanceCount = ss.getMapper(AttendanceMapper.class).getAttendanceCount(tue);
			request.setAttribute("countTue", attendanceCount + " / " + allMemberCount + "명");
			List<Member> ms = ss.getMapper(AttendanceMapper.class).NotExistMembers(tue);
			request.setAttribute("neTue", ms);
		}
		if (wen.after(sysDate)) {
			request.setAttribute("countWen", "");
		} else {
			attendanceCount = ss.getMapper(AttendanceMapper.class).getAttendanceCount(wen);
			request.setAttribute("countWen", attendanceCount + " / " + allMemberCount + "명");
			List<Member> ms = ss.getMapper(AttendanceMapper.class).NotExistMembers(wen);
			request.setAttribute("neWen", ms);
		}
		if (thu.after(sysDate)) {
			request.setAttribute("countThu", "");
		} else {
			attendanceCount = ss.getMapper(AttendanceMapper.class).getAttendanceCount(thu);
			request.setAttribute("countThu", attendanceCount + " / " + allMemberCount + "명");
			List<Member> ms = ss.getMapper(AttendanceMapper.class).NotExistMembers(thu);
			request.setAttribute("neThu", ms);
			
		}
		if (fri.after(sysDate)) {
			request.setAttribute("countFri", "");
		} else {
			attendanceCount = ss.getMapper(AttendanceMapper.class).getAttendanceCount(fri);
			request.setAttribute("countFri", attendanceCount + " / " + allMemberCount + "명");
			List<Member> ms = ss.getMapper(AttendanceMapper.class).NotExistMembers(fri);
			request.setAttribute("neFri", ms);
		}

	}


}
