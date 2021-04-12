package com.passion.eclass303.snsboard;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.passion.eclass303.member.MemberDao;
import com.passion.eclass303.tokenmanager.TokenManager;

@Controller
public class SNSBoardController {

	@Autowired
	private MemberDao mDao;

	@Autowired
	private SNSBoardDao sDao;

	private boolean FirstReq;

	public SNSBoardController() {
		FirstReq = true;
	}

	// sns 게시판으로 이동
	@RequestMapping(value = "/go.snsboard", method = RequestMethod.GET)
	public String goSnsboardPage(HttpServletRequest request) {
		if (FirstReq) {
			sDao.countAllSNS();
			FirstReq = false;
		}
		sDao.clearSearchSNS(request);
		TokenManager.makeToken(request);
		mDao.loginCheck(request);
		sDao.getSNS(1, request);
		request.setAttribute("contentPage", "SNSBoard/snsBoard.jsp");
		return "index";
	}

	// 페이지 이동
	@RequestMapping(value = "/change.snspage", method = RequestMethod.GET)
	public String changeSNSPage(HttpServletRequest request) {
		mDao.loginCheck(request);
		int p = Integer.parseInt(request.getParameter("p"));
		sDao.getSNS(p, request);
		request.setAttribute("contentPage", "SNSBoard/snsBoard.jsp");
		return "index";
	}

	// sns 게시글 검색하기
	@RequestMapping(value = "/search.snscontent", method = RequestMethod.POST)
	public String searchSNSContent(HttpServletRequest request, SNSBoard snsb) {
		mDao.loginCheck(request);
		sDao.searchSNS(request);
		sDao.getSNS(1, request);
		request.setAttribute("contentPage", "SNSBoard/snsBoard.jsp");
		return "index";
	}

	// sns 게시글 쓰기
	@RequestMapping(value = "/write.snscontent", method = RequestMethod.POST)
	public String writeSnsContent(HttpServletRequest request, SNSBoard sns) {

		mDao.loginCheck(request);
		sDao.writeSNS(request, sns);
		TokenManager.makeToken(request);
		sDao.getSNS(1, request);
		request.setAttribute("contentPage", "SNSBoard/snsBoard.jsp");
		return "index";
	}

	// sns 게시글 수정하기
	@RequestMapping(value = "/update.snscontent", method = RequestMethod.GET)
	public String updateSnsContent(HttpServletRequest request, SNSBoard snsb) {
		mDao.loginCheck(request);
		sDao.updateSNS(snsb, request);
		TokenManager.makeToken(request);
		sDao.getSNS(1, request);
		request.setAttribute("contentPage", "SNSBoard/snsBoard.jsp");
		return "index";
	}

	// sns 게시글 삭제하기
	@RequestMapping(value = "/delete.snscontent", method = RequestMethod.GET)
	public String deleteSnsContent(HttpServletRequest request, SNSBoard snsb) {

		mDao.loginCheck(request);
		sDao.deleteSNS(snsb, request);
		TokenManager.makeToken(request);
		sDao.getSNS(1, request);

		request.setAttribute("contentPage", "SNSBoard/snsBoard.jsp");
		return "index";
	}

	// sns 댓글 쓰기
	@RequestMapping(value = "/write.snsreply", method = RequestMethod.POST)
	public String writeSnsReply(HttpServletRequest request, SNSReply sr) {

		mDao.loginCheck(request);
		sDao.writeReply(sr, request);
		TokenManager.makeToken(request);
		sDao.getSNS(1, request);
		request.setAttribute("contentPage", "SNSBoard/snsBoard.jsp");
		return "index";
	}

	// sns 댓글 삭제하기
	@RequestMapping(value = "/delete.snsreply", method = RequestMethod.GET)
	public String deleteSnsReply(HttpServletRequest request, SNSReply sr) {

		mDao.loginCheck(request);
		sDao.deleteSNSReply(sr, request);
		sDao.getSNS(1, request);

		request.setAttribute("contentPage", "SNSBoard/snsBoard.jsp");
		return "index";
	}

}
