<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 비밀번호 찾기 모달창 -->
<div id="modal_pwfind">
	<div class="modal_layer">
		<div class="modal_content">
			<div class="modal_content_title">
				<h1>비밀번호 찾기</h1>
			</div>

			<!-- id -->
			<br>
			<div style="margin-bottom: 10px;">
				<b>아이디</b>
			</div>
			<div id="id">
				<div id="pwfind_id_box">
					<input id=pwfind_id_id type=text class=class_id maxlength="20"
						size="40" name="pwfind_id" required="required"
						placeholder="아이디 입력" pattern="[a-z0-9]{5,20}"
						title="5~20자의 영문 소문자, 숫자만 가능합니다." check_result="fail" required>
				</div>
			</div>
			<!-- <button id="repeat_check" type="button" class=repeat_check_class>중복확인</button> -->

			<!-- email -->
			<br>
			<div style="margin-bottom: 10px;">
				<b>이메일</b>
			</div>
			<div id="email">
				<div id="email_box">
					<input id="pwfind_email_email" class=class_email type="text"
						name="pwfind_email" placeholder="이메일 입력" required="required">
				</div>
				<button type="button" id="pwfindemailCheck">인증번호 받기</button>
			</div>

			<!-- 이메일 인증테스트 추가 시작 -->
			<div id="email">
				<div id="pwemailok_box">
					<input type="text" id="pwfindemailCode" placeholder="인증번호">
					<span id="pwfindemailtime"><img id="checkimg2"></span> <span
						id="pwfindemailtime2" hidden=""></span>
				</div>
				<button type="button" id="pwfindrequest">인증하기</button>
			</div>
			<!-- 이메일 인증테스트 추가 끝-->



			<br>
			<div style="margin-bottom: 10px;">
				<b>휴대폰 번호</b>
			</div>
			<div id="phone">
				<!-- 줄이면 간격 줄음 -->
				<div id="phone_box">
					<input id="pwfind_phone_phone" type="tel" class=class_phone
						name="pwfind_phone" placeholder="휴대폰 번호 입력" required="required"
						onkeyup="inputPhoneNumber(this);" size="40"
						title="010-0000-0000 형식을 맞춰주세요." />
				</div>
			</div>

			<br>
			<div style="margin-bottom: 10px;">
				<b>생년월일</b>
			</div>
			<div id="birth">
				<div id="birth_box">

					<input type="hidden" name="birth"> <input type="text"
						id="pwfind_birth_yy" name="pwfind_birth_yy" class="int"
						maxlength="4" placeholder="년(4자)" pattern="[0-9]{4,4}"
						title="년도를 정확히 입력해주세요. 예)2000">

					<!-- BIRTH_YY -->
					<!-- BIRTH_MM -->
					<select name="pwfind_birth_mm" id="pwfind_birth_mm">
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
					<input id="pwfind_birth_dd" type="text" name="pwfind_birth_dd"
						class="int" maxlength="2" placeholder="일" pattern="[0-9]{1,2}">
				</div>

			</div>
			<div style="font-size: 11px; color: gray">년, 월, 일 순서대로 작성해주세요.</div>
			<br>


			<div class="modal_pwfind_btn">
				<button type="button" id="modal_pwfind_close_btn">취소</button>
				<button type="button" id="modal_pwfind_ok_btn">찾기</button>

			</div>

		</div>
	</div>
</div>


<!-- PWFIND 모달창 -->
<div id="modal_pwfindresult">
	<div class="modal_layer">
		<div class="modal_content">
			<div class="modal_content_title">
				<h1>비밀번호 찾기</h1>
			</div>
			<br> <font id="pwfindresult_font" size="2"></font> <br> <br>
			<button type="button" id="modal_pwfindresult_close_btn">확인</button>
		</div>
	</div>
</div>
