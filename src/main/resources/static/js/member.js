var idcheck = 2;
var nicknamecheck = 2;
var pwcheck = 2;
var emailcheck = 2;


//아이디 찾기
$(document).on('click', '.member_btn ', (function () {
 
 
 $("#modal_member").show();

}));

//아이디 찾기 취소
$(document).on('click', '#modal_member_close_btn', (function () {
	
	$('#member_id_id').val("");
	$('#nickname_id').val("");
	$('#email_id').val("");
	$('#password_id').val("");
	$('#repassword_id').val(""); 
 
 $("#modal_member").hide();
 $("#pw_success_id").hide();
 $("#pw_fail_id").hide();
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

}); //ready function end


//<!-- 비밀번호 중복체크 -->
$(function(){
	$("#pw_success").hide();
	$("#pw_fail").hide();
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