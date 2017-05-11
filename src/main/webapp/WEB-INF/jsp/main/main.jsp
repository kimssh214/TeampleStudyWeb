<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSS -->

<link href="framework/font-awesome-4.7.0/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" media="screen">
<link href="framework/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="framework/bootstrap-table/dist/bootstrap-table.min.css" rel="stylesheet" media="screen">
<link href="user/css/TeampleStudyWeb.css" rel="stylesheet" media="screen">
<!-- JS -->
<script src="user/js/jquery-3.2.1.min.js" charset="utf-8"></script>
<script src="user/js/common.js" charset="utf-8"></script>
<script src="framework/bootstrap-table/dist/bootstrap-table.min.js"></script>
<script src="framework/bootstrap-table/dist/locale/bootstrap-table-ko-KR.min.js"></script>
<script>
	$(document).ready(function() {
		$("#logout").click(function() {
			var id = '${userInfo.id}';
			logout(id);
		});

		$("#board").click(function() {
			location.href = "board";

		});
	});
</script>
<title>KSH's Profiles</title>
</head>
<body>
	<div id="wrap_panel">
		<div id="top_panel">
			<div id="top_menu"></div>
		</div>
		<div id="middle_panel">
			<div id="left_panel">
				<div class="menu_item" id="board">게시판</div>
				<div class="menu_item" id="logout">로그아웃</div>
			</div>
			<div id="center_panel">
				<div id="main_panel"></div>
			</div>
		</div>

	</div>
</body>
</html>