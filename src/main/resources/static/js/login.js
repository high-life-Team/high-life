$(document).on('click', '.login_btn button', (function () {
 


 $("#modal_login").show();

})); //신고하기 버튼 이벤트 end



//로그인 x 버튼
$(document).on('click', '#modal_login_close_btn', (function () {
	
	 //취소버튼 클릭시 내용 지우기
	 $('#member_id').val("");
	 $('#password').val("");
 
 $("#modal_login").hide();			
}));

