package com.passion.eclass303.homework;

import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.passion.eclass303.member.Member;

@Service
public class StudentHomeworkDAO {

	@Autowired
	private SqlSession ss;
	
	// 과제 제출 
	public void studentRegHomework(HttpServletRequest request, StudentHomework shw) {
		try {
			String path = request.getSession().getServletContext().getRealPath("resources/profileImg");
			MultipartRequest mr = new MultipartRequest(request, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
			String paraToken = mr.getParameter("token");
			String token = (String) request.getSession().getAttribute("token");

			if (paraToken.equals(token)) {
				Member m = (Member) request.getSession().getAttribute("loginMember");
				Homework h = (Homework) request.getSession().getAttribute("homework");

				shw.setS_id(m.getM_id());
				shw.setS_no(h.getH_seq());
				shw.setS_name(m.getM_name());

				Date now = new Date();
				shw.setS_date(now);

				shw.setS_title(mr.getParameter("s_title"));
				String reg_file = mr.getFilesystemName("s_file");
				String s_file = URLEncoder.encode(reg_file, "utf-8").replace("+", " ");
				shw.setS_file(s_file);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				Date enddate = sdf.parse(h.getH_enddate());

				if (enddate.before(now)) {
					shw.setS_submit("l");
				} else {
					shw.setS_submit("o");
				}

				ss.getMapper(StudentHomeworkMapper.class).studentRegHomework(shw);
				request.setAttribute("result", "과제 등록 완료");
			} else {
				request.setAttribute("result", "새로고침");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "과제 등록 실패");
		}
	}
	
	// 과제 제출 가져오기
	public void selectStudentHomework(HttpServletRequest request, Homework hw) {
		Homework h = (Homework) request.getSession().getAttribute("homework");
		BigDecimal h_seq = h.getH_seq();
		hw.setH_seq(h_seq);
		List<StudentHomework> studentHomeworks = ss.getMapper(StudentHomeworkMapper.class).selectAllStudentHomework(hw);
		request.setAttribute("studentHomeworks", studentHomeworks);
	}
}
