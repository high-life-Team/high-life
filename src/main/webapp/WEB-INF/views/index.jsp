
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<c:set var="result" value="${param.result}" />
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>한데모아 - 로그인</title>

<c:choose>
	<c:when test="${result=='loginFailed'}">
		<script>
                    window.onload=function(){
                    	alert("아이디 또는 비밀번호를 다시 확인해주세요!");
                    }
                    </script>
	</c:when>
</c:choose>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

<link rel='stylesheet' type='text/css' href='/css/login.css'>
<link rel='stylesheet' type='text/css' href='/css/index.css'>
<link rel='stylesheet' type='text/css' href='/css/login_idfind.css'>
<link rel='stylesheet' type='text/css' href='/css/login_pwfind.css'>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">


<script type="text/javascript" src='/js/login_idfind.js' ></script>
<script type="text/javascript" src='/js/login_pwfind.js' ></script>

</head>
<body>


	<!-- 네비게이션 start -->
	<div id="nav_area">
		<div id="nav_space">
			<div id="logo">
				<a href="/handemoa"> 
				<img src="css/images/logo.png" />
				</a>
			</div>
			<div id="nav_profile">
				<div id="nav_profile_img">
					<img src="css/images/login_before.png" />
				</div>
				<button id="nav_login_btn"
					onclick="location.href='/login'">로그인</button>
			</div>
			<div id="nav_list">
				<div class="nav_list_area">
					<a href="/bookmark"> <!-- 해당 링크 이동 -->
						<h4>북마크</h4></a>
				</div>
				<div class="nav_list_area">
					<a href="/ranking?catedetailcode=8&page=1"> <!-- 해당 링크 이동 -->
						<h4>강의랭킹</h4></a>
				</div>
				<div class="nav_list_area">
					<a href="/community?catedetailcode=8&page=1"> <!-- 해당 링크 이동 -->
						<h4>커뮤니티</h4></a>
				</div>
				<div class="nav_list_area">
					<a href="/notice"> <!-- 해당 링크 이동 -->
						<h4>공지사항</h4></a>
				</div>
				
				
				<c:choose>
						<c:when test="${isLogOn == true && member!= null}">

							<div class="nav_list_area">
								<div class="handemore_button">
									<a href="http://localhost:3000/note" id="handemore_font">
										HANDEMORE > </a>
								</div>
							</div>

						</c:when>
						<c:otherwise>
							<div class="nav_list_area">
								<div class="handemore_button">
									<a href="/login" id="handemore_font"> HANDEMORE > </a>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
			</div>
		</div>
	</div>
	<!-- 네비게이션 end -->
	
	
	
	<div id="content_container">
		<div id="content_container_space">

			<div id="inner_space"></div>
			<div id="content">
				<!-- 컨텐츠 시작 -->

				<div class="intro_container">
					<!-- 상단 소개글 여백 -->
					<!-- 은택 코드 시작 -->
					<div class="container">
						<div class="intro">
							<br> <br> <br> <br> <br>
							<h2 style="margin-left: '10px';">
								<!-- 상단 소개글 -->
								로그인
							</h2>
							<br>
						</div>
					</div>
					<form action="/login" class="login_form" method="post">
						<input type="hidden" value="login">
						<!-- ID, PW 폼 시작 -->
						<!-- ID 박스 -->
						<div id="id">
							<div id="id_box">
								<input id="id_text" type="text" maxlength="20" name="id"
									placeholder="아이디 입력" title="5자 이상의 ID를 입력해주세요. (소문자, 숫자)"
									required="required" pattern="[a-z0-9]{5,20}" />
							</div>
						</div>
						<!-- 서치 박스 종료 -->

						<!-- PW 박스 -->
						<div id="password">
							<div id="password_box">
								<input id="password_text" type="password" name="password"
									placeholder="비밀번호 입력" required="required" />
							</div>
						</div>

						<!-- PW 박스 종료 -->
						<!--PW-->
						<div class="pw_line"></div>

						<div id="login_btn2" class="btn_form">
							<!--로그인-->
							<br> <input id="login_btn" type=submit value="로그인"
								class="btn btn-dark" id="login_btn" name="login_btn">
						</div>
					</form>
					
					<div id="loginfind">
	<div class="signup">
		<!--회원가입-->
		<br>
		<a href="/member" style="color: black" id="member">회원가입 | </a>
		<a class="idfind_btn" style="color: black; cursor: pointer;" id="member">아이디 찾기 | </a>
		<a class="pwfind_btn" style="color: black; cursor: pointer;" id="member">비밀번호 찾기</a>
			<!-- 회원가입 페이지 이동 -->
		
		
	</div>
</div>
					
					<%@ include file="/WEB-INF/views/login_idfind.jsp" %>
					<%@ include file="/WEB-INF/views/login_pwfind.jsp" %>
					<br>

				</div>
				<!-- ID, PW 폼 종료 -->

			</div>
		</div>
		<br>
	</div>


</body>
</html>