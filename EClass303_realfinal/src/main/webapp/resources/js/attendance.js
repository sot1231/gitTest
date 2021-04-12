
function checkAttendance() {
	var token = $(".token").val();
	location.href = "check.attendance?token=" + token;
}

