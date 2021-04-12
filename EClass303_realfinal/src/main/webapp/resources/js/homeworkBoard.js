function goHomeworkBoard() {
	location.href = "homework.go";
}
function changeCategory() {
	var category1 = $("#changeCategory option:selected").val();
	location.href = "homework.category?category=" + category1;
}

function changePerPage() {
	var perPage1 = $("#changePerPage option:selected").val();
	location.href = "homework.perpage?perpage=" + perPage1;
}

function goRegHomework() {
	var checkMemberRole = $("#checkMemberRole").val();
	if (checkMemberRole == "t") {
		location.href = "homework.reg.page";
	} else {
		alert("글쓰기는 선생님만 가능합니다");
	}
}

function goUpdatePage() {
	var checkMemberRole = $("#checkMemberRole").val();
	var checkHSeq = $("#checkHSeq").val();
	var token = $("#token").val();
	if (checkMemberRole == "t") {
		location.href = "homework.update.page?update=" + checkHSeq + "&token="
				+ token;
	} else {
		alert("글수정은 선생님만 가능합니다");
	}
}

function deleteHomework() {
	var checkMemberRole = $("#checkMemberRole").val();
	var checkHSeq = $("#checkHSeq").val();
	var token = $("#token").val();
	if (checkMemberRole == "t") {
		var t = prompt("삭제를 원하시면 삭제라고 쓰시오.");
		if (t == "삭제") {
			location.href = "homework.delete?delete=" + checkHSeq + "&token="
					+ token;
		} else {
			alert("글삭제는 선생님만 가능합니다");
		}
	} else {
		alert("글삭제는 선생님만 가능합니다");
	}
}

function searchHomework() {
	var search1 = $("#serachHomework").val();
	location.href = "homework.search?search=" + search1;
}

function goStudentPage() {
	var checkMemberRole = $("#checkMemberRole").val();
	var checkMemberId = $("#checkMemberId").val();
	if (checkMemberRole == "s") {
		location.href = "student.reg.page";
	} else {
		alert("과제 등록은 학생만 가능합니다");
	}

}
