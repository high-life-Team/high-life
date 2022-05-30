<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

<div id="modal_idfind">
	<div class="modal_layer">
		<div class="modal_content">
			<div class="modal_content_title">
				<h1>아이디 찾기</h1>
			</div>

			<!-- email -->
			<br>
			<div style="margin-bottom: 10px;">
				<b>이메일</b>
			</div>
			<div id="email">
				<div id="email_box">
					<input id="email_email" class=class_email type="text" name="email"
						placeholder="이메일 입력" required="required">
				</div>
				<button type="button" id="idfindemailCheck">인증번호 받기</button>
			</div>

			<!-- 이메일 인증테스트 추가 시작 -->
			<div id="email">
				<div id="idemailok_box">
					<input type="text" id="idfindemailCode" placeholder="인증번호">
					<span id="idfindemailtime"><img id="checkimg"></span> <span
						id="idfindemailtime2" hidden=""></span>
				</div>
				<button type="button" id="idfindrequest">인증하기</button>
			</div>
			<!-- 이메일 인증테스트 추가 끝-->



			<br>
			<div style="margin-bottom: 10px;">
				<b>휴대폰 번호</b>
			</div>
			<div id="phone">
				<!-- 줄이면 간격 줄음 -->
				<div id="phone_box">
					<input id="phone_phone" type="tel" class=class_phone name="phone"
						placeholder="휴대폰 번호 입력" required="required"
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
				</div>

			</div>
			<div style="font-size: 11px; color: gray">년, 월, 일 순서대로 작성해주세요.</div>
			<br>


			<div class="modal_idfind_btn">
				<button type="button" id="modal_idfind_close_btn">취소</button>
				<button type="button" id="modal_idfind_ok_btn">찾기</button>

			</div>

		</div>
	</div>
</div>

<!-- IDFIND 모달창 -->
<div id="modal_idfindresult">
	<div class="modal_layer">
		<div class="modal_content">
			<div class="modal_content_title">
				<h1>아이디 찾기</h1>
			</div>
			<br> <font id="idfindresult_font" size="2"></font> <br> <br>
			<button type="button" id="modal_idfindresult_close_btn">확인</button>
		</div>
	</div>
</div>
