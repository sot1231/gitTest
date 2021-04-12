// 회원 탈퇴
function deleteMember() {
	var t = prompt("탈퇴를 원하시면 탈퇴라고 쓰시오.");
	if (t == "탈퇴") {
		alert("탈퇴되었습니다.");
		location.href = "member.delete";
	}
}

// sns 페이지 이동
function snsPageChange(page) {
	location.href = "change.snspage?p=" + page;
}

// sns 게시글 삭제
function deleteSNS(s_num) {
	var d = confirm("해당 글을 삭제하시겠습니까? ");
	if (d) {
		alert("삭제되었습니다.");
		location.href = "delete.snscontent?s_num=" + s_num;
	}
}

// sns 게시글 수정
function updateSNS(s_num, s_content) {
	s_content = prompt("내용을 입력하세요. ", s_content);
	if (s_content.length < 300) {
		location.href = "update.snscontent?s_num=" + s_num + "&s_content="+ s_content;
	}
}

// sns 댓글 삭제
function deleteSNSReply(sr_num) {
	var d = confirm("해당 댓글을 삭제하시겠습니까? ");
	if (d) {
		alert("삭제되었습니다.");
		location.href = "delete.snsreply?sr_num=" + sr_num;
	}
}