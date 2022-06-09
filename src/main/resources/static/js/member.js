var idcheck = 2;
var nicknamecheck = 2;
var pwcheck = 2;
var emailcheck = 2;


//회원가입
$(document).on('click', '.member_btn, #front_member_modal', (function () {
 
 
 $("#modal_member").show();

}));

//아이디 찾기 취소
$(document).on('click', '#modal_member_close_btn', (function () {
	
	//닫을 때 내용 지우기
	$('#member_id_id').val("");
	$('#nickname_id').val("");
	$('#email_id').val("");
	$('#password_id').val("");
	$('#repassword_id').val(""); 
	
	/* 성공여부 닫기 */
	$("#pw_success_id").hide(); 
 	$("#pw_fail_id").hide();
	$("#idcheck_font").hide();
 	$("#nickname_font").hide();
 	$("#email_font").hide();
 	
 	
 	//모달창 닫기
	$("#modal_member").hide(); 
 	
}));


//ready function start

$(document).ready(function(){
$("input[name=member_id_name]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^a-z0-9]/gi,''));
	}
	});

$("input[name=nickname_name]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^a-zA-Z가-힣ㄱ-ㅎ0-9]/gi,''));
	}
	});

$("input[name=email_name]").keyup(function(event){
	 if (!(event.keyCode >=37 && event.keyCode<=40)) {
		var inputVal = $(this).val();
		$(this).val(inputVal.replace(/[^a-z0-9@.]/gi,''));
	}
	});

//아이디 중복 체크
$("input[name=member_id]").keyup(function(){
	let id = $('#member_id_id').val();
	console.log(id);
	
	if(id.length < 5){
		$("#member_idcheck_font").html('5자 이상의 아이디를 입력해주세요. (영문, 숫자)');
		$("#member_idcheck_font").css('color', 'gray');
		$("#member_idcheck_font").css('font-size', '20px');
	}
	else{
	$.ajax({
		url : "/membercheck",
		type : "post",
		data :{member_id : id},
		dataType : 'json',
		success : function(result){
			if(result == 0){
				$("#member_idcheck_font").html('사용할 수 있는 아이디 입니다.');
				$("#member_idcheck_font").css('color', 'green');
				$("#member_idcheck_font").css('font-size', '20px');
				idcheck = 1;
			} else{
				$("#member_idcheck_font").html('사용할 수 없는 아이디 입니다.');
				$("#member_idcheck_font").css('color', 'red');
				$("#member_idcheck_font").css('font-size', '20px');
				idcheck = 2;
			}
		},
		error : function(){
			alert("서버요청실패");
		}
	});//ajax
	}
})
//아이디 중복 체크 END

//<!-- 닉네임 중복 체크 -->
$("input[name=nickname]").keyup(function(){
	let id = $('#nickname_id').val();
	if(id.length <2){
		$("#member_nickname_font").html('2자 이상의 닉네임을 입력해주세요. (한글, 영문, 숫자)');
		$("#member_nickname_font").css('color', 'gray');
		$("#member_nickname_font").css('font-size', '20px');
	}
	else{
	$.ajax({
		url : "/membercheck_nickname",
		type : "post",
		data :{nickname: id},
		dataType : 'json',
		success : function(result){
			if(result == 0){
				$("#member_nickname_font").html('사용할 수 있는 닉네임 입니다.');
				$("#member_nickname_font").css('color', 'green');
				$("#member_nickname_font").css('font-size', '20px');
				nicknamecheck = 1;
			} else{
				$("#member_nickname_font").html('사용할 수 없는 닉네임 입니다.');
				$("#member_nickname_font").css('color', 'red');
				$("#member_nickname_font").css('font-size', '20px');
				nicknamecheck = 2;
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
	if(id.length<2){
		$("#member_email_font").html('이메일을 입력해주세요.');
		$("#member_email_font").css('color', 'gray');
		$("#member_email_font").css('font-size', '20px');
		
	}
	
	else{	
	$.ajax({
		url : "/membercheck_email",
		type : "post",
		data :{'email': id},
		dataType : 'json',
		success : function(result){
			if(result == 0 && emailYN == true){
				$("#member_email_font").html('사용할 수 있는 이메일 입니다.');
				$("#member_email_font").css('color', 'green');
				$("#member_email_font").css('font-size', '20px');
				emailcheck = 1;
				
			} else{
				$("#member_email_font").html('사용할 수 없는 이메일 입니다.');
				$("#member_email_font").css('color', 'red');
				$("#member_email_font").css('font-size', '20px');
				emailcheck = 2;
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


//회원가입 버튼 function
$("#button_signup").on('click', function(ev){
if(idcheck==2){
	alert("아이디를 확인해주세요.");
	ev.preventDefault();
}

})


}) //ready function end


//<!-- 비밀번호 중복체크 -->
$(function(){
	$("#pw_success_id").hide();
	$("#pw_fail_id").hide();
	$("input").keyup(function(){
		var pw_text=$("#password_id").val();
		var pw_check_text=$("#repassword_id").val();
		if(pw_text != "" || pw_check_text != ""){
			if(pw_text == pw_check_text){
				$("#pw_success_id").show();
				$("#pw_fail_id").hide();
				pwcheck=1;
				
			}else{
				$("#pw_success_id").hide();
				$("#pw_fail_id").show();
				pwcheck=2;
				
			}
		}
	});
})
//<!-- 비밀번호 중복체크 END -->