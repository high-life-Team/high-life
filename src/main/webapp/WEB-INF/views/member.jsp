<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>한데모아 - 회원가입</title>
<link rel='stylesheet' type='text/css' href='/css/member.css'>
<link rel='stylesheet' type='text/css' href='/css/index.css'>



<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">
	
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script src='/js/index.js'></script>
<script src='/js/member.js'></script>
</head>
<body>
		<!-- 네비게이션 start -->
		<div id="nav_area">
			<div id="nav_space">
				<div id="logo">
					<a href="/handemoa"> <img src="css/images/logo.png" />
					</a>
				</div>
				<div id="nav_profile">
					<div id="nav_profile_img">
						<img src="css/images/login_before.png" />
					</div>
					<button id="nav_login_btn" onclick="location.href='/login'">로그인</button>
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
				</div>
			</div>
		</div>
		<!-- 네비게이션 end -->
		<div id="content_container">
			<div id="content_container_space">
					<br>
				<div class="inner_space"></div>
				<div id="content">
					<!-- 컨텐츠 시작 -->
					<div id=member_cssbox>
						<div class="item">
							<div class="top-intro">
								<div
									style="font-size: 50px; font-weight: bold; margin-top: 70px;">회원가입</div>
							</div>
						</div>
						<!-- 1번째 item -->

						<!--  onsubmit="checkAll()" -->
						<form action="memberinsert" class="signup_form" method="post">
							<!-- 폼 시작 -->


							<!-- ID -->
							<div class="item">
								<!-- 2번째 item -->

								<br>
								<div id="id">
									<b style="margin-right: 20px;">회원 아이디</b>
									<div id="id_box">
										<input id=id_id type=text class=class_id maxlength="20"
											size="40" name="id" required="required" placeholder="아이디 입력"
											pattern="[a-z0-9]{5,20}" title="5~20자의 영문 소문자, 숫자만 가능합니다."
											check_result="fail" required>
									</div>
									<!-- <button id="repeat_check" type="button" class=repeat_check_class>중복확인</button> -->

								</div>

								<font id="idcheck_font" size="2"></font> <br> <br>
								<!-- nickname -->
								<div id="nickname">
									<b style="margin-right: 55px;">닉네임</b>
									<div id="nickname_box">
										<input id=nickname_nickname class=class_nickname type=text
											minlength="2" maxlength="12" size="40" name="nickname"
											required="required" placeholder="닉네임 입력"
											pattern="[a-zA-Z0-9가-힣]{2,12}"
											title="2~12자의 한글,영문,숫자만 가능합니다.">
									</div>
									<!-- <button id="repeat_check_nickname" type="button">중복확인</button> -->
								</div>
								<font id="nicknamecheck_font" size="2"></font> <br> <br>
								<br>

								<div id="pw">
									<b style="margin-right: 40px;">패스워드</b>
									<!-- 픽셀 줄이면 간격 줄어들음 -->
									<div id="pw_box">
										<!--PW-->
										<input id="pw_text" type="password" minlength="6"
											maxlength="12" name="password" placeholder="비밀번호 입력"
											pattern="(?=.*\d)(?=.*[a-z]).{6,12}" required="required"
											title="6~12자 영문 소문자와 숫자 조합을 사용하세요." value="" size="40">
									</div>
								</div>
								<div style="font-size: 11px; color: gray">6~12자리 영어, 숫자를
									조합해주세요.</div>

								<br>
								<!--PW_CHECK 비밀번호 재확인 이후 js 사용 -->
								<div id="pw_check">
									<b>패스워드 확인</b>
									<!-- 늘리면 둘 다 오른쪽으로 -->
									<div id="pw_check_box">
										<input id="pw_check_text" type="password" minlength="6"
											maxlength="12" name="password_check" placeholder="비밀번호 재입력"
											pattern="(?=.*\d)(?=.*[a-z]).{6,12}" required="required"
											title="비밀번호를 재입력 해주세요." value="" size="40"> <br>
									</div>
								</div>
								<div class="pw_success_class" id="pw_success_id"
									style="font-size: 11px; color: green" hidden="hidden">
									비밀번호가 일치합니다.</div>
								<div class="pw_fail_class" id="pw_fail_id"
									style="font-size: 11px; color: red" hidden="hidden">비밀번호가
									일치하지 않습니다. 다시 확인해주세요.</div>


								<br> <br> <br>
								<!-- 이메일 -->
								<div id="email">
									<b  style="margin-right: 55px;">이메일</b>
									<div id="email_box">
										<!-- email -->
										<input id="email_email" class=class_email type="text"
											name="email" placeholder="이메일 입력" size="40"
											required="required">
									</div>
									
									<button type="button" id="emailCheck" >인증번호 받기</button>
								</div>
								
								<div>
								<font id="emailcheck_font" size="2"></font>
								</div>
								
									<div id="emailcode_div">
					    			<div id = emailCode_box>
					    			<input type="text" id="emailCode" name="emailCode" placeholder="인증번호 입력">
					    			<span id="emailtime" ><img id="checkimg3"></span>
	    							<span id="emailtime2" hidden=""></span>
					    			</div>
					    			<button type="button" id="request" >인증하기</button>
									</div>
					    			
					    			<br>

								<!-- 전화번호 -->
								<div id="phone">
									<b style="margin-right: 20px;">휴대폰 번호</b>
									<!-- 줄이면 간격 줄음 -->
									<div id="phone_box">
										<input id="phone_phone" type="tel" class=class_phone
											name="phone" placeholder="휴대폰 번호 입력" required="required"
											onkeyup="inputPhoneNumber(this);" size="40"
											title="010-0000-0000 형식을 맞춰주세요." />
									</div>

									<!-- <button id="repeat_check_phone" type="button"
									class=repeat_check_class>중복확인</button> -->
								</div>
								<font id="phonecheck_font" size="2"></font> <br> <br>
								


								<div id="birth">
									<b style="margin-right: 40px;">생년월일</b>


									<div id="birth_box">

										<input type="hidden" name="birth"> <input type="text"
											id="birth_yy" name="birth_yy" class="int" maxlength="4"
											placeholder="년(4자)" pattern="[0-9]{4,4}"
											title="년도를 정확히 입력해주세요. 예)2000">

										<!-- BIRTH_YY -->
										<!-- BIRTH_MM -->
										<select name="birth_mm" id="birth_mm">
											<option>월</option>
											<option value="01">1</option>
											<!-- 31 -->
											<option value="02">2</option>
											<!-- 28,29(윤년) -->
											<option value="03">3</option>
											<!-- 31 -->
											<option value="04">4</option>
											<!-- 30 -->
											<option value="05">5</option>
											<!-- 31 -->
											<option value="06">6</option>
											<!-- 30 -->
											<option value="07">7</option>
											<!-- 31 -->
											<option value="08">8</option>
											<!-- 30 -->
											<option value="09">9</option>
											<!-- 31 -->
											<option value="10">10</option>
											<!-- 30 -->
											<option value="11">11</option>
											<!-- 31 -->
											<option value="12">12</option>
											<!-- 30 -->
										</select>

										<!-- BIRTH_DD -->
										<input id="birth_dd" type="text" name="birth_dd" class="int"
											maxlength="2" placeholder="일" pattern="[0-9]{1,2}">




										<!-- 가져온거 end -->
									</div>
								</div>
								<div style="font-size: 11px; color: gray">년, 월, 일 순서대로
									작성해주세요.</div>
								<br>


								<!--가입버튼-->
								<button id="member_btn" type="submit" name="member_btn_name">회원가입</button>
							</div>
							<!-- div item -->
							
						</form>
						<div class="item"></div>
					</div>
					<!-- member_div_box -->
					<!-- 폼 종료 -->
				</div>
			</div>
			<br>
		</div>



</body>
</html>