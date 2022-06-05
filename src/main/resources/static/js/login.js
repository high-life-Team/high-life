
$(document).on('click', '.login_btn button', (function () {
 loginid = $('#member_id').val();
 //로그인 여부 확인
   $("#modal_logincheck").show();

 type = $(this).attr('class');
 $("#modal_login").show();

})); //신고하기 버튼 이벤트 end



//신고 취소 버튼
$(document).on('click', '#modal_login_close_btn', (function () {
 $("#modal_login").hide();			
}));

