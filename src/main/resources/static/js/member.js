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

