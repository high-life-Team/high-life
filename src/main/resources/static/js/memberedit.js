var nicknamecheck = 2;
var pwcheck = 2;


$(document).ready(function(){

//<!-- 닉네임 중복 체크 -->
$("input[name=nickname]").keyup(function(){
	let id = $('#nickname_id').val();
	if(id=="" || id.length <2){
		$("#nicknamecheck_font").html('2자 이상의 닉네임을 입력해주세요. (한글, 영문, 숫자)');
		$("#nicknamecheck_font").css('color', 'gray');
		$("#nicknamecheck_font").css('font-size', '20px');
	}
	else{
	console.log(id);
	
	$.ajax({
		url : "/membercheck_nickname",
		type : "post",
		data :{'nickname': id},
		dataType : 'json',
		success : function(result){
			console.log(result);
			if(result == 0){
				$("#nicknamecheck_font").html('사용할 수 있는 닉네임 입니다.');
				$("#nicknamecheck_font").css('color', 'green');
				$("#nicknamecheck_font").css('font-size', '20px');
				nicknamecheck = 1;
				
			}
			else if( $("#nicknamecheck1").val() ==  $("input[name=nickname]").val()){
				$("#nicknamecheck_font").html('현재 닉네임과 동일합니다.');
				$("#nicknamecheck_font").css('color', 'green');
				$("#nicknamecheck_font").css('font-size', '20px');
				nicknamecheck = 1;
				
			}
			else{
				$("#nicknamecheck_font").html('사용할 수 없는 닉네임 입니다.');
				$("#nicknamecheck_font").css('color', 'red');
				$("#nicknamecheck_font").css('font-size', '20px');
				nicknamecheck = 2;
				
				console.log("내 아이디 : " + $("#nicknamecheck1").val());
				console.log("입력 아이디 : " + $("input[name=nickname]").val());
			}
		},
		error : function(){
			alert("서버요청실패");
		}
	});//ajax
	}
})
//<!-- 닉네임 중복 체크 END -->

//<!-- 이메일 중복 체크 -->
$("input[name=email]").keyup(function(){
	let id = $('#email_id').val();
	let emailYN = isEmail(id);
	if(id=="" || id.length <2){
		$("#emailcheck_font").html('이메일을 입력해주세요.');
		$("#emailcheck_font").css('color', 'gray');
		$("#emailcheck_font").css('font-size', '20px');
	}
	else{
	console.log(id);
	
	$.ajax({
		url : "/membercheck_email",
		type : "post",
		data :{'email': id},
		dataType : 'json',
		success : function(result){
			console.log(result);
			if(result == 0 && emailYN == true){
				$("#emailcheck_font").html('사용할 수 있는 이메일 입니다.');
				$("#emailcheck_font").css('color', 'green');
				$("#emailcheck_font").css('font-size', '20px');
				nicknamecheck = 1;
				
			}
			else if( $("#emailcheck1").val() ==  $("input[name=email]").val()){
				$("#emailcheck_font").html('현재 이메일과 동일합니다.');
				$("#emailcheck_font").css('color', 'green');
				$("#emailcheck_font").css('font-size', '20px');
				nicknamecheck = 1;
				
			}
			else{
				$("#emailcheck_font").html('사용할 수 없는 이메일 입니다.');
				$("#emailcheck_font").css('color', 'red');
				$("#emailcheck_font").css('font-size', '20px');
				emailcheck = 2;
				
				console.log("내 이메일 : " + $("#emailcheck1").val());
				console.log("입력 이메일 : " + $("input[name=email]").val());
			}
		},
		error : function(){
			alert("서버요청실패");
		}
	});//ajax
	}
})
//<!-- 이메일 중복 체크 END -->

//<!-- 이메일 유효성 검사 시작-->
	function isEmail(asValue){ 
		var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		return regExp.test(asValue); // 형식에 맞는 경우 true 리턴
	}
//<!-- 이메일 유효성 검사 종료-->

//정규표현식
$("input[name=nickname]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^a-zA-Z가-힣ㄱ-ㅎ0-9]/gi,''));
	}
	});
	
//회원정보수정 버튼 function
$("#editcomple").on('click', function(ev){

if(nicknamecheck==2){
	alert("닉네임을 확인해주세요.");
	ev.preventDefault();
}

else if(pwcheck==2){
	alert("비밀번호를 확인해주세요.");
	ev.preventDefault();
}

if (nicknamecheck==1 && pwcheck==1) {
	alert("회원정보가 정상적으로 수정되었습니다!! 다시 로그인 부탁드립니다.");
}
}); //회원가입 버튼 function END


/*썸네일 END*/




}) //ready function END

//<!-- 비밀번호 중복체크 -->
$(function(){
	$("#pw_success_id").hide();
	$("#pw_fail_id").hide();
	$("input").keyup(function(){
		var pw_text=$("#password_id").val();
		var pw_check_text=$("#repassword_id").val();
		
		
		if(pw_text != "" || pw_check_text != ""){
			if(pw_text == pw_check_text){
				$("#memberedit_success_id").show();
				$("#memberedit_fail_id").hide();
				pwcheck=1;
				
			}else{
				$("#memberedit_success_id").hide();
				$("#memberedit_fail_id").show();
				pwcheck=2;
				
			}
		}
	});
})
//<!-- 비밀번호 중복체크 END -->

