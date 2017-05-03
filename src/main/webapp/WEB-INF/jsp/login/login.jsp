<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->

<link href="/framework/font-awesome-4.7.0/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" media="screen">
<link href="/framework/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">

<link href="/user/css/TeampleStudyWeb.css" rel="stylesheet" media="screen">

<!-- JS -->
<script src="/user/js/jquery-3.2.1.min.js"></script>
<script src="/user/js/common.js"></script>
<script>
	

	$(document).ready(function() {
		var User;//사용자 정보
		
		//사용자 정보 객체 선언
		var UserInfo = function (id, pw){
			this.id = id;
			this.pw = pw;
		}
		
		$("#btn_login").click(function() {
			var url = "/login/check";
			var id = $("input[name=id]").val();
			var pw = $("input[name=pw]").val();
			
			//사용자 객체 생성
			User = new UserInfo(id, pw);
			if(UserInfoChk(User.id, User.pw)){
				$.ajax({
					url : url,
					type : "POST",
					cache : false,
					timeout : 30000,
					contentType : "application/json; charset=UTF-8",
					dataType : "json",
					data : JSON.stringify(User),
					success : function(data) {
						var dataInfo = eval(data);
						
						if(dataInfo.errCode == 200){
							//세션처리 전 임시 코드
							location.href= dataInfo.nextPage;
						}else{
							alert("아이디 또는 패스워드를 확인하여 주시기 바랍니다.");
							User = null;
						}
						
					},
					error:function(request,status,error){
			       	 alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
			       }

				});
			}
		});
	});
	function UserInfoChk(userId, userPw){
		var id = userId;
		var pw = userPw;
		
		if(id.length<3){
			alert("아이디를 확인 하여 주시기 바랍니다.");
			return false;
		}
		
		if(pw.length<3){
			alert("패스워드를 확인 하여 주시기 바랍니다.");
			return false;
		}
		
		return true;
		
	}

</script>
<title>Sign In</title>
</head>
<body>
	<div id="main_panel">
		<div id="center_panel">
			<div id="login_panel" class="panel panel-default">
				<div class="panel-heading ">
					<font class="panel-heading-text">Sign In</font>
				</div>
				<div class="panel-body">
					<form id="login_form" class="form-horizontal" action="/login/check" method="post" accept-charset="utf-8">
						<div id="login_form_panel">
							<div>KSH's Profiles</div>
							<div>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa-fw"></i></span> <input class="form-control" name="id" type="text" placeholder="ID">
								</div>
							</div>
							<div>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-fw"></i></span> <input class="form-control" name="pw" type="password" placeholder="Password">
								</div>
							</div>
							<div>
								<button id="btn_login" type="button" class="btn btn-primary btn-lg">Login</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>