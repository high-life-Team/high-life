<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<meta http-equiv='X-UA-Compatible' content='IE=edge'>
<title>한데모아 - 회원정보수정</title>
<link rel='stylesheet' type='text/css' href='/css/index.css'>
<link rel='stylesheet' type='text/css' href='/css/memberedit.css'>


<!-- 노토산스 폰트 시작-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">
<!-- 노토산스 폰트 종료-->
<script src="/jquery-3.6.0.min.js"></script>
<script src='/js/index.js'></script>
<script src='/js/memberedit.js'></script>


</head>
<body>
	<div class="container">
		<!-- 네비게이션 start -->
		<div id="nav_area">
			<div id="nav_space">
				<div id="logo">
					<a href="/handemoa"> <img src="css/images/logo.png" />
					</a>
				</div>
				<div id="nav_profile">
					<div id="nav_profile_img">
						<img src="css/images/${member.profileimg}"
							style="border-radius: 80%;" width="100%" />
					</div>
					<c:choose>
						<c:when test="${isLogOn == true && member!= null}">

							<a href="/profile?nickname=${member.nickname}">
							<h3	style="text-align: center;">${member.nickname} 님</h3></a>
							<div style="display: flex;">
								<button id="nav_login_btn" onclick="location.href='/logout'"
									style="color: white; background-color: #ce4764">로그아웃</button>
								<button id="nav_login_btn" onclick="location.href='/memberedit'"
									style="color: white; background-color: gray; margin-left: 10px; font-size: 5px;">회원정보수정</button>

							</div>
						</c:when>
						<c:otherwise>
							<button id="nav_login_btn" onclick="location.href='/login'">로그인</button>
						</c:otherwise>
					</c:choose>
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
				<div class="inner_space"></div>
				<div id="content">
					<!-- 여기서 내용 시작 -->
					<div id="memberedit_container">

						<div id="memberedit_post_list_area">
							<div id="memberimg_text">
								<br> <br>
								
									<b
										style="color: red; font-size: 20px; letter-spacing: -0.03em;">프로필
										사진 변경</b> <br> <br>
									<div id="profileimg_text">
										<form id="profileimg_form" enctype="multipart/form-data"
											onsubmit="return false">
											
												<div id="profileimg_preview_area">
													<img class="profileimg_preview"
														src="css/images/login_before.png" />
												</div>
												<br>
											
											<input type=file name="profileimgadd">
											<!-- 한개 -->
											<button id="profileimg_preview_btn">프로필 미리보기</button>
											<button id="profileimg_btn">프로필 등록</button>
										</form>
										<!-- <input id=fileatt_text> <input
											id="fileatt_btn" type="file"> <br> -->
										<div style="font-size: 80%; margin-top: 10px;">300kb 이하의
											PNG, JPG, SVG, GIF파일만 가능합니다</div>
									</div>

								
								<br>

								

								<form action="memberedit" class="signup_form" method="post">
									<input type="hidden" name="profileimg" value="login_before.png"
										id="profileimg">



									<div style="font-size: 80%">
										<div id="intromyself_container" class="container">
											<div class="item">
												<textarea id="intromyself" name="intro">${member.intro}</textarea>
											</div>
											<div class="item"></div>

										</div>
									</div>

									<!--  onsubmit="checkAll()" -->
									<!-- 폼 시작 -->
									<!-- ID -->
									<div class="item">
										<!-- 2번째 item -->
										<div id="id">
											<b style="margin-right: 20px;">회원 아이디</b>
											<div id="id_box">
												<input id=id_id type=text class=class_id
													placeholder="${member.id}" size="40" value="${member.id}"
													disabled> <input type=text class=class_id
													value="${member.id}" hidden="hidden" name="id">
											</div>
										</div>

										<font id="idcheck_font" size="2"></font> <br>
										<!-- nickname -->
										<div id="nickname">
										<input id="nicknamecheck1" hidden="hidden" value="${member.nickname}"></input>
											<b style="margin-right: 55px;">닉네임</b>
											<div id="nickname_box">
												<input id=nickname_nickname class=class_nickname type=text
													minlength="2" maxlength="12" size="40" name="nickname"
													required="required" pattern="[a-zA-Z0-9가-힣]{2,12}"
													placeholder="현재 닉네임 : ${member.nickname}"
													title="2~12자의 한글,영문,숫자만 가능합니다.">
											</div>
											<!-- <button id="nickname_change_btn" type="button">중복확인</button> -->

										</div>
										<font id="nicknamecheck_font" size="2"
											style="margin-left: 100px;"></font> <br> <br>

										<div id="pw">
											<b style="margin-right: 40px;">패스워드</b>
											<!-- 픽셀 줄이면 간격 줄어들음 -->
											<div id="pw_box">
												<!--PW-->
												<input id="pw_text" type="password" minlength="6"
													maxlength="12" name="password"
													pattern="(?=.*\d)(?=.*[a-z]).{6,12}" required="required"
													title="6~12자 영문 소문자와 숫자 조합을 사용하세요." value="" size="40">
											</div>
										</div>


										<br>
										<!--PW_CHECK 비밀번호 재확인 이후 js 사용 -->
										<div id="pw_check">
											<b>패스워드 확인</b>
											<!-- 늘리면 둘 다 오른쪽으로 -->
											<div id="pw_check_box">
												<input id="pw_check_text" type="password" minlength="6"
													maxlength="12" name="password_check"
													pattern="(?=.*\d)(?=.*[a-z]).{6,12}" required="required"
													value="" size="40"> <br>
											</div>
										</div>
										<div class="pw_success_class" id="pw_success_id"
											style="font-size: 11px; color: green; margin-left: 100px;"
											hidden="hidden">비밀번호가 일치합니다.</div>
										<div class="pw_fail_class" id="pw_fail_id"
											style="font-size: 11px; color: red; margin-left: 100px;"
											hidden="hidden">비밀번호가 일치하지 않습니다. 다시 확인해주세요.</div>


										<br> <br>
										<!-- 이메일 -->
										<div id="email">
											<b style="margin-right: 55px;">이메일</b>
											<div id="email_box">
												<!-- email -->
												<input id="email_email" class=class_email type="text"
													name="email" placeholder="${member.email}" disabled>
											</div>


										</div>
										<font id="emailcheck_font" size="2"></font> <br>

										<!-- 전화번호 -->
										<div id="phone">
										<input id="phonecheck1" hidden="hidden" value="${member.phone}"></input>
											<b style="margin-right: 20px;">휴대폰 번호</b>
											<!-- 줄이면 간격 줄음 -->
											<div id="phone_box">
												<input id="phone_phone" type="tel" class=class_phone
													name="phone" required="required"
													onkeyup="inputPhoneNumber(this);" size="40"
													title="010-0000-0000 형식을 맞춰주세요."
													placeholder="현재 번호 : ${member.phone}" />
											</div>

											<!-- <button id="phone_change_btn" type="button"
												class=repeat_check_class>중복확인</button> -->
										</div>
										<font id="phonecheck_font" size="2"
											style="margin-left: 100px;"></font> <br> <br>
										<div id="birth">
											<b style="margin-right: 40px;">생년월일</b> <input id="birth_box"
												placeholder="${member.birth}" disabled>

										</div>

									</div>

									<br>
									<div style="float: right;"></div>
									<br>
									<br>

									<button id="memberout" onclick="memberquit()">회원탈퇴</button>

									<button id="editcomple" type="submit">수정완료</button>
								</form>
							</div>
						</div>
						<div id="membereditboard_area">
							<div id="membereditboard_area_box">
								<img class="board_profileimg" src="css/images/${member.profileimg}"/>
								
								<div></div>
								<h3>${member.nickname}</h3>
								<div></div>
								<p class="introtextarea">${member.intro}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>