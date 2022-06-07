$(document).on('click', '.pwfind_btn ', (function () {

 

 $('#member_id').val("");
 $('#password').val("");
 $("#modal_login").hide();
 
 $("#modal_pwfind_login").show();


}));




//신고 취소 버튼
$(document).on('click', '#modal_pwfind_login_close_btn', (function () {
	
	 //취소버튼 클릭시 내용 지우기
	 $('#member_id').val("");
	 $('#password').val("");
 
 $("#modal_pwfind_login").hide();			
}));

