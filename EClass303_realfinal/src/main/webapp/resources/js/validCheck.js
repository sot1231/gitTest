// 유효성검사 함수
function isEmpty(input) {
	return (!input.value);
}

// 유효성검사 함수
function notEquals(inputPW1, inputPW2) {
	return (inputPW1.value != inputPW2.value);
}

// 유효성검사 함수
function isNotType(input, type) {
	type = "." + type;
	return (input.value.indexOf(type) == -1);
}

// 회원가입 유효성 검사
function Regcheck() {
	var idBox = document.reg.m_id;
	var pwBox = document.reg.m_pw;
	var pwChk = document.reg.m_pw2;
	var nameBox = document.reg.m_name;
	var addrBox1 = document.reg.addr1;
	var addrBox2 = document.reg.addr2;
	var addrBox3 = document.reg.addr3;
	var mailBox = document.reg.reg_mail;
	var photoBox = document.reg.reg_img;

	if (isEmpty(idBox)) {
		alert("ID를 입력하세요.");
		idBox.focus();
		idBox.value = "";
		return false;
	} else if ($("#m_id").css("color") == "rgb(255, 0, 0)") {
		alert("중복된 ID입니다. 다른 ID를 입력하세요.");
		idBox.focus();
		idBox.value = "";
		return false;
	} else if (isEmpty(pwBox)) {
		alert("PW를 입력하세요.");
		pwBox.focus();
		return false;
	} else if (notEquals(pwBox, pwChk)) {
		alert("PW가 서로 일치하지 않습니다.");
		pwBox.value = "";
		pwChk.value = "";
		pwBox.focus();
		return false;
	} else if (isEmpty(nameBox)) {
		alert("이름을 입력하세요.");
		nameBox.focus();
		return false;
	} else if (isEmpty(addrBox1) || isEmpty(addrBox2) || isEmpty(addrBox3)) {
		alert("주소를 입력하세요.");
		addrBox1.focus();
		return false;
	} else if (isEmpty(mailBox)) {
		alert("메일 주소를 입력하세요.");
		mailBox.focus();
		return false;
	} else if (isEmpty(photoBox)) {
		alert("사진 파일을 넣어주세요.");
		photoBox.focus();
		return false;
	} else if (isNotType(photoBox, "png") && isNotType(photoBox, "jpg")
			&& isNotType(photoBox, "PNG") && isNotType(photoBox, "JPG")
			&& isNotType(photoBox, "gif")) {
		alert("지원하지 않는 파일입니다. 다른 이미지파일을 넣어주세요.");
		photoBox.value = "";
		photoBox.focus();
		return false;
	} else if ($("#mail_check_input_box_warn").text() == "인증번호를 다시 확인해주세요.") {
		alert("인증번호를 다시 확인해주세요");
		return false;
	} else if ($("#mail_check_input_box_warn").text() == "") {
		alert("메일인증을 해주세요");
		return false;
	}
	return true;
}

// 회원정보 수정 유효성 검사
function Updatecheck() {
	var idBox = document.updateFrom.m_id;
	var pwBox = document.updateFrom.m_pw;
	var pwChk = document.updateFrom.m_pw2;
	var nameBox = document.updateFrom.m_name;
	var addrBox1 = document.updateFrom.addr1;
	var addrBox2 = document.updateFrom.addr2;
	var addrBox3 = document.updateFrom.addr3;
	var mailBox = document.updateFrom.reg_mail;
	var photoBox = document.updateFrom.reg_img;

	if (isEmpty(idBox)) {
		alert("ID를 입력하세요.");
		idBox.focus();
		idBox.value = "";
		return false;
	} else if ($("#m_id").css("color") == "rgb(255, 0, 0)") {
		alert("중복된 ID입니다. 다른 ID를 입력하세요.");
		idBox.focus();
		idBox.value = "";
		return false;
	} else if (isEmpty(pwBox)) {
		alert("PW를 입력하세요.");
		pwBox.focus();
		return false;
	} else if (notEquals(pwBox, pwChk)) {
		alert("PW가 서로 일치하지 않습니다.");
		pwBox.value = "";
		pwChk.value = "";
		pwBox.focus();
		return false;
	} else if (isEmpty(nameBox)) {
		alert("이름을 입력하세요.");
		nameBox.focus();
		return false;
	} else if (isEmpty(addrBox1) || isEmpty(addrBox2) || isEmpty(addrBox3)) {
		alert("주소를 입력하세요.");
		addrBox1.focus();
		return false;
	} else if (isEmpty(mailBox)) {
		alert("메일 주소를 입력하세요.");
		mailBox.focus();
		return false;
	} else if (isEmpty(photoBox)) {
		alert("사진 파일을 넣어주세요.");
		photoBox.focus();
		return false;
	} else if (isNotType(photoBox, "png") && isNotType(photoBox, "jpg")
			&& isNotType(photoBox, "PNG") && isNotType(photoBox, "JPG")
			&& isNotType(photoBox, "gif")) {
		alert("지원하지 않는 파일입니다. 다른 이미지파일을 넣어주세요.");
		photoBox.value = "";
		photoBox.focus();
		return false;
	}
	return true;
}

function WriteSNSCheck() {
	var content = document.writeSNSForm.s_content;
	if (isEmpty(content)) {
		alert("내용을 입력하세요.");
		content.focus();
		return false;
	}
	return true;
}

function SearchSNSCheck() {
	var snsSearch = document.searchSNSForm.snsSearch;
	if (isEmpty(snsSearch)) {
		alert("검색할 내용을 입력하세요.");
		snsSearch.focus();
		return false;
	}
	return true;
}

function WriteSNSReplyCheck(reply) {
	var sr_reply = reply.sr_reply;
	if (isEmpty(sr_reply)) {
		alert("댓글을 입력하세요.");
		sr_reply.focus();
		return false;
	}
	return true;
}

function regHomeworkCheck(){
	var titleBox = document.regHomeworkForm.h_title;
	var contentBox = document.regHomeworkForm.h_content;
	var fileBox = document.regHomeworkForm.h_file;
	
	if (isEmpty(titleBox)) {
		alert("타이틀을 입력하세요.");
		titleBox.focus();
		return false;
	}else if (isEmpty(contentBox)) {
		alert("내용을 입력하세요.");
		contentBox.focus();
		return false;
	}else if (isEmpty(fileBox)) {
		alert("파일을 등록하세요.");
		fileBox.focus();
		return false;
	}
	return true;
}

