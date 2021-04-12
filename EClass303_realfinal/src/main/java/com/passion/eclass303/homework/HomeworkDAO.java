package com.passion.eclass303.homework;

import java.math.BigDecimal;
import java.net.URLEncoder;
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
public class HomeworkDAO {

	private int allHomeworkCount;

	@Autowired
	private SqlSession ss;

	// 전체 과제 글 갯수 확인
	public void countAllHomework() {
		allHomeworkCount = ss.getMapper(HomeworkMapper.class).getAllHomeworkCount();
	}
	
	// 전체 과제 글 가져오기
	public void getAllHomework(int page, HttpServletRequest request) {
		try {
			request.setAttribute("curPage", page);
			String search = (String) request.getSession().getAttribute("search");
			String category = (String) request.getSession().getAttribute("category");
			String perPageS = (String) request.getSession().getAttribute("perPage");

			int homeworkCount = 0;
			int perPage = 0;

			if (perPageS == null) {
				perPage = 5;
			} else {
				perPage = Integer.parseInt((String) request.getSession().getAttribute("perPage"));
			}

			if (search == null && category == null) {
				homeworkCount = allHomeworkCount;
				search = "";
				category = "";

				HomeworkSelector hwSelector = new HomeworkSelector(search, category, 0, 0);
				homeworkCount = ss.getMapper(HomeworkMapper.class).getHomeworkCount2(hwSelector);

				int allHomeworkPageCount = (int) Math.ceil((double) homeworkCount / perPage);
				request.setAttribute("allHomeworkPageCount", allHomeworkPageCount);

				int start = (page - 1) * perPage + 1;
				int end = (page == allHomeworkPageCount) ? homeworkCount : start + perPage - 1;

				hwSelector = new HomeworkSelector(search, category, start, end);
				List<Homework> homeworks = ss.getMapper(HomeworkMapper.class).getHomework2(hwSelector);
				request.setAttribute("homeworks", homeworks);

			} else if (search == null) {
				search = "";
				HomeworkSelector hwSelector = new HomeworkSelector(search, category, 0, 0);
				homeworkCount = ss.getMapper(HomeworkMapper.class).getHomeworkCount(hwSelector);

				int allHomeworkPageCount = (int) Math.ceil((double) homeworkCount / perPage);
				request.setAttribute("allHomeworkPageCount", allHomeworkPageCount);

				int start = (page - 1) * perPage + 1;
				int end = (page == allHomeworkPageCount) ? homeworkCount : start + perPage - 1;

				hwSelector = new HomeworkSelector(search, category, start, end);
				List<Homework> homeworks = ss.getMapper(HomeworkMapper.class).getHomework(hwSelector);
				request.setAttribute("homeworks", homeworks);

			} else if (category == null) {
				category = "";
				HomeworkSelector hwSelector = new HomeworkSelector(search, category, 0, 0);
				homeworkCount = ss.getMapper(HomeworkMapper.class).getHomeworkCount2(hwSelector);

				int allHomeworkPageCount = (int) Math.ceil((double) homeworkCount / perPage);
				request.setAttribute("allHomeworkPageCount", allHomeworkPageCount);

				int start = (page - 1) * perPage + 1;
				int end = (page == allHomeworkPageCount) ? homeworkCount : start + perPage - 1;

				hwSelector = new HomeworkSelector(search, category, start, end);
				List<Homework> homeworks = ss.getMapper(HomeworkMapper.class).getHomework2(hwSelector);
				request.setAttribute("homeworks", homeworks);

			} else {
				HomeworkSelector hwSelector = new HomeworkSelector(search, category, 0, 0);
				homeworkCount = ss.getMapper(HomeworkMapper.class).getHomeworkCount(hwSelector);

				int allHomeworkPageCount = (int) Math.ceil((double) homeworkCount / perPage);
				request.setAttribute("allHomeworkPageCount", allHomeworkPageCount);

				int start = (page - 1) * perPage + 1;
				int end = (page == allHomeworkPageCount) ? homeworkCount : start + perPage - 1;

				hwSelector = new HomeworkSelector(search, category, start, end);
				List<Homework> homeworks = ss.getMapper(HomeworkMapper.class).getHomework(hwSelector);
				request.setAttribute("homeworks", homeworks);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clearSearch(HttpServletRequest request) {
		request.getSession().setAttribute("search", null);
	}

	public void searchHomework(HttpServletRequest request) {
		String search = request.getParameter("search");
		request.getSession().setAttribute("search", search);
	}

	public void clearCategory(HttpServletRequest request) {
		request.getSession().setAttribute("category", null);
	}

	public void changeCategory(HttpServletRequest request) {
		String category = request.getParameter("category");
		request.getSession().setAttribute("category", category);
	}

	public void clearPerPage(HttpServletRequest request) {
		request.getSession().setAttribute("perPage", null);
	}

	public void changePerPage(HttpServletRequest request) {
		String perPage = request.getParameter("perpage");
		request.getSession().setAttribute("perPage", perPage);
	}

	public void regHomework(HttpServletRequest request, Homework hw) {
		try {
			String path = request.getSession().getServletContext().getRealPath("resources/profileImg");
			MultipartRequest mr = new MultipartRequest(request, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
			String paraToken = mr.getParameter("token");
			String token = (String) request.getSession().getAttribute("token");

			if (paraToken.equals(token)) {
				Member m = (Member) request.getSession().getAttribute("loginMember");
				hw.setH_writer(m.getM_name());
				
				Date now = new Date();
				hw.setH_date(now);
				
				String startH_year = mr.getParameter("startH_year");
				int startH_month = Integer.parseInt(mr.getParameter("startH_month"));
				int startH_day = Integer.parseInt(mr.getParameter("startH_day"));
				String h_startdate = String.format("%s%02d%02d", startH_year, startH_month, startH_day);
				hw.setH_startdate(h_startdate);

				String endH_year = mr.getParameter("endH_year");
				int endH_month = Integer.parseInt(mr.getParameter("endH_month"));
				int endH_day = Integer.parseInt(mr.getParameter("endH_day"));
				String h_enddate = String.format("%s%02d%02d", endH_year, endH_month, endH_day);
				hw.setH_enddate(h_enddate);

				hw.setH_title(mr.getParameter("h_title"));
				hw.setH_content(mr.getParameter("h_content"));
				String reg_file = mr.getFilesystemName("h_file");
				String h_file = URLEncoder.encode(reg_file, "utf-8").replace("+", " ");
				hw.setH_file(h_file);

				hw.setH_role(mr.getParameter("h_role"));

				ss.getMapper(HomeworkMapper.class).regHomework(hw);
				request.setAttribute("result", "글 작성 완료");

			} else {
				request.setAttribute("result", "새로고침");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "글 작성 실패");
		}
	}

	public void selectHomeworkDetail(HttpServletRequest request, Homework hw) {
		int h_no = Integer.parseInt(request.getParameter("h_seq"));
		BigDecimal h_seq = new BigDecimal(h_no);
		hw.setH_seq(h_seq);
		Homework hm = ss.getMapper(HomeworkMapper.class).selectHomeworkDetail(hw);
		request.setAttribute("hm", hm);
		request.getSession().setAttribute("homework", hm);
	}
	
	public void clearHomeworkDetail(HttpServletRequest request) {
		request.getSession().setAttribute("homework", null);
	}
	
	public void getHomeworkDetail(HttpServletRequest request) {
		Homework hm = (Homework) request.getSession().getAttribute("homework");
		
		String startdate = hm.getH_startdate();
		String yyyyS = startdate.substring(0, 4);
		String mmS = startdate.substring(4, 6);
		String ddS = startdate.substring(6, 8);
		request.setAttribute("yyyyS", yyyyS);
		request.setAttribute("mmS", mmS);
		request.setAttribute("ddS", ddS);
		
		String enddate = hm.getH_enddate();
		String yyyyE = enddate.substring(0, 4);
		String mmE = enddate.substring(4, 6);
		String ddE = enddate.substring(6, 8);
		request.setAttribute("yyyyE", yyyyE);
		request.setAttribute("mmE", mmE);
		request.setAttribute("ddE", ddE);
	}

	public void deleteHomework(HttpServletRequest request, Homework hw) {

		String paraToken = request.getParameter("token");
		String token = (String) request.getSession().getAttribute("token");
		System.out.println(paraToken);
		System.out.println(token);
		if (paraToken.equals(token)) {
			int h_no = Integer.parseInt(request.getParameter("delete"));
			BigDecimal h_seq = new BigDecimal(h_no);
			hw.setH_seq(h_seq);
			ss.getMapper(HomeworkMapper.class).deleteHomework(hw);
			request.setAttribute("result", "글 삭제 완료");
		} else {
			request.setAttribute("result", "새로고침");
		}

	}
	
	public void updateHomework(HttpServletRequest request, Homework hw) {
		try {
			String path = request.getSession().getServletContext().getRealPath("resources/profileImg");
			MultipartRequest mr = new MultipartRequest(request, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
			String paraToken = mr.getParameter("token");
			String token = (String) request.getSession().getAttribute("token");

			if (paraToken.equals(token)) {
				Member m = (Member) request.getSession().getAttribute("loginMember");
				hw.setH_writer(m.getM_name());
				
				Date now = new Date();
				hw.setH_date(now);
				
				String seq = mr.getParameter("h_seq");
				BigDecimal h_seq = new BigDecimal(seq);
				hw.setH_seq(h_seq);

				String startH_year = mr.getParameter("startH_year");
				int startH_month = Integer.parseInt(mr.getParameter("startH_month"));
				int startH_day = Integer.parseInt(mr.getParameter("startH_day"));
				String h_startdate = String.format("%s%02d%02d", startH_year, startH_month, startH_day);
				hw.setH_startdate(h_startdate);

				String endH_year = mr.getParameter("endH_year");
				int endH_month = Integer.parseInt(mr.getParameter("endH_month"));
				int endH_day = Integer.parseInt(mr.getParameter("endH_day"));
				String h_enddate = String.format("%s%02d%02d", endH_year, endH_month, endH_day);
				hw.setH_enddate(h_enddate);

				hw.setH_title(mr.getParameter("h_title"));
				hw.setH_content(mr.getParameter("h_content"));
				String reg_file = mr.getFilesystemName("h_file");
				String h_file = URLEncoder.encode(reg_file, "utf-8").replace("+", " ");
				hw.setH_file(h_file);

				hw.setH_role(mr.getParameter("h_role"));

				ss.getMapper(HomeworkMapper.class).updateHomework(hw);
				request.setAttribute("result", "글 수정 완료");

			} else {
				request.setAttribute("result", "새로고침");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "글 수정 실패");
		}
	}
	
}
