var User;// 사용자 정보

// 사용자 정보 객체 선언
var UserInfo = function(id, pw) {
	this.id = id;
	this.pw = pw;
}

var LogoutUserInfo = function(id) {
	this.id = id;
}

function logout(id) {

	var url = "logout";
	// var id = $("input[name=id]").val();
	// 사용자 객체 생성
	var UserLogout = new LogoutUserInfo(id);
	if (id != "") {
		$.ajax({
			url : url,
			type : "POST",
			cache : false,
			timeout : 30000,
			contentType : "application/json; charset=UTF-8",
			dataType : "json",
			data : JSON.stringify(UserLogout),
			success : function(data) {
				var dataInfo = eval(data);

				if (dataInfo.errCode == 200) {
					location.href = dataInfo.nextPage;
					alert("로그아웃 되었습니다.");
				}

			},
			error : function(request, status, error) {
				alert("code:" + request.status + "\n" + "message:"
						+ request.responseText + "\n" + "error:" + error);
			}

		});
	}

}

function UserInfoChk(userId, userPw) {
	var id = userId;
	var pw = userPw;

	if (id.length < 3) {
		alert("아이디를 확인 하여 주시기 바랍니다.");
		return false;
	}

	if (pw.length < 3) {
		alert("패스워드를 확인 하여 주시기 바랍니다.");
		return false;
	}

	return true;

}