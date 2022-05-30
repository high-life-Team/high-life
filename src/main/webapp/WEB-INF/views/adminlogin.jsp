<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>한데모아 - 관리자로그인</title>
<link rel='stylesheet' type='text/css' href='/css/adminlogin.css'>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<div id="content_container">
				<div id="adminlogin_logo">
					<img src="css/images/logo.png" />
				</div>
			<div id="content_container_space">  
		
		<div id="adminlogin_content">

		<!-- 컨텐츠 시작 -->
	
		<% if (request.getParameter("error")==null) { %>
	
		<% } else { %>
		<h1>
			<%= request.getParameter("error") %>
		</h1>
		<% } %>

		
		<div class="intro_container">
		<!-- 상단 소개글 여백 -->
		<!-- 은택 코드 시작 -->
		<div class="content_title">
			<div class="intro">
			<h2 style="margin-left: '10px';">
			<!-- 상단 소개글 -->
			관리자 로그인
			</h2>
			<br>
			</div>
		</div>
		<form action="admin" method="post">
			<!-- ID, PW 폼 시작 -->
			<!-- ID 박스 -->
			<div id="admin_id">
				<div id="admin_id_box">
					<input name="id" type="text" required="required" id="admin_id_text" placeholder="아이디 입력">
				</div>
			</div>
			<!-- 서치 박스 종료 -->
			<!-- PW 박스 -->
			<div id="admin_password">
				<div id="admin_password_box">
					<input name="pw" type="password" placeholder="비밀번호 입력" required="required" id="admin_password_text" />
				</div>
			</div>
			<!-- PW 박스 종료 -->
			<!--PW-->
			<div class="pw_line"></div>
	
			<div id="login_btn2" class="btn_form">
				<!--로그인-->
				<br> <input id="login_btn" type=submit value="로그인" class="btn btn-dark" id="login_btn"><br>
			</div>
		</form>
		</div>
	<!-- ID, PW 폼 종료 -->
		</div>
</div>
</body>
</html>