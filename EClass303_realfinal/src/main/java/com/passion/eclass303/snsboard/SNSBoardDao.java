package com.passion.eclass303.snsboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passion.eclass303.member.Member;

@Service
public class SNSBoardDao {
	private int allSNSCount;

	@Autowired
	private SqlSession ss;

	// 전체 게시글 개수 세기
	public void countAllSNS() {
		allSNSCount = ss.getMapper(SNSBoardMapper.class).getAllSNSCount();
	}

	// 전체 게시글 가지고 오기
	public void getSNS(int page, HttpServletRequest request) {
		request.setAttribute("currentPage", page);

		String snsSearch = (String) request.getSession().getAttribute("snsSearch");
		int snsCount = 0;
		if (snsSearch == null) {
			snsCount = allSNSCount;
			snsSearch = "";
		} else {
			SNSStartEnd se2 = new SNSStartEnd(0, 0, snsSearch);
			snsCount = ss.getMapper(SNSBoardMapper.class).getSearchSNSCount(se2);
		}
		int perCount = 4;
		int allPageCount = snsCount % perCount == 0 ? snsCount / perCount : (snsCount / perCount) + 1;
		request.setAttribute("allPageCount", allPageCount);

		int start = (perCount * (page - 1) + 1);
		int end = (page == allPageCount) ? snsCount : (start + perCount) - 1;

		SNSStartEnd se = new SNSStartEnd(start, end, snsSearch);
		List<SNSBoard> snscontents = ss.getMapper(SNSBoardMapper.class).getSNS(se);

		for (SNSBoard sb : snscontents) {
			sb.setS_replys(ss.getMapper(SNSBoardMapper.class).getReplys(sb));
		}
		request.setAttribute("snsContents", snscontents);
	}

	// sns 검색하기
	public void searchSNS(HttpServletRequest request) {
		String snsSearch = request.getParameter("snsSearch");
		request.getSession().setAttribute("snsSearch", snsSearch);
	}

	// sns 검색 조건 해제하기
	public void clearSearchSNS(HttpServletRequest request) {
		request.getSession().setAttribute("snsSearch", null);
	}

	// sns 게시글 쓰기
	public void writeSNS(HttpServletRequest request, SNSBoard sns) {
		try {
			String paraToken = request.getParameter("token");
			String token = (String) request.getSession().getAttribute("token");

			if (paraToken.equals(token)) {
				Member m = (Member) request.getSession().getAttribute("loginMember");
				sns.setM_id(m.getM_id());
				String content = sns.getS_content();
				content = content.replace("\r\n", "<br>");
				sns.setS_content(content);

				if (ss.getMapper(SNSBoardMapper.class).writeSNSContent(sns) == 1) {
					request.setAttribute("result", "글쓰기 완료");
					allSNSCount++;
				} else {
					request.setAttribute("result", "글쓰기 실패");
				}
			} else {
				request.setAttribute("result", "새로고침");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "글쓰기 실패");
		}
	}

	// sns 게시글 수정하기
	public void updateSNS(SNSBoard snsb, HttpServletRequest request) {

			try {

				if (ss.getMapper(SNSBoardMapper.class).updateSNS(snsb) == 1) {
					request.setAttribute("result", "게시글 수정 성공");
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("result", "게시글 수정 실패");
			}
	}

	// sns 게시글 삭제하기
	public void deleteSNS(SNSBoard snsb, HttpServletRequest request) {
			try {
				if (ss.getMapper(SNSBoardMapper.class).deleteSNS(snsb) == 1) {
					request.setAttribute("result", "게시글 삭제 성공");
					allSNSCount--;
				}
			} catch (Exception e) {
				request.setAttribute("result", "게시글 삭제 실패");
				e.printStackTrace();
			}
	}

	// sns 댓글 쓰기
	public void writeReply(SNSReply sr, HttpServletRequest request) {
		String paraToken = request.getParameter("token");
		String token = (String) request.getSession().getAttribute("token");

		if (paraToken.equals(token)) {

			try {
				if (ss.getMapper(SNSBoardMapper.class).writeReply(sr) == 1) {
					request.setAttribute("result", "댓글쓰기 성공");
				} else {
					request.setAttribute("result", "댓글쓰기 실패");
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("result", "댓글쓰기 실패");
			}
		} else {
			request.setAttribute("result", "새로고침");
		}
	}

	// sns 댓글 삭제하기
	public void deleteSNSReply(SNSReply sr, HttpServletRequest request) {
		try {
			if (ss.getMapper(SNSBoardMapper.class).deleteSNSReply(sr) == 1) {
				request.setAttribute("result", "댓글 삭제 성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("result", "댓글 삭제 실패");
		}
	}

}
