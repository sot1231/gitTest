function joinAddr() {
	$("#addr1,#addr2").click(function() {
		new daum.Postcode({
			oncomplete : function(data) {
				$("#addr1").val(data.zonecode);
				$("#addr2").val(data.roadAddress);
			}
		}).open();
	});
}

function checkId() {
	$("#m_id").keyup(function() {
		var m_id = $(this).val();
		$.getJSON("member.id.check?m_id=" + m_id, function(memberJSON) {
			if (memberJSON.member[0] == null) {
				$("#m_id").css("color", "black");
			} else {
				$("#m_id").css("color", "red");
			}
		});
	});
}

function checkMail() {
	$(".mail_check_button").click(function() {
		var email1 = $(".mail_input").val();
		var email2 = $("#mail_select option:selected").val();
		var email = email1 + email2;

		var checkBox = $(".mail_check_input");
		var code = "";

		$.ajax({
			type : "GET",
			url : "mailCheck?email=" + email,
			success : function(data) {
				checkBox.attr("disabled", false);
				code = data.mailnn;
				alert(code);
				reCheckMail(code);
			}
		});
	});
}

// 인증 번호 확인 메소드
function reCheckMail(code) {
	$(".mail_check_input").blur(function() {
		var inputCode = $(".mail_check_input").val();
		var checkResult = $("#mail_check_input_box_warn");

		if (inputCode == code) {
			checkResult.html("인증번호가 일치합니다");
			checkResult.attr("class", "correct");
		} else {
			checkResult.html("인증번호를 다시 확인해주세요.");
			checkResult.attr("class", "incorrect");
		}
	});
}

// 칠판 
function blackBoard() {
	var socket = io.connect("http://192.168.56.1:9999");
	var paper = document.getElementById("paper");
	var pen = paper.getContext("2d");
	var clicked = false;
	var c = "black";
	pen.lineWidth = 2;

	var startX = 0;
	var startY = 0;
	var endX = 0;
	var endY = 0;
	var paperX = $("#paper").offset().left + 8;
	var paperY = $("#paper").offset().top + 8;

	$(window).resize(function() {
		paperX = $("#paper").offset().left + 8;
		paperY = $("#paper").offset().top + 8;
	});

	$("#paper").mousedown(function(e) {
		clicked = true;
		startX = e.pageX - paperX;
		startY = e.pageY - paperY;
	});

	$("#paper").mousemove(function(e) {
		endX = e.pageX - paperX;
		endY = e.pageY - paperY;

		if (clicked) {
			socket.emit("clientMsg", {
				c : c,
				sx : startX,
				sy : startY,
				ex : endX,
				ey : endY
			});
		}
		startX = endX;
		startY = endY;
	});

	$("#paper").mouseup(function(e) {
		clicked = false;
	});

	$("#bruchColorInput").keyup(function() {
		c = $(this).val();
		$(this).css("border", c + " solid 2px");
		$(this).css("color", c);
	});

	socket.on("serverMsg", function(data) {
		pen.strokeStyle = data.c;
		pen.beginPath();
		pen.moveTo(data.sx, data.sy);
		pen.lineTo(data.ex, data.ey);
		pen.stroke();
	});
}

$(function() {
	checkId();
	checkMail();
	joinAddr();
	blackBoard();
});